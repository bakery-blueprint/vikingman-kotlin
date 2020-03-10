# 6장 코틀린 타입 시스템

> 학습목표 (다같이 따라읽어 보아요~)
> * 널이 될 수 있는 타입과 널을 처리하는 구문을 사용할 수 있다.
> * 코틀린 원시 타입, 그리고 자바 타입과 코틀린 원시 타입의 관계를 알 수 있다.
> * 코틀린 컬렉션, 그리고 자바 컬렉션과 코틀린 컬렉션 관계를 알 수 있다.
---
## 6.1 널 가능성
* 코틀린은 널이 될 수 있는 타입이 따로 있음
* 그런 타입들을 처리하는 방법들이 있음
--- 
### 6.1.1 널이 될 수 있는 타입
* "널이 될 수 있는 인자인가?"
* 널을 받을 수 있게 하려면 타입 이름 뒤에 '?' 를 붙여야 한다.
```kotlin
// * ex) 
val s: String?
fun strLen(s: String?) {...}
```
* 널이 될 수 있는 타입으로는 null 과의 비교를 통해 널이 될 수 없는 값처럼 사용할 수 있다.  
---
### 6.1.2 타입의 의미 (코틀린이 널을 바라보는 시각)
* 타입이란 값의 Identity 와 behavior를 정의함
* 자바에서는 String이란 타입에 String과 null이 둘다 가능 -> 자바의 타입 시스템이 널을 제대로 다루지 못한다는 뜻!
* 코틀린은 널이 될 수 있는 타입과 널이 될 수 없는 타입을 구분한다!!!
---
### 6.1.3 안전한 호출 연산자 '?.'
* 널 검사와 메소드 호출을 한 번의 연산으로 수행!
* 호출하려는 값이 null이면 호출을 무시하고 그대로 null
* 안전한 호출의 결과 타입도 null을 허용하는 타입
---
### 6.1.4 엘비스 연산자 ':?'
* null 대신 default 값을 지정할 때 편리하게 사용 가능
* 엘비스 연산자는 이항 연산자 -> 좌항을 계산하고 null이 아니면 좌항, 맞으면 우항 (이항 연산자기 때문에 식 사용가능)
* return 이나 throw 도 식이기때문에 사용가능
---
### 6.1.5 안전한 캐스트 'as?'
* 타입캐스트가 가능하면 좌항 타입을, 불가능하면 다른 식을 반환
---
### 6.1.6 널 아님!! 암튼 아님!! 'as!!'
* 널이 될 수 있는 타입을 널이 될 수 없는 타입으로 변경 가능 (NPE 발생 가능)
* 사용자가 null 이 아닌값이 전달 되는것을 보장할때 사용함
* !! 단언문을 한줄에 써버리면 NPE 정확히 어디서 발생하는지 모름
```kotlin
person.company!!.address!!.country
```
---
### 6.1.7 let 함수
* 안전한 호출 연산자(.?)사용해 null이 아닌값을 넘기기 쉬움
* 자신의 수신 객체를 인자로 전달받은 람다에게 넘김
* 명시적인 if 검사를 제거 가능
---
### 6.1.8 나중에 초기화할 프로퍼티
* 코틀린에서는 null이 될 수 없는 프로퍼티라면 반드시 생성자에서 초기화가 필요함
* lateinit 라는 변경자를 붙이면 이후에 초기화 가능 (var 이어야 함)
---
### 6.1.9 널이 될 수 있는 타입 확장
* 널이 될 수 있는 타입에 확장함수를 정의!
* 널이 될 수 있는 문자열 타입에 isBlankOrNul 과 같은 확장함수 가능
---
### 6.1.10 타입 파리미터의 널 가능성
* 타입 파라미터는 물음표가 없더라도 기본적으로 널이 될 수 있는 타입
* <T:Any> 와 같은 형식으로 명시 필요
---
### 6.1.11 자바의 null 을 코틀린에서는 어떻게 받아들이까?
* null 관련 어노테이션이 있다면 땡큐!
* 플랫폼 타입
    * 자바는 타입에 null이 들어갈 수 있음
    * 널이 될 수 업는 타입 OR 널이 될 수있는 타입 -> 사용자가 책임
