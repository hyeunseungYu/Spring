package justJava.order;

import justJava.Appconfig;
import justJava.member.Grade;
import justJava.member.Member;
import justJava.member.MemberService;
import justJava.member.MemberServiceImpl;
import justJava.order.Order;
import justJava.order.OrderService;
import justJava.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {
    public static void main(String[] args) {
//        Appconfig appconfig = new Appconfig();
//        MemberService memberService = appconfig.memberService();
//        OrderService orderService = appconfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = "+order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());

    }
}
