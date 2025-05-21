package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}