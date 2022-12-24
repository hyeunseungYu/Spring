package springexample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springexample.spring.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberName(String memberName);
}
