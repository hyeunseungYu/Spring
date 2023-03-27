# 학습한 내용 정리

<details>
<summary style="font-size: x-large">TDD란</summary>

테스트 주도 개발을 뜻함.
지금은 먼저 domain 패키지에 Member라는 부모 클래스를 만들고,
memberRepository라는 인터페이스를 만들어 내가 구현해야 하는 것들의 명세를 작성하였다.

이후 main의 레포지토리에서 클래스를 만들어 그것들을 실제로 구현하고,
test에서 @Test를 사용하며 테스트를 진행하였다.

TDD는 이것의 반대 순서로 가는 것이다.

내가 별 모양 작품을 만든다고 하면,
별 모양 틀을 먼저 만들고 작품이 들어가는 지를 확인하는 것!

테스트를 먼저 만들고, 구현 클래스를 만들어서 테스트를 진행하는 것!
</details>
<br>

<details>
<summary style="font-size: x-large">@ResponseBody 어노테이션?</summary>
해당 어노테이션이 찍혀있으면 spring은 return값의 html을 렌더해 주는 게 아니라
문자 내용을 그대로 찍어준다. (HTTP의 Body에 문자 내용을 그대로 반환한다는 말)

글자는 그대로 찍어주면 되는데 만약 객체를 넘겨준다면?
이것은 JSON 방식으로 data를 만들어서 HTTP응답에 반환해 주는게 default!

api를 보통 이것을 이용하여 만든다.
</details>
<br>

<details>
<summary style="font-size: x-large">@RestController</summary>
@Controller 와 @ResponseBody를 합친 역할을 하는 것
@RestController를 사용하면 따로 method들에 @ResponseBody를 사용하지 않아도
controller 내부의 메소드 내용들이 ResponseBody가 적용되어 나온다.
</details>
<br>

<details>
<summary style="font-size: x-large">Repository?</summary>
Entity 객체를 DB와 연결시켜주는 역할을 한다.
만들때에는 인터페이스로 만들고, 어떤 테이블과 연결할 지 제네릭스에 작성한다.

예시로
"Public interface ProductRepository extends JpaRepository <Food, Long>" 이런 식으로 작성하는데,
제네릭스 안의 첫번째에는 연결할 테이블을 작성하고 뒤에는 타입을 작성한다.
</details>
<br>

<details>
<summary style="font-size: x-large">@GetParam 사용시 GET과 POST의 차이</summary>
html에서 form 태그를 이용할 때 get 방식을 사용하면 url에 주고받는 내용이 바로 표시가 되지만,
post방식으로 보냈을 때에는 url 방식으로 보냈을 때에는 값이 표현이 되지 않고 payload에 실려서 들어가게 된다.

html에서 form태그를 통해서 값을 보낼때 @RequestParam으로 값을 받을 수 있다.
</details>
<br>

<details>
<summary style="font-size: x-large">@ModelAttribute</summary>
클라이언트에서 보내는 값이 여러개일 때, @ModelAttribute를 사용해서 값을 객체 형식으로 받을 수 있다.
사용할 때에는 객체의 필드에 접근을 해서 사용하면 되지만 객체에 @Setter가 꼭 설정되어 있어야 한다.

덧붙여 @ModelAttribute는 생략이 가능하다.

</details>
<br>

<details>
<summary style="font-size: x-large">ModelAndView</summary>
Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
ModelAndView는 데이터와 이동하고자 하는 View Page를 같이 저장한다.

예시로 아래와 같이 사용할 수 있다.
@RequestMapping("/api/member")
public ModelAndView view(){

//데이터와 뷰를 동시에 설정 가능하다
return new ModelAndView("index", "123");

</details>
<br>

<details>
<summary style="font-size: x-large">@Entity</summary>
기본 생성자는 필수로 있어야 함! -> jpa 규정이라고 함.   <br>
저장할 필드에 final사용할 수 없음   <br>
jpa를 사용해서 테이블과 매핑할 클래스는 @Entity가 필수<br>
final클래스, enum, interface, inner(중첩클래스) 클래스는 @Entity를 사용할 수 없음<br>
예시) @Entity(name="Member")<br>
jpa가 내부적으로 구분하는 이름으로, 설정을 따로 안하면 기본값으로 클래스 이름을 그대로 사용한다.<br>
클래스 이름이 겹치거나 하는 게 아니면 바꾸지 말자.<br>
</details>
<br>

