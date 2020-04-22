# 부록E 코루틴과 Async/Await

코틀린 1.3부터 코루틴이 표준 라이브러리에 정식 포함

책 원서에는 해당내용 없지만, 중요하기때문에 옮긴이가 추가함 (그래서 그런지 오타가 많음;;)

* 코루틴 문서 https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html

* 초심 사용자를 위한 한국인 개발자의  발표자료 https://speakerdeck.com/taehwandev/kotlin-coroutines



## E.1 코루틴이란?

서브루틴 : 여러 명령어를 모아 이름을 부여해서 반복 호출할 수 있게 정의한 프로그램 구성요소 (함수)

메소드 -> 서브루틴 in OOP

함수를 호출하면 서브루틴에 진입하게됨. 그때마다 활성레코드가 스택에 할당되면서 로컬 변수 등을 초기화

멀티태스킹 : 여러 작업을 동시에 수행하는 것처럼 보이거나 실제로 동시에 수행하는 것

비선점형 : 멀티태스킹의 각 작업을 수행하는 참여자들의 실행을 운영체제가 강제로 일시중단시키고 다른 참여자를 실행하게 만들 수 없음 (각 참여자들이 서로 자발적으로 협력)



## E.2 코틀린의 코루틴 지원: 일반적인 코루틴

* kotlin.coroutine

* kotlinx.coroutines (https://github.com/Kotlin/kotlinx.coroutines)



### E.2.1 여러 가지 코루틴

#### Kotlinx.coroutines.CoroutineScope.launch

launch는 코루틴을 Job으로 반환, 만들어진 코루틴은 기본적으로 즉시 실행

582p 예제 참고.



runBlocking() : 코루틴의 실행이 끝날 때까지 현재 스레드를 블록시키는 함수

LaunchExample 확인!

#### kotlinx.coroutines.CoroutineScope.async

|                     | Deferred (async)                                  | Job (launch) |
| :------------------ | ------------------------------------------------- | ------------ |
| 타입 파라미터       | O (Deferred 코루틴이 계산하고 돌려주는 값의 타입) | X            |
| await() 함수의 정의 | O                                                 | X            |
| return type         | Deferred<Unit>                                    | Unit         |

async는 사실상 launch와 같은 일을 함

코드 블록을 비동기로 실행할 수 있고, await을 사용해서 코루틴이 결과 값을 내놓을 때까지 기다렸다가 결과값을 얻어낼 수 있음



### E.2.2 코루틴 컨텍스트와 디스패처

```kotlin
package kotlinx.coroutines

public interface CoroutineScope {
    public abstract val coroutineContext: kotlin.coroutines.CoroutineContext
}
```

CoroutineContext 타입의 필드 하나만 들어있음. CoroutineScope는 매개체 역할만을 담당

```CoroutineContext``` 가 코루틴 실행에 더 중요한 의미!

#### CoroutineContext

* CoroutineContext는 코루틴이 실행 중인 여러 작업(Job)과 디스패처를 저장하는 일종의 맵
* 다음에 실행할 작업을 선정하고, 어떻게 스레드에 배정할지에 대한 방법을 결정하는 것에 사용됨



### E.2.3 코루틴 빌더와 일시 중단 함수

launch, async, runBlocking -> 코루틴 빌더. 코루틴을 만들어주는 함수!

* produce : https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.channels/produce.html
* actor : https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.channels/actor.html



delay, yield -> 일시중단 함수

* withContext 
* withTimeout
* withTimeoutOrNull
* awaitAll
* joinAll



## E.3 suspend 키워드와 코틀린의 일시 중단 함수 컴파일 방법

일시중단 함수(delay, yield)를 코루틴이나 일시중단 함수가 아닌 함수에서 호출하는 것은 🚫

일시중단 함수를 만들기 위해서는 fun 앞에 `suspend` 키워드를 넣어주면 됨

```kotlin
package kotlinx.coroutines

internal val kotlin.coroutines.CoroutineContext.delay: kotlinx.coroutines.Delay /* compiled code */

public suspend fun delay(timeMillis: kotlin.Long): kotlin.Unit { /* compiled code */ }
```



* 코루틴에 진입할 때와 나갈 때 실행 중이던 상태를 저장하고 복구
* 현재 실행 중이던 위치를 저장하고 재개될 때 해당 위치부터 실행 재개
* 다음에 어떤 코루틴을 실행할지 결정 (코루틴 컨텍스트에 있는 디스패처에 의해 수행)



#### CPS(Continuation Passing Style) 변환

프로그램의 실행 중 특정 시점 이후에 진행해야 하는 내용을 별도의 함수로 뽑고, 그 함수에게 현재 시점까지 실행한 결과를 넘겨서 처리하게 만드는 변환 기술



```kotlin
suspend fun example(v: Int): Int {
  return v*2;
}
```

코틀린 컴파일러는 위의 함수를 컴파일하면 아래

```java
public static final Object example(int v, @NotNull Continuation var1)
```

함수 호출이 끝난 후 수행해야할 작업을 var1에 전달!!

http://matt.might.net/articles/by-example-continuation-passing-style/


## E.4 코루틴 빌더 만들기

만들 필요는 없음. async, launch 등으로 충분

https://github.com/Kotlin/coroutines-examples






