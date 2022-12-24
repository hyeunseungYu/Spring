package springexample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springexample.spring.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
