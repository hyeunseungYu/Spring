package justJava.order;

import justJava.discount.DiscountPolicy;
import justJava.discount.FixDiscountPolicy;
import justJava.discount.RateDiscountPolicy;
import justJava.member.Member;
import justJava.member.MemberRepository;
import justJava.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemname, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemname, itemPrice, discountPrice);
    }
}
