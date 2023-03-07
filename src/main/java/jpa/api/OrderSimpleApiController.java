package jpa.api;

import jpa.domain.Address;
import jpa.domain.Order;
import jpa.domain.OrderStatus;
import jpa.repository.OrderRepository;
import jpa.repository.OrderSearch;

import jpa.repository.order.simplequery.OrderSimpleQueryDto;
import jpa.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne
 * order
 * order -> member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderRepository orderRepository;
    private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); //Lazy 강제 초기화
            order.getDelivery().getAddress(); //Lazy 강제 초기화
        }
        return all;
    }

    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        //ORDER 2개
        //N + 1 -> 1 + N(2) 첫 번째 쿼리의 결과로 N번만큼 쿼리가 추가 실행되는 것이 N + 1 문제
        //1 + 회원 N + 배송 N
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        //생성자를 통해 생성할 때, 쿼리가 5방이 나감 -> order가 2개여서
        List<SimpleOrderDto> result = orders.stream().map(o -> new SimpleOrderDto(o)).collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        List<SimpleOrderDto> result = orders.stream().map(o -> new SimpleOrderDto(o)).collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> ordersV4() {
        return orderSimpleQueryRepository.findOrderDtos();
    }
        @Data
        static class SimpleOrderDto {
            private Long orderId;
            private String name;
            private LocalDateTime orderDate;
            private OrderStatus orderStatus;
            private Address address;


            //order 조회, member 조회, Delivery 조회
            public SimpleOrderDto(Order order) {
                this.orderId = order.getId();
                this.name = order.getMember().getName(); //LAZY 초기화
                this.orderDate = order.getOrderDate();
                this.orderStatus = order.getStatus();
                this.address = order.getDelivery().getAddress(); //LAZY 초기화
            }
        }

    }
