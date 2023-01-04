package justJava;

import justJava.discount.DiscountPolicy;

import justJava.discount.RateDiscountPolicy;
import justJava.member.MemberService;
import justJava.member.MemberServiceImpl;
import justJava.member.MemoryMemberRepository;
import justJava.order.OrderService;
import justJava.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    //"call Appconfig.memberService"
    //"call Appconfig.memberRepository"
    //"call Appconfig.orderService"
    //"call Appconfig.memberRepository"
    //"call Appconfig.memberRepository"

    @Bean
    public MemberService memberService() {
        System.out.println("call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call Appconfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository(){
        System.out.println("call Appconfig.memberRepository");
        return new MemoryMemberRepository();
    }


    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
