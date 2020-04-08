# 1.코틀린 코드 문서화
## 1. 케이독 주석 스타일
```kotlin
/**
* 두 수 [a] 와 [b] 의 합계를 계산한다
*/
fun sum(a: Int, b: Int) = a + b
```
* 각 괄호 '[]' 안에 참조대상을 넣을 수 있다.
```kotlin
/**
* [com.sun.java.*] 등등...
*/
```

## 2. 문서화 주석
```kotlin
/**
* @param true 이면 원격에서 실행한다.
* @return 연산을 수행한 결과
* @throws IndexOutOfBoundsException 
* @sample com.github.bakery.vikingmankotlin.week_01.HelloWorld.hello
* @author jaehyun 3학년 2반
* 등등
*/
fun something(remote: Boolean):String {/*...*/}
```
* @deprecated -> @Deprecated 로 변경
* 케이독 스타일을 사용하자~

## 3. API 문서 생성 도구 dokka
![도카 생성 사진](https://github.com/bakery-blueprint/vikingman-kotlin/blob/feature/week_07/src/main/resources/dokka_pic.png)
* javadoc, dokka, javadocJar 옵션을 줘서 문서 형식을 변경할 수 있음 있음
* [도카 문서](https://github.com/Kotlin/dokka)


# 2. 코틀린 에코시스템
## 1. 테스팅
* 코틀린 시스템 : 스칼라테스트에서 영향을 받음
* 스펙 : BDD 스타일의 코틀린 테스트 프레임워크
* 단언문 작성에 좀 더 표현력이 좋은 DSL -> 햄크레스 사용
* 모킹 -> 모키토-코틀린

## 2. 의존관계 주입
* 코데인DI

## 3.JSON 직렬화
* 잭슨 -> 잭슨-모듈-코틀린
* 지슨(GSON) -> 콧슨(Kotson)
* 클락슨

## 4. HTTP 클라이언트
* 레트로핏
```java
// 자바 형태
public interface GitHubService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}

Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build();

GitHubService service = retrofit.create(GitHubService.class);

Call<List<Repo>> repos = service.listRepos("octocat");

```

## 5. 웹 어플리케이션
* 케이토 : 젯브레인스에서 만듬!
* 카라
* 와사비 : 네티 위에 만들어진 프레임워크
* 코버트

## 6. 데이터베이스 접근
* [익스포즈드](https://github.com/JetBrains/Exposed) : sql 생성 프레임워크

## 7.유틸리티와 데이터 구조
* [RxJava 표준에 대한 코틀린 바인딩](https://github.com/ReactiveX/RxKotlin)
* funKTionale 함수형 프로그래밍 기본 구조 제공
* 커버넌트 

## 8.데스크탑 프로그래밍
* 토네이도FX


# 3. 코틀린 1.1 / 1.2 / 1.3
## 3.1. 1.1 
### 3.1.1. 자바스크립트 공식 지원
### 3.1.2. 타입 별명 : 기존 타입을 다른 이름으로 부를 수 있음
```kotlin
typealias MyHandler = (Int, String, Any) -> Unit
fun addHandler(h:MyHandler)
```
### 3.1.3. 봉인 클래스와 데이터 클래스
* 봉인 클래스 하위 클래스를 같은 소스 파일 안에만 정의하면 된다.
* 데이터 클레스로 봉인 클래스 확장 가능
* data 클래스 덕분에 toString() 을 쉽게 얻을 수 있음

### 3.1.4. 바운드 멤버 참조
```kotlin
val p = Person("lim", 30)
val ageFunction = p::age
println(ageFunction())
>> 30
```

### 3.1.5 람다 파라미터에서 구조 분해 사용
* 람다의 파라미터 목록에도 사용 가능
```kotlin
val nums = listOf(1, 2, 3)
val names = listOf("1", "2", "3")

(nums zip names).forEach{ (num, name) -> println("${num} = ${name}")}
/*
zip 함수 : 두 컬렉션 조합(갯수가 다르면 적은 컬렉션을 따라감)
 */
```

### 3.1.6 밑줄(_)로 파라미터 무시
* 람다 정의 후 사용하지 않는 파라미터가 있다면 _을 위치에 넣을 수 있음
```kotlin
data class Name(val lastName: String, val firstName: String)
typealias NAMEFUN = (Name) -> Unit

fun applyNAME(v: Name, f:NAMEFUN) = f(v)

val me = Name("임", "재현")
applyNAME(now) {(lastName, _) -> println("${lastName}")}
``` 

### 3.1.7. 프로퍼티 접근자 인라이닝
* 접근자를 inline로 선언가능
* 프로퍼티에 뒷받침 필드가 있다면 인라이닝할 수 없음

### 3.1.8. 제네릭 타입으로 enum 값 접근
```kotlin
// 이넘 값을 가지고 오는 방법
public inline fun<reified T : Enum<T>> enumValues(): Array<T>

// 이름에서 값을 가지고 오는 방법
public inline fun<reified T : Enum<T>> enumValueOf(name: String): T
```

### 3.1.9. DSL 수신객체 제한
* @DslMarker 어노테이션 사용 -> DSL 과제에 적용해보자~

### 3.1.10. 로컬 변수 등을 위임
```kotlin
class BarDelegate {
    operator fun getValue(/*...*/) {/* 델리게이트 필수 연산! 기억안난다면 다시 돌아가서 확인해보자*/}
}

val y:Int by BarDelegate()

```

### 3.1.11. 위임 객체 프로바이더
* provideDelegate() 연산자를 제공하는 객체를 프로퍼티 위임에 사용한다면 
* 처 객체와 연결될 때마다 이름과 객체에 따라 적절한 위임 객체를 음전달하여 사용할 수 있게 한다.

### 3.1.12. mod 와 rem
* mod 대신에 rem이 % 연산자로 해석
```kotlin
>>> rintln(11.rem(4))
3
```

### 3.1.13 표준 라이브러리
* onEach : forEach 와 비슷하지만 컬렉션이나 시퀀스를 반환

* also : apply 안에서 this는 수신객체지만 also 안에서는 this는 그대로이기 때문에 수신객체 호출시 특정 변수(ex 'it')을 활용해야함

* takeIf : 수신객체가 지정한 술어를 만족하는지 검사

* groupingBy : 컬렉션을 키에 따라 분류, 이때 [Grouping](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-grouping/#grouping) 이라는 타이으로 반환

* Map.toMap : 맵 복사시에 사용

* minOf / maxOf : 2,3 개 값중 최소or 최대 값 반환, 마지막 파라미터 뒤에 Comparator를 지정가능


## 3.2. 1.2
### 3.2.1. 애노테이션 배열 리터럴
* 애노테이션 값에 배열을 넘길때 [element] 형식으로 표시 가능 

### 3.2.2. 지연 초기화 개선
* 지연 초기화를 최상위 프로퍼티와 지역 변수에도 사용 가능

### 3.2.3. 인라인 함수의 디폴트 함수 타입 파라미터 지원
* 인라인 함수가 람다를 인자로 받을 경우 디폴트 파라미터 사용가능

### 3.2.4. 이넘 원소안의 클래스는 inner 클래스로!

### 3.2.5. (기존 코드를 깨는 변경)  try 블록의 스마트 캐스트 안전성 향상
* 예제를 찾아오겠습니다...ㅠㅠ

### 3.2.6. 표준 라이브러리

* 컬렉션 원소 처리를 n개씩 할 수 있는 슬라이딩 윈도우 메소드 추가 
    * chunked / chunkedSequence : 컬렉션을 정해진 크기로 나눔
    * windowed/ windowedSequence 정해진 크기의 슬라이딩 윈도우를 만들어 컬렉션 처리
    * ZipWithNext 컬렉션에서 연속한 두원소에 대해 람다를 적용한 결과를 얻는다.
* 리스트 원소를 처리하는 메소드 추가
    * fill : 원소 채우기
    * shuffle/ shuffled 리스트 임의로 뒤섞음
* kotlin.math : 여러 상수 추가
* Regex 클래스 직렬화 제공

### 3.2.7 JVM 관련 변경
* 생성자 호출 정규화 : 생성자 컴파일 바이트 코드 생성 옵션
    * disable(기본) / enable / preserve-class-initialization
* 자바 디폴트 메소드 호출
* x.equals(null) 일관성 보장 : 자바 원시타입을 다룰때 이슈 발생 -> 일관성 보장

## 3.3. 1.3
### 3.3.1. 네이티브 개선 
* 네이티브 컴파일 기능 개선 : exe 파일 생성, c++ 동적라이브러리 생성 등 

### 3.3.2. 다중 플랫폼 프로젝트

### 3.3.3. 컨트랙트
* 스마트캐스트 기능을 위해 타입검사하는 부분을 함수로 분리한다면 정상적으로 스마트캐스트 지원이 불가느 
* 조건을 명시한 컨트랙트들이 있음
````kotlin
@kotlin.internal.InlineOnly
public inline fun CharSequence?.isNullOrEmpty(): Boolean {
    // false 를 리턴할 경우 해당 수신 객체는 null이 아니라 라는 컨트랙트
    contract {
        returns(false) implies (this@isNullOrEmpty != null)
    }

    return this == null || this.length == 0
}
```` 
* 사용자 컨트랙트를 만들 수 있지만 아직 실험적 기능임

### 3.3.4. When 의 대상을 번수에 포획
```kotlin
when (val result = excute()){
    is Success -> result.value
    is Fail -> result.message
}
```
* when 절 앞에서 변수에 값을대입하고 해당 변수를 통해 when 절을 실행할 수도 있지만. when 문 안에서만 사용할 수 있는 변수가 생기므로 깨끗한 코드 작성 가능

### 3.3.5. 인터페이스 동반 객체에 있는 멤버를 자바 코드로
* @JvmStatic / @JvmField 를 붙이면 자바 인터페이스의 static 필드나 함수가 된다.

### 3.3.6. 애노테이션 클래스 안에 선언을 중첩시킬 수 있음

### 3.3.7. 파라미터 없는 메인

### 3.3.8. 함수 파라미터 수 22개 -> 255개

### 3.3.9 인라인 클래스(실험적 기능)

### 3.3.10. 부호 없는 정수(실험적 기능)

### 3.3.11. @JvmDefault 자바 인터페이스 디폴트 메소드를 코틀린에서 선언할 수 있게(실험적 기능)

### 3.3.12. 표준 라이브러리

* Kotlin.random.Random 다중 플랫폼 지원

* isNullOrEmpty와 orEmpty 확장을 여러 클래스에 추가(컬랙션, 맵, 배열 등)

* 배열 원소 복사 확장 함수 copyInto 추가

* 맵 연관 쌍 추가 함수 associateWith()

* ifEmpty 와 ifBlank 함수 : 컬랙션이 비어있다면 대안 제시

* 시간 측정과 기간 api (duration)

* 비트를 다루는 api 추가



