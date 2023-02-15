package JustJava.singletone;

import justJava.Appconfig;
import justJava.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletoneTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        Appconfig appconfig = new Appconfig();
//        1.조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appconfig.memberService();


//        2.조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appconfig.memberService();

//        참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

//        memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

//        참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

//        memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
