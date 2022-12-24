package springexample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springexample.spring.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
