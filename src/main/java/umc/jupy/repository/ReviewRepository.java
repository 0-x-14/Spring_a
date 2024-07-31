package umc.jupy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jupy.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