* 상속
    * 자바 메소드를 오버라이드할 때 파라미터와 반환 타입은?
    * 사용자가 결정해야함
---
## 6.2 코틀린의 원시 타입

---
### 6.2.1 원시 타입
* 코틀린 에서는 원시 타입과 래퍼 타입을 구분하지 않음 -> 원시타입에도 다양한 메소드 호출을 지원함
* 실행 시점에 가장 효율적인 방식으로 컴파일됨
* 타입 파라미터일 경우 자바 랩퍼타입으로 사용 -> 널이 될 수 업는 타입이기 때문에 안전성 보장 가능
---
### 6.2.2 널이 될 수 있는 원시 타입
* 널은 자바 원시타입에 들어갈 수 없음 -> 바 래퍼 타입으로 컴파일됨
---
### 6.2.3 숫자 변환
* 코틀린은 자동 형변환 하지 않는다.
* 변환 메소드 호출 가능
* 숫자 리터럴은 타입이 알려진 변수에 대입할때는 자동 형변환
---
### 6.2.4 Any? Any
* Any는 '널이 될 수 없는' 타입의 조상 타입 java Object와 비슷 
* 널이 포함하는 모든 값을 대입할 변수는 Any?
---
### 6.2.5 Unit 타입 , 코틀린의 void
* 내용을 전혀 반환하지 않는 함수의 바환 타입으로 Unit 사용 가능
* 제네릭 파라미터를 반환하는 함수를 오버라이드 할때, Unit을 반환 타입으로 정의 한다면 return 을 명시하지 않아도 사용 가능
---
### 6.2.6 Nothing 타입 - 이 함수는 결고 정상적으로 끝나지 않는다.
* 특정 함수가 '반환 값'이라는 의미도 필요없고 정상적으로 끝나지 않는 함수라는 걸 명시하고 싶은 경우
* Nothing을 반환하는 함수를 엘비스 연산자 옆에 사용한다면 컴파일러는 이를 추론하여 널이 아님을 추론할 수 있다.
---
## 6.3 컬렉션

---
### 6.3.1 널 가능성과 컬렉션
* List<Int?> -> 컬렉션 원소가 널이 될 수 있다
* List<Int\> -> 컬렉션이 널이 될 수 있다.
---
### 6.3.2 읽기 전용과 변경 가능한 컬렉션
* 추가하거나 제거하는 인터페이스는 MutableCollection(Collection 을 확장) 인터페이스에 정의
* 읽기 전용 인터페이스 타입 변수라도 변경 가능한 인터페이스 참조를 가르키고 있을 수 있음
* 꼭 스레드 안전한건 아님 -> 주의 필요!
---
### 6.3.3 코틀린 컬렉션과 자바
* 자바 컬렉션 인터페이스를 그대로 사용
* 변경 가능한 인터페이스는 대응되는 읽기 전용 인터페이스를 확장한것
* 자바로 넘길때는 읽기전용과 변경 가능 컬렉션을 구분하지 않는다 -> 개발자 책임
---
### 6.3.4 자바의 컬렉션과 코틀린
* 컬렉션도 플랫폼 타입! -> 읽기 전용 OR 변경 가능 컬렉션 둘다 가능
* 컬렉션 타입이 함수 시그니처에 들어간다면? (풀이 시간 294~296 페이지)
---
### 6.3.5 객체의 배열과 원시 타입의 배열
* 코틀린 배열은 타입 파라미터를 받음 -> 배열의 원소 타입은 타입 파라미터에 의해 결정
* 원시 타입을 표현하는 별로 클래스를 제공함 (IntArray, ByteArray 등)
* 컬렉션에 사용할 수 있는 모든 확장 함수를 배열에도 제공
<br>
<br>
<br>
<br>
---

