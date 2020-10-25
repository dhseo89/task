# 프로젝트 빌드 및 실행

* Springboot 2.3.4
* Java 8
* Maven	
* Postgresql 12.4


## DBMS 설치 및 설정
1. DBMS 설치 
	[URL]: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
2. user 생성, database 생성
	- 기본 설정으로 설치
	- Port: 5432 (기본)으로 설치
	* pgAdmin 접속
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101602-43bfdf00-16e2-11eb-8990-dd3fb11e4e21.png)
	_ _ _ _ _
	_ _ _ _ _
	* user 생성
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101606-46223900-16e2-11eb-9876-7a7886bc6bab.png)
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101607-47536600-16e2-11eb-87c8-db88b8206ce9.JPG)
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101611-48849300-16e2-11eb-9bd2-79f1175335d3.JPG)
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101608-47536600-16e2-11eb-9ef6-cc1f0db1d002.JPG)	
	_ _ _ _ _
	_ _ _ _ _
	* database 생성
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101609-47ebfc80-16e2-11eb-8229-814db0d0de88.png)
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101610-47ebfc80-16e2-11eb-9c7d-8779cb29a531.JPG)
	_ _ _ _ _
	_ _ _ _ _
	* create ddl 스크립트 실행
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101612-4a4e5680-16e2-11eb-928f-563dd1efee31.png)
	_ _ _ _ _
	* 내용 복사
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101613-4ae6ed00-16e2-11eb-826d-ef0041659b9c.JPG)
	_ _ _ _ _
	* 전체 선택 후 버튼 클릭
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101614-4b7f8380-16e2-11eb-9d1d-51189e91979d.png)
	_ _ _ _ _
	_ _ _ _ _

## Lombok 설치
*  Lombok 설치 URL: https://congsong.tistory.com/31
*  [Annotation 에러가 나는 경우] 
	1. Maven Update 후 이클립스 재시작
	2. Build Automatilcally 해제 -> Project Clean -> Build Automatilcally 체크 

## Eclipse 설정
  
  Maven -> Update Project
  _ _ _ _ _
  ![](https://user-images.githubusercontent.com/16385765/97101600-41f61b80-16e2-11eb-9169-69b6eb177091.jpg)
  _ _ _ _ _
  _ _ _ _ _
  Project -> Build Automatically Check
  _ _ _ _ _
  ![](https://user-images.githubusercontent.com/16385765/97101601-43274880-16e2-11eb-9394-b846fa076f18.jpg)
  _ _ _ _ _
  _ _ _ _ _
  

## 테스트 방법

* 해당 프로젝트 우클릭 -> Run As -> Spring Boot App 클릭
* [API 명세서 및 테스트 페이지 접속]  http://localhost:8003/swagger-ui.html
	* [ID: test  PW: 1234]
	_ _ _ _ _
	![](https://user-images.githubusercontent.com/16385765/97101615-4c181a00-16e2-11eb-980a-4255a94adcbe.JPG)
	_ _ _ _ _