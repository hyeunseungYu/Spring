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