# 7 연산자 오버로딩과 기타 관례 
> 학습목표 (다같이 따라읽어 보아요~)
> * 연산자 오버로딩을 이해하고 사용할 수 있다.
> * 여러 연산을 지원하기 위해 특별이 이름 붙은 관례들을 사용하고 이해할 수 있다.
> * 위임 프로퍼티를 이해할 수 있을까?
* 코틀린에서는 어떤 언어 기능과 미리 정해진 이름의 함수를 결해 주는 기법을 관례 라고 부른다.
---
## 7.1 산술 연산자 오버로딩

---
### 7.1.1 이항 산술 연산 오버로딩
* 기본 구현
```kotlin
data class Point(val x: Int, val y: Int){
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}
```
* times(*), div(/), mod(%), plus(+), minux(-)
* 교환 법칙 지원하지 않음
* 피연산자 타입이 같을 필요 없음
* 반환 타입이 꼭 두 피연산자 중 하나와 동일하지 않아도 가능함
---
### 7.1.2 복합 대입 연산자 오버로딩 (like. += 등등)
* plusAssign(+=), minusAssign(-=) 등등
* 일관성을 유지하기 위해 복합 대입 연산자와 이상 산술 연산자는 동시에 정의하지 말라.
* 복합 대입 연산자는 새로운 컬렉션을 반환하지 않고 메모리에 있는 객체 상태를 변화시킨다.
* 읽기 전용 컬렉션에서는 복사본을 전달함
---
### 7.1.3 단한 연산자
* 기본 구현
```kotlin
data class Point(val x: Int, val y: Int){
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
}
```
* 단항 연산자 함수는 파라미터가 없음
* unaryPlus(+), unaryMinus(-), not(!), inc(++a, a++), dec(--a, a--)
* 전위 후위 상관없이 잘 작동함
---
## 7.2 비교 연산자 오버로딩  

---
### 7.2.1 동등성 연산자 equals
* == 연산자 호출은 equals로 컴파일됨
* 식별자 비교는 오버로딩 할 수 없음 -> equals를 오버로딩할때 === 를 사용해 구현
* != 는 == 값을 반전시켜 돌려줌
---
### 7.2.2 순서 연산자
* comparetTo 관례를 제공함 : (<, >, <=, >=)
* 기본 구현
```kotlin
class Person (
    val firstName: String, val lastName: String
): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other,
                                Person::lastName,
                                Person::firstName)
    }
}
```
## 7.3 컬렉션과 범위에 대해 쓸 수 있는 관례

