package umc.jupy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.jupy.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO{

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birth;
        @NotNull
        Integer age;
        @Size(min = 5, max = 12) // 문자열 길이 제한
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        // 음식 카테고리를 조회하는 API를 호출하고,
        // 그 API의 결과에서 음식 카테고리의 id값을 프론트엔드가 넘겨준다는 것을 전제로 함
    }
}