<details>
<summary style="font-size: x-large">@Table</summary>
Entity에 해당되는 파일에 @Entity와 @Table을 사용할 수 있음.<br>
일단 @Entity는 필수. 다만 Entity만 사용했을 때에는 DB와 연결할 때, 테이블 명이 클래스와 동일하게 설명됨<br>
즉 클래스 이름이 Member라면, DB에서 Member 테이블로 연결된다는 얘기.<br>
@Table 어노테이션은 실제 DB에 붙을 테이블명을 말함.<br>
예를들어 @Entity / @Table(name = "hello")라고 지정을 해 두면,<br>
createQuery(select * from Member)로 호출을 하면 호출은 엔티티 클래스 이름으로 가는데, 실제 DB에는 테이블 네임으로 붙는다<br>
</details>
<br>

<details>
<summary style="font-size: x-large">로드밸런싱</summary>
다수의 인스턴스로 서비스를 돌리고 이를 웹 서버로 잘 밸런싱 해 주는 것을 말한다.<br>
이렇게 되면 사용자들이 한 서버에 몰리지 않게 분산처리가 되어 서버의 부하를 막을 수 있다.<br>

또한 한 서비스에 서버를 두 개를 두는 경우가 있다. 이것은 지속성을 위함이다.<br>
예를 들어 kirin.com이라는 곳에서 업데이트가 생겼다. 만일 하나의 서버에서 이 서비스가 작동하고 있었다면<br>
아무리 업데이트가 빨라도 사용자는 업데이트가 진행되는 동안 에러를 마주할 가능성이 생긴다.<br>

이런일이 발생하지 않도록 하나의 서버에서 업데이트가 진행될 때, 다른 서버에서 업데이트가 진행될 수 있도록 하는 것이다.<br>
</details>
<br>

<details>
<summary style="font-size: x-large">리버스 프록시</summary>
보통 프록시를 떠올리면, 내가 특정 사이트에 접속할 때 내 아이피 대신 서버의 아이피를 보여주는 것만을 생각했다.<br>
이렇게 사용자들이 어딘가에 접속을 할 때 프록시 서버를 거쳐 자신의 아이피를 숨기고 접속하는 것을 forward proxy라고 한다.<br>

반대로 방문하는 사람들로부터 서버의 정보를 감추는 것을 reverse proxy라고 한다.<br>
서버 내부적으로 파일이 어느 폴더에 들어있고 서비스가 몇 번 포트로 돌고 있는지를 감추는 것이다.<br>

이것을 활용해서! 한 서버에서 여러 웹이 돌고 있다고 생각을 해 보자.<br>
이런 상황에서 사용자들이 들어올 때 어느 주소로 사용자들이 접속을 하든 웹 서버가 먼저 확인하고<br>
어떤곳을 찾아서 왔는지를 보고 그에 알맞는 처리를 해 주는 것이다. (예를 들어 kirin.com이네 ? 이건 왼쪽! longlong.com이네? 이건 오른쪽! 이런 식으로)<br>
</details>
<br>

<details>
<summary style="font-size: x-large">인덱스</summary>
인덱스는 백과사전의 목차라고 이해했다.<br>