---
### 7.3.1 인덱스로 원소에 접근: get 과 set
* 인덱스 연산자([index]) 도 관례를 따르고, get과 set 연산자 메소드로 변환된다.
* 기본 구현
```kotlin
data class Point(val x: Int, val y: Int){
    operator fun get(index: Int): Int {
        return when(index){
            0 -> x
            1 -> y
            else ->
                throw IndexOutOfBoundsException("라라라라")
        }
    }
}

>>> val p = Poing(10, 20)
>>> println(p[1])
20

```
* get 연산자 파라미터로 Int가 아니어도 된다(Map)
* set 메소드를 통해 해당 인덱스에 원소를 쓸 수 있다.
* 기본 구현
```kotlin
data class MutablePoint(var x: Int, var y: Int){
    operator fun set(index: Int, value: Int) {
        when(index){
            0 -> x = value
            1 -> y = value
            else ->
                throw IndexOutOfBoundsException("라라라라")
        }
    }
}

>>> val p = MutablePoint(10, 20)
>>> p[1] = 42
>>> println(p)

MutablePoint(x=10, y=42)
```
### 7.3.2 in 관례
* in 관례와 대응하는 함수는 contains
* 기본구현
```kotlin
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    retrun p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

>>> val rect = Rectangle(Point(10, 20), Point(50, 50))
>>> println(Point(20, 20) in rect)
true
>>> println(Point(5, 5) in rect)
false
```
* until 은 열린 범위를 만드는 함수
---
### 7.3.3 rangeTo 관례
* .. 연산자는 rangeTo 함수를 간략하게 표현한 관례
* 어떤 클래스가 Comparable 인터페이스를 구현한다면 rangeTo를 정의할 필요가 없다.
* 코틀린 표준 라이브러리에 Comparable 객체에 대한 적용 가능한 rangeTo 함수가 들어있다.
* .. 연산자는 다른 산술 연산자보다 우선순위가 낮다 -> 적절한 괄호 표기 필요
---
### 7.3.4 for 루프를 위한 iterator 관례
* 기본구현
```kotlin
operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean =
            current <= endInclusive

        override fun next(): LocalDate = current.apply {
            current = plusDays(1)
        }
    }
// rangeTo 가 반환하는 ClosedRange 인스턴스를 반환 (범위를 나타냄)
// 해당 범위에 확장함수 iterator을 정의

```
---
## 7.4 구조 분해 선언과 component 함수
* 복합적인 값을 분해해서 다른 변수를 한꺼번에 초기화 할 수 있음
```kotlin
val p = Point(10, 20)
val (x, y) = p
println(x)
// 10
println(y)
// 20
```
* 내부에서 구조 분해 선언은 componentN 이라는 함수를 사용해 관례를 표현한다.
* data 클래스에서는 주 생성자 안에 있는 프로퍼티에 대해서 자동으로 만들어줌
* 반환해야하는 값을 담고있는 data 클래스를 생성해 사용하면 여러 값을 한번에 반환할 수 있음
* 맨 앞 다섯 우너소에 대한 componentN을 제공함
---
###  7.4.1 구조 분해 선언과 루프
* 루프 안에사더 구조 분해 선언 사용 가능
```kotlin
for ((key, value) in map){...}
```
* 코틀린 에서는 Mpa.Entry에 대한 확장 함수로 componentN을 제공함
---
## 7.5 프로퍼티 접근자 로직 재활용: 위임 프로퍼티
* 위임은 객체가 직접 작업을 수행하지 않고 다른 도우미 객체가 그 작업을 처리하게 맡기는 디자인 패턴을 말한다.
---
### 7.5.1 위임 프로퍼티 소개
* 위임 프로퍼티의 일반적인 문법
```kotlin
class Foo {
    var p: Type by Delegate()
}
```
* 프로퍼티 위임 객체가 따라야 하는 관례를 따르는 모든 객체를 위임에 사용할 수 있다.(getValue, setValue를 제공)
---
### 7.5.2 위임 프로퍼티 사용: by lazy()를 사용한 프로퍼티 초기화 지연
* 지연 초기화가 필요한 시점이 있음(무거운 연산을 해야할때 등등)
* 뒷받침 프로퍼티를 통해 구현하는 방법이 있음 -> 코드가 더러워짐, 방식에 따라 스레드 세이프 하지 않음
* lazy 함수를 사용해 제공
* lazy 는 코틀린 관례에 맞는 getValue 메소드가 들어있는 객체를 반환 -> 따라서 위임 프로퍼티를 만들 수 있음
```kotlin

package kotlin
public actual fun <T> lazy(initializer: () -> T): Lazy<T> = SynchronizedLazyImpl(initializer)

...
public interface Lazy<out T> {
    ...
    @kotlin.internal.InlineOnly
    public inline operator fun <T> Lazy<T>.getValue(thisRef: Any?, property: KProperty<*>): T = value
    ...
}
```
* 스레드 세이프함
---
### 위임 프로퍼티 구현
* 코틀린 표준 라이브러리 를 사용해서 구현 가능
* 위임 프로퍼티 컴파일은 delegate에서 getValue와 setValue를 호출한다.
* 해당 관례에 맞는 델리게이트를 직접 구현하여 다양한 방법으로 불러오고 저장할 수 있음
* map을 통해서도 구현가능(map 인터페이스에 대해 getValue, setValue 를 제공)
