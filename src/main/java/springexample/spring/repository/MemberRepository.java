package springexample.spring.repository;

import springexample.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findbyName(String name);
    List<Member> findAll();
}