<br>
우리가 원하는 특정 단어를 찾아볼 때, 첫 장부터 하나씩 찾아보는 것은 굉장히 비효율적이다.<br>
우리는 원하는 단어를 더욱 빠르게 찾기 위해서 사전의 목차를 확인하고 단어가 어디에 포함되어 있는지를 찾아, 바로 원하는 페이지로 이동할 것이다.<br>
<br>
좀 더 그럴듯하게 말하자면,<br>
데이터 검색 속도를 향상시키기 위해 db에서 테이블의 특정 column(field)을 기준으로 잡고,<br>
<br>
각 row(record)의 값을 가지고 있는 것을 복사하여 별도 생성하여 정렬한 것이라고도 할 수 있습니다.<br>
(출처: https://en.wikipedia.org/wiki/Database_index)<br>

인덱스를 사용하면 데이터 검색 속도가 대폭 향상되지만, 인덱스를 생성하는 작업이나 인덱스를 관리하는 데 추가로 리소스가 소모된다는 단점이 있다.<br>
(인덱스를 생성하는 작업과 유지 관리하는 오버헤드가 발생!)<br>
</details>
<br>


<details>
<summary style="font-size: x-large">제네릭</summary>

다양한 타입의 객체를 다루는 메서드나 컬렉션 클래스를 컴파일 할 때 타입 체크를 해 주는 기능이다.<br>
제네릭 타입은 클래스와 메서드에 선언할 수 있다.<br>
<br>
// 일반적인 클래스<br>
class Box {<br>
Object item;<br>
<br>
void setItem(Object item) {this.item = item;}<br>
Object getItem() {return item;}<br>
}<br>
<br>
// 제네릭 클래스<br>
class Box&lt;T> {<br>
T item;<br>
<br>
void setItem(T item) {this.item = item;}<br>
T getItem() {return item;}<br>
}<br>

위에 제네릭 클래스를 선언할 때 뒤에 &lt;T>가 붙었는데, 여기서 T를 타입 변수(type variable)이라고 한다.<br>
이 타입 변수로 어떤 타입이 들어가게 될 것이라는 것을 표시를 해 주는 것이다.<br>
임의의 변수이므로 무조건 T를 써야되는 것은 아니지만, 그래도 네이밍을 지켜주는 것이 좋다.<br>
<br>
E : 요소 (Element, 자바 컬렉션에서 주로 사용됨)<br>
K : 키<br>
N : 숫자<br>
T : 타입<br>
V : 값<br>
S,U,V : 두번 째, 세 번째, 네 번째에 선언된 타입<br>

</details>
<br>


<details>
<summary style="font-size: x-large">Element</summary>

자바 컬렉션을 뜯어보다 보면 제네릭에서 E를 많이 마주한다.<br>
여기에서 E는 element, 요소를 뜻한다.<br>
<br>
element는 어떤 자료구조에서 하나의 값 또는 객체를 의미한다.<br>
말 그대로 그 자료구조의 구성 요소를 의미하는 것이다.<br>
<br>
예를 들어, 정수형 배열에 대한 element는 배열 안에 저장된 개별적인 정수 값이다.<br>
배열 {1,2,3,4,5}에 대한 element는 1,2,3,4,5이다.<br>
<br>
ArrayList<E>의 경우에서는 ArrayList가 포함하는 element의 타입을 의미하는 것이다.<br>
ex) ArrayList<String>이면 해당 ArrayList의 element 타입이 String이라는 것<br>
</details>
<br>

<details>
<summary style="font-size: x-large">N + 1 문제</summary>

첫 번째 쿼리의 결과로 N번만큼 쿼리가 추가 실행되는 것.<br>

</details>
<br>

<details>
<summary style="font-size: x-large">mySQL pessimistic Lock</summary>

실제로 데이터에 락을 걸어 정합성을 맞추는 방법이다.<br>
락을 걸게 되면 다른 트랜잭션에서는 락이 해제되기 전까지는 데이터를 건들 수 없다.<br>

락을 통해 데이터를 제어하기 때문에 데이터의 정합성을 보장할 수는 있으나,<br>
데이터 자체에 락이 걸리기 때문에 성능 저하가 발생할 수 있다.<br>

또한, 서로 다른 스레드에서 각자 락이 걸린 데이터에 접근할 때 데드락이 발생할 수 있으며<br>
락을 걸어둔 서버에 장애가 발생하면 해당 데이터에 대한 락이 풀리지 않아 다른 서버에서 해당 데이터를 수정할 수 없는 상황이 발생할 수 있다.<br>

</details>
<br>

<details>
<summary style="font-size: x-large">redisson lock</summary>

redis의 pub-sub 기반 message broker 기능을 이용하여 락을 구현하는 방법이다.<br>
락을 해제하는 측이 락을 대기하는 프로세스에게 락 획득을 시도해도 된다는 메시지를 전달하는 방식으로 동작하며, 이 방법을 사용하면 끊임없이 redis 서버에 락 획득이 가능한지 여부를 확인하는 spin lock을 사용하지 않아도 된다.<br>

