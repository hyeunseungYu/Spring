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
