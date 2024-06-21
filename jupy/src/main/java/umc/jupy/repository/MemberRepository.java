package umc.jupy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jupy.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
