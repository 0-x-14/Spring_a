package umc.jupy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.jupy.apiPayload.code.status.ErrorStatus;
import umc.jupy.domain.FoodCategory;
import umc.jupy.repository.FoodCategoryRepository;
import umc.jupy.service.FoodCategoryService.FoodCategoryQueryService;
import umc.jupy.validation.annotation.ExistCategories;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    // ConstraintValidator 인터페이스에 대한 구체화 클래스로 만들어야 함
    // ExistCategories 어노테이션에 대한 로직을 담을 것이며, 검증 대상은 List<Long>

    // private final FoodCategoryRepository foodCategoryRepository;
    private final FoodCategoryQueryService foodCategoryQueryService;


    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // 검증 대상인 List<Long>의 값을 가진 카테고리가 모두 DB에 있는 지를 판단
        // 없을 경우 false 반환
        // boolean isValid = values.stream()
        //         .allMatch(value -> foodCategoryRepository.existsById(value));
        // 기존 코드 - CategoriesExistValidator가 FoodCategoryRepository에 직접 접근
        // 하지만 repository에 접근하는 계층은 service 하나만 있는 게 좋다.

        // 따라서 FoodCategoryQueryService와 FoodCategoryQueryServiceImpl을 추가하여
        // FoodCategoryRepository에 서비스가 접근하도록 처리하였음!!

        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryQueryService.findFoodCategory(value).isPresent());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}