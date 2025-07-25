package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);

    Optional<Member> findByEmail(String email);
}