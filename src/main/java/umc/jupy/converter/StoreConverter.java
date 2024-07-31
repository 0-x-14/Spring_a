package umc.jupy.converter;

import umc.jupy.domain.Review;
import umc.jupy.web.dto.StoreRequestDTO;
import umc.jupy.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.RegisterReviewDTO toRegisterReviewDTO(Review review) {
        return StoreResponseDTO.RegisterReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.RegisterReviewDTO request) {
        return Review.builder()
                .rate(request.getRate())
                .content(request.getContent())
                .build();
    }
}
