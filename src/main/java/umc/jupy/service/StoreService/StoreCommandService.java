package umc.jupy.service.StoreService;

import umc.jupy.domain.Review;
import umc.jupy.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review registerReview(StoreRequestDTO.RegisterReviewDTO request);
}
