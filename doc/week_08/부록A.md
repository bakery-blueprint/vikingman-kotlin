# 부록 A 코틀린 프로젝트 빌드

 ## A.1 그레이들로 코틀린 코드 빌드

코틀린 프로젝트를 빌드할 때 그레이들 사용을 권장

```groovy
apply plugin: 'kotlin'
```



### A.1.1 그레이들로 안드로이드 애플리케이션 빌드하기

```groovy
apply plugin: 'kotlin-android'
```





## A.2 메이븐으로 크틸린 프로젝트 빌드

https://kotlinlang.org/docs/reference/using-maven.html (책 url 오타)



## A.3 앤트로 코틀린 코드 빌드

<kotlinc> : 순수 코틀린 모듈 컴파일

<withKotlin> : 자바와 코틀린을 혼합한 모듈을 빌드