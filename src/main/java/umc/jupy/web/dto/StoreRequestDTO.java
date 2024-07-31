package umc.jupy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class RegisterReviewDTO {
        @NotBlank
        String title;
        @NotNull
        Integer rate;
        @NotBlank
        String content;
    }
}