이 방법은 우리가 직접 구현할 필요가 없이 redisson이라는 라이브러리를 사용하면 된다. 이미 메시지 브로커 기능을 활용하여 락을 구현해 두었기 때문이다.<br>

또한 이 라이브러리는 타임아웃을 구현하여 일정 시간동안 락을 획득하지 못하면 예외를 발생시킬 수 있다.<br>
(pessimistic lock에서도 timeout을 구현할 수는 있다고 함. 다만 락을 유지하는 동안 리소스를 계속 점유하니 db에 계속 부하를 주게 되는 문제가 있다고 함.)<br>

</details>
<br>

<details>
<summary style="font-size: x-large">SOLID(객체지향 5대 원칙)</summary>
SRP(단일책임원칙)은 한 클래스의 하나의 책임만 가져야 합니다.<br>

OCP(개방-폐쇄 원칙)은 확장에는 열려 있으나 변경에는 닫혀 있어야 하며, 다형성을 활용해야 합니다.<br>

LSP(리스코프 치환 원칙)은 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야하는 원칙으로 상위 타입을 상속해서 재정의 했을 때 프로그램이 깨지지 않아야 합니다.<br>

ISP(인터페이스 분리 원칙)은 클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안되는 원칙입니다. 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 더 낫습니다. 즉, 비대한 인터페이스보단 더 작고 구체적인 인터페이스로 분리해야합니다.<br>

DIP(의존관계 역전 원칙)은 추상적인 것은 자신보다 구체적인 것에 의존하지 않고, 변화하기 쉬운 것에 의존해서는 안된다는 원칙입니다. 구체적으론 구현 클래스에 의존하지 말고, 인터페이스에 의존해야 하는 원칙입니다.<br>

</details>
<br>

<details>
<summary style="font-size: x-large">객체지향</summary>
객체지향은 의존성을 관리함으로써 변경 영향을 최소화하는 개발을 말합니다.<br>
이를 통해서 어플리케이션의 각 구성 요소를 독립적으로 배포할 수 있고, 여러 개발자가 동시에 작업할 수 있는 독립적인 개발이 이루어 질 수 있습니다.<br>
</details>
<br>

<details>
<summary style="font-size: x-large">객체지향 특징</summary>
객체지향의 특징으로는 추상화, 상속, 다형성, 캡슐화가 있습니다.<br>
추상화는 객체의 공통적인 속성과 기능을 추출하여 정의하는 것을 말합니다.<br>
자바에서 추상화를 구현하는 방법으로는 추상 클래스와 인터페이스가 있습니다.<br>
<br>
상속이란 클래스들 간에 공유하는 속성과 기능들을 반복적으로 정의할 필요 없이 한 번만 정의해두고 다시 재사용 할 수 있도록 하는 것을 말합니다.<br>
또한 상속을 받을 시에 상위 클래스의 기능과 속성들을 그대로 사용할 수도 있지만, 맥락에 맞게 오버라이딩을 사용하여 내용을 재정의 할 수도 있습니다.<br>
<br>
다형성은 어떤 객체의 속성이나 기능이 맥락에 따라 다른 역할을 수행할 수 있는 것을 말합니다.<br>
앞서 말한 오버라이딩이 예시가 될 수 있는데, 같은 이름의 메서드가 상황에 따라 다른 역할을 수행할 수 있기 때문입니다.<br>
<br>
마지막으로 캡슐화는 서로 관련이 있는 속성과 기능들을 하나의 캡슐로 만들어 데이터를 외부로부터 보호하는 것을 말합니다.<br>
캡슐화를 사용하게 되면 객체 내부 동작을 외부로부터 노출을 최소화해 객체간의 결합도를 낮추는 것이 가능해집니다.<br>
</details>
<br>

<details>
<summary style="font-size: x-large">REST API</summary>
HTTP 요청을 할 때, URI를 통해 자원을 표시하고 HTTP method를 통해 자원에 대한 처리를 표현하는 개발자들 사이에서 널리 사용되는 약속과 같은 것을 말합니다.<br>
이를 통해서 각 요청이 어떤 정보나 동작을 위한 것인지 그 요청 자체만으로 추론이 가능하다는 것이 장점입니다.<br>
</details>
<br>