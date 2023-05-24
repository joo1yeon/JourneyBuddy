<template>
  <b-container id="map"></b-container>
</template>

<script>
export default {
  components: {},
  name: "TheMap",
  data() {
    return {
      container: null,
      map: null,
      infowindow: null,
      markers: [],
      positions: [],
      dots: [],
      list: [],
    };
  },
  props: {
    attractionList: Array,
    detailList: Array,
  },
  computed: {
    detail() {
      return this.detailList;
    },
  },
  created() {},
  mounted() {
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      const appKey = "76da4d3f68b56c2e06c858e365da0873";
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${appKey}&libraries=services,clusterer,drawing`;
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      document.head.appendChild(script);
    } else {
      this.initMap();
      console.log(window.kakao);
    }
  },
  watch: {
    detailList() {
      try {
        this.displayMarker(this.detail); // displayMarker 함수 호출
        this.drawLine(this.detail); // drawLine 함수 호출
      } catch (error) {
        // console.log("hey" + error);
      }
    },
  },
  methods: {
    initMap() {
      this.container = document.getElementById("map");

      const options = {
        center: new kakao.maps.LatLng(37.500613, 127.036431),
        level: 5,
      };

      this.map = new kakao.maps.Map(this.container, options);
      this.infowindow = new kakao.maps.InfoWindow();
      const zoomControl = new kakao.maps.ZoomControl();
      const mapTypeControl = new kakao.maps.MapTypeControl();

      this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
      this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      console.log(this.detail);
      if (this.detailList != undefined) {
        this.displayMarker(this.detailList); // displayMarker 함수 호출
        this.drawLine(this.detailList); // drawLine 함수 호출
      }
    },

    displayMarker(data) {
      this.removeMarker();
      this.positions = data;
      // 마커 이미지의 이미지 주소입니다
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
      for (let i = 0; i < this.positions.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        let marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: new kakao.maps.LatLng(this.positions[i].latitude, this.positions[i].longitude), // 마커를 표시할 위치
          title: this.positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, "click", () => {
          this.moveCenter(
            this.positions[i].contentId,
            this.positions[i].latitude,
            this.positions[i].longitude,
            this.positions[i].title,
            this.positions[i].addr1,
            this.positions[i].addr2,
            this.positions[i].image1,
            this.positions[i].contentTypeId
          );
        });
        marker.setMap(this.map);
        this.markers.push(marker);
      }
      if (this.positions.length != 0) {
        this.map.setCenter(new kakao.maps.LatLng(this.positions[0].latitude, this.positions[0].longitude));
      }
    },
    moveCenter(contentId, mapy, mapx, title, addr1, addr2, image, type) {
      let contentType;
      if (type == 12) {
        contentType = " - 관광지";
      } else if (type == 14) {
        contentType = " - 문화시설";
      } else if (type == 15) {
        contentType = " - 축제공연행사";
      } else if (type == 25) {
        contentType = " - 여행코스";
      } else if (type == 28) {
        contentType = " - 레포츠";
      } else if (type == 32) {
        contentType = " - 숙박";
      } else if (type == 38) {
        contentType = " - 쇼핑";
      } else if (type == 39) {
        contentType = " - 음식점";
      }
      this.map.setCenter(new kakao.maps.LatLng(mapy, mapx));
      this.infowindow.close();
      var iwContent = `
            <div style="padding:5px; margin:auto" class="row">
                <img src="${image}" height="100px" class="col-4" alt="관광지 사진" />
                <div class="col-8">
                    <p>
                        <b>
                            ${title}
                        </b>
                        ${contentType}
                    </p>
                    <span>${addr1}</span>
                    <span>${addr2}</span>
                </div>
            </div>
              `,
        // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(mapy + 0.00125, mapx); // 인포윈도우 표시
      // 인포윈도우를 생성합니다
      this.infowindow = new kakao.maps.InfoWindow({
        position: iwPosition,
        content: iwContent,
        removable: true,
        clickable: true,
      });
      kakao.maps.event.addListener(this.infowindow, "domready", () => {
        const button = document.getElementById("plan-btn");
        button.addEventListener("click", this.planModal);
      });

      // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
      this.infowindow.open(this.map);
    },
    // 기존 마커 지우기
    removeMarker() {
      for (let i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
    drawLine(items) {
      kakao.maps.load(() => {
        let markerPositions = items.map((item) => ({
          latitude: item.latitude,
          longitude: item.longitude,
        }));
        // 마커를 생성합니다
        // items.forEach((item) => {
        //   let marker = new kakao.maps.Marker({
        //     map: this.map, // 마커를 표시할 지도
        //     position: new kakao.maps.LatLng(item.latitude, item.longitude), // 마커를 표시할 위치
        //     title: item.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        //   });
        //   marker.setMap(this.map);
        //   this.markers.push(marker);
        // });

        // 선을 그립니다
        let linePath = markerPositions.map((position) => new kakao.maps.LatLng(position.latitude, position.longitude));
        let line = new kakao.maps.Polyline({
          map: this.map,
          path: linePath,
          strokeWeight: 3,
          strokeColor: "#FF0000",
          strokeOpacity: 1,
          strokeStyle: "solid",
        });
        // console.log(line.getLength());
        // this.displayCircleDot(markerPositions, line.getLength());
        line.setMap(this.map);
      });
    },
    displayCircleDot(position, distance) {
      // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
      position.forEach((element) => {
        var circleOverlay = new kakao.maps.CustomOverlay({
          content: '<span class="dot"></span>',
          position: element,
          zIndex: 1,
        });
        circleOverlay.setMap(this.map);
      });

      // 지도에 표시합니다

      if (distance > 0) {
        // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
      }
      var distanceOverlay = new kakao.maps.CustomOverlay({
        content: '<div class="dotOverlay">거리 <span class="number">' + distance + "</span>m</div>",
        position: position,
        yAnchor: 1,
        zIndex: 2,
      });

      // 지도에 표시합니다
      distanceOverlay.setMap(this.map);

      // 배열에 추가합니다
      // this.dots.push({ circle: circleOverlay, distance: distanceOverlay });
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 100%;
}
.dot {
  overflow: hidden;
  float: left;
  width: 12px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mini_circle.png");
}
.dotOverlay {
  position: relative;
  bottom: 10px;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  float: left;
  font-size: 12px;
  padding: 5px;
  background: #fff;
}
.dotOverlay:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.number {
  font-weight: bold;
  color: #ee6152;
}
.dotOverlay:after {
  content: "";
  position: absolute;
  margin-left: -6px;
  left: 50%;
  bottom: -8px;
  width: 11px;
  height: 8px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white_small.png");
}
.distanceInfo {
  position: relative;
  top: 5px;
  left: 5px;
  list-style: none;
  margin: 0;
}
.distanceInfo .label {
  display: inline-block;
  width: 50px;
}
.distanceInfo:after {
  content: none;
}
</style>
