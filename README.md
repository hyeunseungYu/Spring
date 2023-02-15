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