<img src="/README_IMG/cover_image.png" />

## 여행 계획 작성 및 여행지 공유 서비스

### 프로젝트 개발 기간

`2023.05.18.` - `2023.05.26.` (2주)

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 프로젝트 개요

- [공공데이터 포털](http://data.go.kr)의 오픈 API를 활용
- 한국관광공사의 [한국관광공사\_국문 관광정보 서비스\_GW](https://www.data.go.kr/data/15101578/openapi.do)를 데이터화 하여 DB로 관리
- 해당 DB에서 관광지 데이터를 추출하여 필요한 데이터 표시
- 관광지 검색 및 여행 계획, 핫 플레이스 공유 기능을 가진 여행 테마의 웹 사이트 제작

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 프로젝트 목표

- 검색어를 기반으로 한 관광지 정보 조회 및 여행 계획 기능
- Spring Security를 활용한 전반적인 회원 관리
- 공지사항 게시판
- 파일 업/다운로드를 활용한 마이페이지
- 카카오 지도 API를 활용한 기능

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 사용 기술

### Front-End

<div>
  <img src="https://img.shields.io/badge/Vue.js [2.7.14]-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white" />
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white" />
  <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white" />
</div>

### Back-End

<div>
  <img src="https://img.shields.io/badge/Java [8]-007396?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring Boot [2.7.11]-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring Security [2.5.0]-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white" />
</div>

### Database

<div>
  <img src="https://img.shields.io/badge/MySQL [8.0.32]-4479A1?style=for-the-badge&logo=MySQL&logoColor=white" />
</div>

### VCS

<div>
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white" />
  <img src="https://img.shields.io/badge/GitLab-F05032?style=for-the-badge&logo=GitLab&logoColor=white" />
</div>

### DevTool

<div>
  <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=for-the-badge&logo=Visual Studio Code&logoColor=white" />
  <img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=white" />
  <img src="https://img.shields.io/badge/STS [3.9.14]-6DB33F?style=for-the-badge&logo=Spring&logoColor=white" />
  <img src="https://img.shields.io/badge/Work Bench [8.0]-4479A1?style=for-the-badge&logo=MySQL&logoColor=white" />
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white" />
</div>

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 서비스 화면

### 회원 관리

| 로그인                                   | 회원가입                                     |
| ---------------------------------------- | -------------------------------------------- |
| ![로그인](/README_IMG/screen/로그인.png) | ![회원가입](/README_IMG/screen/회원가입.png) |

### 마이페이지

| 조회                                       | 수정                                            |
| ------------------------------------------ | ----------------------------------------------- |
| ![조회](/README_IMG/screen/마이페이지.png) | ![수정](/README_IMG/screen/마이페이지_수정.png) |

### 여행지

여행지 선택
![여행지](/README_IMG/screen/여행지_선택.png)

여행지 상세화면 <br>
![상세](/README_IMG/screen/여행지_상세.png)

### 나의 여행 계획

목록
![목록](/README_IMG/screen/여행계획_목록.png)

상세보기
| 지도 | 일정 |
| --- | --- |
| ![지도](/README_IMG/screen/여행계획_상세보기_1.png) | ![일정](/README_IMG/screen/여행계획_상세보기_2.png) |

### 핫플레이스

등록
![등록](/README_IMG/screen/핫플레이스_등록.png)

목록
![목록](/README_IMG/screen/핫플레이스_목록.png)

### 공지사항

![작성](/README_IMG/screen/공지사항_작성.png)

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 산출물

### 화면 흐름도

![화면흐름도](/README_IMG/화면흐름도.png)

### ERD

![ERD-Diagram](/README_IMG/DB/ERD%20Diagram.png)

### Class Diagram

| attraction (관광지)                                           | noitce (공지사항)                                         |
| ------------------------------------------------------------- | --------------------------------------------------------- |
| ![attraction](/README_IMG/Class_Diagram/class_diagram_01.PNG) | ![notice](/README_IMG/Class_Diagram/class_diagram_03.PNG) |

| hotplace (핫 플레이스)                                   | plan (여행 계획)                                       |
| -------------------------------------------------------- | ------------------------------------------------------ |
| ![notice](README_IMG/Class_Diagram/class_diagram_04.PNG) | ![plan](README_IMG/Class_Diagram/class_diagram_05.PNG) |

| user (사용자)                                          | etc (기타 설정 파일)                                   |
| ------------------------------------------------------ | ------------------------------------------------------ |
| ![user](README_IMG/Class_Diagram/class_diagram_06.PNG) | ![etc](/README_IMG/Class_Diagram/class_diagram_02.PNG) |

### 시스템 아키텍처

![시스템 아키텍처](/README_IMG/시스템구조도.png)

<br>

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Pushpin.png" alt="Pushpin" width="25" height="25" /> 팀원

| 연주원                                                                                                                                                                                                                     | 진병욱                                                                                                                                                                                             |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Grinning%20Face%20with%20Smiling%20Eyes.png" alt="Grinning Face with Smiling Eyes" width="150" height="150" /> | <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Slightly%20Smiling%20Face.png" alt="Slightly Smiling Face" width="150" height="150" /> |
| 팀장 <br>회원 관리 <br>핫플레이스 <br>최종 발표                                                                                                                                                                            | 팀원 <br>관광지 <br>여행 계획 <br>공지사항                                                                                                                                                         |
