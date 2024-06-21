package umc.jupy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jupy.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
