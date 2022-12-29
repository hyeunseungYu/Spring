package justJava;

import justJava.discount.DiscountPolicy;
import justJava.discount.FixDiscountPolicy;
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

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
