package justJava.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemname, int itemPrice);
}
