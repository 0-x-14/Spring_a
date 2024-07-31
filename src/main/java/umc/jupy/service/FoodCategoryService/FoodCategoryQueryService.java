package umc.jupy.service.FoodCategoryService;

import umc.jupy.domain.FoodCategory;

import java.util.Optional;

public interface FoodCategoryQueryService {

    Optional<FoodCategory> findFoodCategory(Long id);
}
