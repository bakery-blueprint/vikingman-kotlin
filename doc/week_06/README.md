# 11. DSL 만들기

## DSL이란 무엇인가?

- 영역 특화 언어 (vs. 범용 프로그래밍 언어)
- 일반적인 API와 달리 **구조 또는 문법**이 존재한다.
- 특정 영역에 대한 연산을 더 간결하게 기술할 수 있다.
  - 제공하는 기능을 제한함으로써 오히려 더 효율적으로 자신의 목표를 달성!
- 선언적
- 범용 언어와 조합하기가 어렵다는 단점 → internal DSL 등장
- internal DSL : 범용 언어를 특별한 방법으로 사용하는 것

## 코틀린의 internal DSL

- 장점? 타입 안전성을 보장한다. (HTML에 비해서)
  - 특정 클래스에 접근할 수 있는 영역을 제한할 수 있다.

### 구조화된 API 구축: 수신 객체 지정 DSL

- 수신 객체 지정 람다

  - 확장 함수 타입으로 파라미터를 받는다.
  - 수신 객체가 지정되면 파라미터의 멤버를 바로 사용할 수 있다.
  - 확장 함수 타입의 변수도 정의할 수 있다.
```kotlin
  public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
```   
```kotlin
  public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
```   

- 타입 안전한 빌더

  - 수신 객체 지정 람다를 인자로 받는 고차 함수
  - 수신 객체에 의해 사용할 수 있는 함수가 제한된다. → 타입 안전성!
  - 사용자 코드에 나타나면 안되는 유틸리티 클래스는 이름을 모두 대문자로 만들어서 일반 클래스와 구분
  - 내부 람다에서 외부 람다에 정의된 수신 객체를 사용할 수 있다.
    - @DslMarker 를 사용해 중첩된 람다에서 외부 람다의 수신 객체 접근을 제한할 수 있다.
```kotlin
  class TABLE : Tag("table") {
      fun tr(init: TR.() -> Unit) = doInit(TR(), init)
  }
  class TR : Tag("tr") {
      fun td(init: TD.() -> Unit) = doInit(TD(), init)
  }
  class TD : Tag("td")
```    
- 코틀린 빌더

  - 추상화와 재사용을 가능하게 하는 도구
  - 반복되는 내부 DSL 코드 조각을 새 함수로 묶어서 재사용할 수 있다.

### invoke 관례

- 함수처럼 호출할 수 있는 객체

- 괄호 () 가 연산자 역할을 하는 것

- operator 변경자가 붙은 invoke 메소드를 그 객체에 ()를 붙여 함수처럼 호출할 수 있다.

- invoke 메소드의 시그니처 요구 사항은 따로 없다.

  - 원하는 대로 파라미터 개수나 타입을 지정할 수 있다.

- 람다 호출 방식은 사실 invoke 관례를 적용한 것이다.

  - 복잡한 람다를 클래스 내부에서 여러 메소드로 분리할 수 있다.

  ```kotlin
  interface FunctionN<in P1, in P2, ..., in PN, out R> {
  	operator fun invoke(p1: P1, p2: P2, ..., pN: PN): R
  }
  ```

### + 복습

- 중위 호출
  - 인자 1개 짜리 함수에 infix를 붙여 괄호 없이 호출할 수 있다.
