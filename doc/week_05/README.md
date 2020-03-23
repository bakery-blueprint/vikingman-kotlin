# 5주차 Annotation / Reflection


## Annotation

사실 자바와 다를게 거의 없다. 

자바의 Deprecated 아쉬운거지 코틀린으로만 가능한 것이 아니다. 

~~~java
    @MyDeprecated(message = "Use remove At(index)", replaceWith = @ReplaceWith(expression = "removeAt(index)"))
    public void main() {

    }
~~~

- 차이점이 있다면 자바는 value 이름만 생략할 수 있지만 코틀린은 다 가능하다. 

- 가장 중요한 사실은 Annotation 을 생성할 수 있다. (자바에서 생성하려면 똥꼬쇼를 해야함)

- 사용 지점이 더 넓긴하지만 모두다 호환되지는 않는다. module


## Reflection

1.7 이전 자바 정점 그들만의 리그

요즘 많이 사용하긴 한다. 하지만 전부 자바 8으로 바꿀수 있다. 


핵심 클래스는 
~~~kotlin
KClass<T: Any> {

}
~~~


### KCallable
- KCallable는 함수와 프로퍼티의 공통 상위 인터페이스이다. 한마디로 자바 (method / getter, setter) 

이 부분도 자바 리플렉션 매니아들이 많이 사용하고 스프링 beanMapping 이 전부 리플렉션 getter / setter 로 동작한다.

~~~java
class Method {
  public Object invoke(Object obj, Object... args) {    
  }
}
~~~

~~~kotlin
public actual interface KCallable<out R> : KAnnotatedElement {
 public fun call(vararg args: Any?): R
}
~~~


: 둘다 가변인자 ~~ 


- 가변 인자를 사용하면 예외가 발생하기 떄문에, KFunctionN 시리즈로 명시적으로 호출이 가능하다. 하지만 자바도 safe하게 호출 가능하다. 

KFunctionN을 사용하는 건 아니지만 리플렉션으로 파라미터 정보를 얻어오면 된다. 


- 아무튼 KAnnotatedElement가 최상위이다. 

- callby를 사용하면 디폴트 파라미터를 사용할 수 있다. 



### 자바와 차이점 

리플렉션에서 가장 큰 차이점은 바로바로 이전 장에서 배운 제네릭 reified 이다. 

자바는 제네릭 정보가 날라가서 정말 거지같다. Annotation 정보를 얻어오기 위해서 똥꼬쇼를 해야한다. 

isAnnotationPresent / getAnnotation 대표적이다. 

~~~java
class Method {
   private Map<Class<? extends Annotation>, Annotation> declaredAnnotations() {
        Map<Class<? extends Annotation>, Annotation> declAnnos;
        if ((declAnnos = declaredAnnotations) == null) {
            synchronized (this) {
                if ((declAnnos = declaredAnnotations) == null) {
                    Executable root = (Executable)getRoot();
                    if (root != null) {
                        declAnnos = root.declaredAnnotations();
                    } else {
                        declAnnos = AnnotationParser.parseAnnotations(
                                getAnnotationBytes(),
                                SharedSecrets.getJavaLangAccess().
                                        getConstantPool(getDeclaringClass()),
                                getDeclaringClass()
                        );
                    }
                    declaredAnnotations = declAnnos;
                }
            }
        }
        return declAnnos;
    }
}
~~~


하지만 코틀린은 제네릭 정보를 런타인 시점에 잃지 않고 사용할 수 있다. 

~~~kotlin
@SinceKotlin("1.1")
inline fun <reified T : Annotation> KAnnotatedElement.findAnnotation(): T? =
    @Suppress("UNCHECKED_CAST")
    annotations.firstOrNull { it is T } as T?

/**
 * Returns true if this element is annotated with an annotation of type [T].
 */
@ExperimentalStdlibApi
@SinceKotlin("1.3")
inline fun <reified T : Annotation> KAnnotatedElement.hasAnnotation(): Boolean =
    findAnnotation<T>() != null

~~~


- 중요한건 reified은 inline과 결합되어야 한다. 잊지말자~


