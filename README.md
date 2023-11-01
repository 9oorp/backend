# 9oorp

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/6faa0a49-e25e-4670-be2c-0e901e009b9c"></div>


## 프로젝트 소개
9oorp 서비스는 구름톤 트레이닝 플레이어들이 간편하게 스터디와 프로젝트를 구할 수 있게 도와주는 서비스입니다.

[9oorp](http://9oorp.store/) (2023.10.06 ~ )


## 시스템 아키텍처
<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/9db43c34-017b-431e-9313-241d86e7c228"></div>



## TECH STACKS

|Frontend|Backend|Database&Storage|DevOps| 
| :----: | :---: |   :---------:  | :--: |
|<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white"><br><img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=Redux&logoColor=white"><br><img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=TypeScript&logoColor=white"><br><img src="https://img.shields.io/badge/Tailwind CSS-06B6D4?style=for-the-badge&logo=Tailwind CSS&logoColor=white"><br>|<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"><br><img src="https://img.shields.io/badge/Spring-37814A?style=for-the-badge&logo=Spring&logoColor=white"><br><img src="https://img.shields.io/badge/SpringBoot-85EA2D.svg?style=for-the-badge&logo=SpringBoot&logoColor=white">|<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><br><img src="https://img.shields.io/badge/Amazon RDS-527FFF?style=for-the-badge&logo=Amazon RDS&logoColor=white"><br>|<img src="https://img.shields.io/badge/Amazon EC2 -FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"><br><img src="https://img.shields.io/badge/Github Actions-2088FF?style=for-the-badge&logo=Github Actions&logoColor=white"><br><img src="https://img.shields.io/badge/Amazon S3-569A31?style=for-the-badge&logo=Amazon S3&logoColor=white"><br> |


## Submodule Directories & documents

<details>
<summary> FRONTEND </summary>
 
 ```sh
    📦frontend
     ┣ 📂public
     ┃ ┣ 📜favicon.ico
     ┃ ┣ 📜index.html
     ┃ ┣ 📜logo192.png
     ┃ ┣ 📜logo512.png
     ┃ ┣ 📜manifest.json
     ┃ ┗ 📜robots.txt
     ┣ 📂src
     ┃ ┣ 📂assets
     ┃ ┃ ┣ 📜aws.png
     ┃ ┃ ┣ 📜box-arrow-up-right.svg
     ┃ ┃ ┣ 📜burger-menu.svg
     ┃ ┃ ┣ 📜chevron_left.svg
     ┃ ┃ ┣ 📜chevron_right.svg
     ┃ ┃ ┣ 📜close-outlined.svg
     ┃ ┃ ┣ 📜docker.png
     ┃ ┃ ┣ 📜down-outlined.svg
     ┃ ┃ ┣ 📜java.png
     ┃ ┃ ┣ 📜javascript.png
     ┃ ┃ ┣ 📜kubernetes.png
     ┃ ┃ ┣ 📜logo.png
     ┃ ┃ ┣ 📜python.png
     ┃ ┃ ┣ 📜react.png
     ┃ ┃ ┣ 📜redux.png
     ┃ ┃ ┣ 📜search-outlined.svg
     ┃ ┃ ┣ 📜spring.png
     ┃ ┃ ┣ 📜tensorflow.png
     ┃ ┃ ┗ 📜typescript.png
     ┃ ┣ 📂components
     ┃ ┃ ┣ 📂auth
     ┃ ┃ ┃ ┣ 📜authModal.tsx
     ┃ ┃ ┃ ┗ 📜sideMenu.tsx
     ┃ ┃ ┣ 📜card.tsx
     ┃ ┃ ┣ 📜dynamicImage.tsx
     ┃ ┃ ┣ 📜Header.tsx
     ┃ ┃ ┣ 📜Input.tsx
     ┃ ┃ ┣ 📜item.tsx
     ┃ ┃ ┣ 📜Layout.tsx
     ┃ ┃ ┣ 📜multiSelect.tsx
     ┃ ┃ ┣ 📜projectStudy.tsx
     ┃ ┃ ┣ 📜searchBar.tsx
     ┃ ┃ ┣ 📜singleSelect.tsx
     ┃ ┃ ┗ 📜toggle.tsx
     ┃ ┣ 📂declarations
     ┃ ┃ ┗ 📜draftjs-to-html.d.ts
     ┃ ┣ 📂libs
     ┃ ┃ ┣ 📜arrToString.ts
     ┃ ┃ ┣ 📜parseJwt.ts
     ┃ ┃ ┗ 📜utils.ts
     ┃ ┣ 📂pages
     ┃ ┃ ┣ 📜Main.tsx
     ┃ ┃ ┣ 📜NotFount.tsx
     ┃ ┃ ┣ 📜PostDetail.tsx
     ┃ ┃ ┣ 📜PostEdit.tsx
     ┃ ┃ ┗ 📜PostRegister.tsx
     ┃ ┣ 📂store
     ┃ ┃ ┣ 📂modules
     ┃ ┃ ┃ ┣ 📜curriculum.ts
     ┃ ┃ ┃ ┣ 📜index.ts
     ┃ ┃ ┃ ┗ 📜user.ts
     ┃ ┃ ┗ 📜index.ts
     ┃ ┣ 📂types
     ┃ ┃ ┣ 📜images.d.ts
     ┃ ┃ ┗ 📜index.ts
     ┃ ┣ 📜App.css
     ┃ ┣ 📜App.tsx
     ┃ ┣ 📜index.css
     ┃ ┣ 📜index.tsx
     ┃ ┗ 📜react-app-env.d.ts
     ┣ 📜.env
     ┣ 📜.env.production
     ┣ 📜.gitignore
     ┣ 📜package-lock.json
     ┣ 📜package.json
     ┣ 📜README.md
     ┣ 📜tailwind.config.js
     ┗ 📜tsconfig.json
 ```
 </details>


<details>
<summary> BACKEND </summary>
 
 ```sh
    📦backend
     ┣ 📂build
     ┃ ┣ 📂classes
     ┃ ┃ ┗ 📂java
     ┃ ┃ ┃ ┗ 📂main
     ┃ ┃ ┃ ┃ ┗ 📂com
     ┃ ┃ ┃ ┃ ┃ ┗ 📂goorp
     ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂backend
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜homeController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplication.class
     ┃ ┣ 📂generated
     ┃ ┃ ┗ 📂sources
     ┃ ┃ ┃ ┣ 📂annotationProcessor
     ┃ ┃ ┃ ┃ ┗ 📂java
     ┃ ┃ ┃ ┃ ┃ ┗ 📂main
     ┃ ┃ ┃ ┗ 📂headers
     ┃ ┃ ┃ ┃ ┗ 📂java
     ┃ ┃ ┃ ┃ ┃ ┗ 📂main
     ┃ ┣ 📂tmp
     ┃ ┃ ┗ 📂compileJava
     ┃ ┃ ┃ ┗ 📜previous-compilation-data.bin
     ┃ ┗ 📜.DS_Store
     ┣ 📂gradle
     ┃ ┗ 📂wrapper
     ┃ ┃ ┣ 📜gradle-wrapper.jar
     ┃ ┃ ┗ 📜gradle-wrapper.properties
     ┣ 📂out
     ┃ ┣ 📂production
     ┃ ┃ ┣ 📂classes
     ┃ ┃ ┃ ┗ 📂com
     ┃ ┃ ┃ ┃ ┗ 📂goorp
     ┃ ┃ ┃ ┃ ┃ ┗ 📂backend
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂configuration
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EncoderConfig.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtExceptionFilter.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtFilter.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberDetails.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationTestController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenController.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment$CommentBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum$CurriculumBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Member$MemberBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Member.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Post$PostBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Post.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiErrorResponseDto$ApiErrorResponseDtoBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiErrorResponseDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiResponseDto$ApiResponseDtoBuilder.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiResponseDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRequestDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentResponseDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberJoinDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberLoginDto.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostRequestDTO.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostResponseDTO.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentException.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCode.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExceptionManager.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberException.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostException.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRepository.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CurriculumRepository.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberRepository.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostRepository.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostSpecification.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentService.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostService.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtUtil.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplication.class
     ┃ ┃ ┗ 📂resources
     ┃ ┃ ┃ ┣ 📜application.yml
     ┃ ┃ ┃ ┗ 📜errors.properties
     ┃ ┗ 📂test
     ┃ ┃ ┗ 📂classes
     ┃ ┃ ┃ ┣ 📂com
     ┃ ┃ ┃ ┃ ┗ 📂goorp
     ┃ ┃ ┃ ┃ ┃ ┗ 📂backend
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BackendApplicationTests.class
     ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostTest.class
     ┃ ┃ ┃ ┗ 📂generated_tests
     ┣ 📂src
     ┃ ┣ 📂main
     ┃ ┃ ┣ 📂generated
     ┃ ┃ ┣ 📂java
     ┃ ┃ ┃ ┗ 📂com
     ┃ ┃ ┃ ┃ ┗ 📂goorp
     ┃ ┃ ┃ ┃ ┃ ┗ 📂backend
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebConfig.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂configuration
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EncoderConfig.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtExceptionFilter.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtFilter.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberDetails.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityConfig.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationTestController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenController.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Comment.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Curriculum.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Member.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Post.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiErrorResponseDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiResponseDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRequestDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentResponseDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberJoinDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberLoginDto.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostRequestDTO.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostResponseDTO.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentException.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCode.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExceptionManager.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberException.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostException.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentRepository.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CurriculumRepository.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberRepository.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostRepository.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostSpecification.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommentService.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostService.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtUtil.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplication.java
     ┃ ┃ ┗ 📂resources
     ┃ ┃ ┃ ┣ 📂static
     ┃ ┃ ┃ ┣ 📂templates
     ┃ ┃ ┃ ┣ 📜application.yml
     ┃ ┃ ┃ ┗ 📜errors.properties
     ┃ ┣ 📂test
     ┃ ┃ ┗ 📂java
     ┃ ┃ ┃ ┗ 📂com
     ┃ ┃ ┃ ┃ ┗ 📂goorp
     ┃ ┃ ┃ ┃ ┃ ┗ 📂backend
     ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
     ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberControllerTest.java
     ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BackendApplicationTests.java
     ┃ ┗ 📜.DS_Store
     ┣ 📜.DS_Store
     ┣ 📜.gitignore
     ┣ 📜README.md
     ┣ 📜build.gradle
     ┣ 📜gradlew
     ┣ 📜gradlew.bat
     ┗ 📜settings.gradle
 ```
 </details>

### 협업툴

Github-flow 브랜치 전략를 사용해서 협업하고 git Projects를 사용해서 1주단위로 스프린트를 관리했습니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/b230d24c-ad37-4e1c-90d9-0e9dc6791fa3"></div>


### API 명세서

gitbook을 사용해서 API 명세서를 작성했습니다.


[api 명세서](https://9oorp.gitbook.io/ver1/)

API 명세서 예시
<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/0e6ef6d2-577d-409e-978d-1e15f8882bf4" width="500"></div>


 ### ERD

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/8fdfc209-641a-4fb3-bd82-d3fcb067509a"></div>


## 기능 소개

### 회원가입/로그인

<div align="center"><img src="https://github.com/9oorp/9oorp/assets/83001865/b172fac8-7daa-4f51-897c-e66607f6d458"></div>

### 포스트 필터링

<div align="center"><img src="https://github.com/9oorp/9oorp/assets/83001865/30dcca58-3867-4081-9126-348bd6c9043b"></div>

### 포스트 작성

<div align="center"><img src="https://github.com/9oorp/9oorp/assets/83001865/cb9e2d82-5bd8-4bc3-930c-65f5f6a3561c"></div>

### 포스트 수정

<div align="center"><img src="https://github.com/9oorp/9oorp/assets/83001865/92fc0531-9d20-4548-8984-68759a0066b1"></div>



## 팀 소개

<table width="500" align="center">
<tbody>
<tr>
<th>Pictures</th>
<td width="100" align="center">
<a href="https://github.com/choiminwoo98">
<img src="https://avatars.githubusercontent.com/u/61531483?v=4" width="60" height="60">
</a>
</td>
<td width="100" align="center">
<a href="https://github.com/wlstnam">
<img src="https://avatars.githubusercontent.com/u/127458907?v=4" width="60" height="60">
</a>
</td>
<td width="100" align="center">
<a href="https://github.com/hstla">
<img src="https://user-images.githubusercontent.com/97827316/215991535-aa0d5aeb-363c-41a7-a114-c1448d58d9f1.png"" width="60" height="60">
</a>
</td>
</tr>
<tr>
<th>Name</th>
<td width="100" align="center">최민우</td>
<td width="100" align="center">남진수</td>
<td width="100" align="center">황현성</td>
</tr>
<tr>
<th>Position</th>
<td width="150" align="center">
Frontend<br>
</td>
<td width="150" align="center">
Backend<br>
</td>
<td width="150" align="center">
Backend<br>
</td>
</tr>
<tr>
<th>GitHub</th>
<td width="100" align="center">
<a href="https://github.com/choiminwoo98">
<img src="http://img.shields.io/badge/choiminwoo98-green?style=social&logo=github"/>
</a>
</td>
<td width="100" align="center">
<a href="https://github.com/wlstnam">
<img src="http://img.shields.io/badge/wlstnam-green?style=social&logo=github"/>
</a>
</td>
<td width="100" align="center">
<a href="https://github.com/hstla">
<img src="http://img.shields.io/badge/hstla-green?style=social&logo=github"/>
</a>
</td>
</tr>
</tbody>
</table>
