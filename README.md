# 🛬 우리들의 여행 친구 Journey Buddy !!! 🛫

## 팀원

- 연주원 (팀장)
- 진병욱 (팀원)

---

## 프로젝트 개요

- [공공데이터 포털](http://data.go.kr)의 오픈 API를 활용
- 한국관광공사의 [한국관광공사\_국문 관광정보 서비스\_GW](https://www.data.go.kr/data/15101578/openapi.do)를 데이터화 하여 mysql에서 DB로 관리
- 해당 DB에서 관광지 데이터를 추출하여 필요한 데이터 표시
- 관광지 검색 및 여행 계획, 핫 플레이스 공유 기능을 가진 여행 테마의 웹 사이트 제작

---

## 프로젝트 목표

- 검색어를 기반으로 한 관광지 정보 도출 및 여행 계획, 핫 플레이스
- 스프링 시큐리티를 활용하여 전반적인 로그인 세션 관리
- 메인 공지사항을 이용한 공지사항 게시판
- 파일 업/다운로드를 활용한 마이페이지
- 카카오 API를 활용한 카카오 맵
- 네이버 API를 활용한 네이버 로그인

---

## 사용 기술

### Front-End

<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white" />
<img src="https://img.shields.io/badge/Vue.js [2.7.14]-4FC08D?style=flat&logo=Vue.js&logoColor=white" />

### Back-End

<img src="https://img.shields.io/badge/Java [8]-007396?style=flat&logo=Java&logoColor=white" />
<img src="https://img.shields.io/badge/Spring [5.3.27]-6DB33F?style=flat&logo=Spring&logoColor=white" />
<img src="https://img.shields.io/badge/Spring Boot [2.7.11]-6DB33F?style=flat&logo=Spring Boot&logoColor=white" />
<img src="https://img.shields.io/badge/Spring Security [2.5.0]-6DB33F?style=flat&logo=Spring Security&logoColor=white" />

### DataBase

<img src="https://img.shields.io/badge/MySQL [8.0.32]-4479A1?style=flat&logo=MySQL&logoColor=white" />

### DevTool

<img src="https://img.shields.io/badge/
Visual Studio Code-007ACC?style=flat&logo=
Visual Studio Code&logoColor=white" />
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat&logo=Eclipse IDE&logoColor=white" />
<img src="https://img.shields.io/badge/STS [3.9.14]-6DB33F?style=flat&logo=Spring&logoColor=white" />
<img src="https://img.shields.io/badge/Work Bench [8.0]-4479A1?style=flat&logo=MySQL&logoColor=white" />
<img src="https://img.shields.io/badge/Git-F05032?style=flat&logo=Git&logoColor=white" />

---

## 역할

- 연주원 (팀장)
  - 로그인 및 회원관리
  - 마이페이지
  - 핫 플레이스
- 진병욱 (팀원)
  - 관광지
  - 여행 계획
  - 공지사항

---

## 요구사항 명세서

## ERD Digaram

![ERD-Diagram](/README_IMG/DB/ERD%20Diagram.png)

## Class Diagram

### attraction (관광지)

![attraction](/README_IMG/Class_Diagram/class_diagram_01.PNG)

### noitce (공지사항)

![notice](/README_IMG/Class_Diagram/class_diagram_03.PNG)

### hotplace (핫 플레이)

![notice](README_IMG/Class_Diagram/class_diagram_04.PNG)

### plan (여행 계획)

![plan](README_IMG/Class_Diagram/class_diagram_05.PNG)

### user (사용자)

![user](README_IMG/Class_Diagram/class_diagram_06.PNG)

### etc (기타 설정 파일)

![etc](/README_IMG/Class_Diagram/class_diagram_02.PNG)

---
