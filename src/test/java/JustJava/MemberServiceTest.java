package JustJava;

import justJava.Appconfig;
import justJava.member.Grade;
import justJava.member.Member;
import justJava.member.MemberService;
import justJava.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join() {
//        join
        Member member = new Member(1L, "memberA", Grade.VIP);
//        given
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
//        then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
