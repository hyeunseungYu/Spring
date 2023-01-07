package mySelectShopBeta.repository;


import mySelectShopBeta.entity.ApiUseTime;
import mySelectShopBeta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUseTimeRepository extends JpaRepository<ApiUseTime, Long> {
    Optional<ApiUseTime> findByUser(User user);
}