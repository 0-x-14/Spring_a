package umc.jupy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.jupy.apiPayload.code.status.ErrorStatus;
import umc.jupy.repository.FoodCategoryRepository;
import umc.jupy.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    // ConstraintValidator 인터페이스에 대한 구체화 클래스로 만들어야 함
    // ExistCategories 어노테이션에 대한 로직을 담을 것이며, 검증 대상은 List<Long>

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // 검증 대상인 List<Long>의 값을 가진 카테고리가 모두 DB에 있는 지를 판단
        // 없을 경우 false 반환
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}