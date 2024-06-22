package umc.jupy.service.FoodCategoryService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.jupy.domain.FoodCategory;
import umc.jupy.repository.FoodCategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Optional<FoodCategory> findFoodCategory(Long id) {
        return foodCategoryRepository.findById(id);
    }
}
