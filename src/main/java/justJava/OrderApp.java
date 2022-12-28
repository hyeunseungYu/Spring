package justJava;

import justJava.member.Grade;
import justJava.member.Member;
import justJava.member.MemberService;
import justJava.member.MemberServiceImpl;
import justJava.order.Order;
import justJava.order.OrderService;
import justJava.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());

    }
}
