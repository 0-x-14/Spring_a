package umc.jupy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.jupy.apiPayload.ApiResponse;
import umc.jupy.converter.StoreConverter;
import umc.jupy.domain.Review;
import umc.jupy.domain.Store;
import umc.jupy.service.StoreService.StoreCommandService;
import umc.jupy.web.dto.StoreRequestDTO;
import umc.jupy.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.RegisterReviewDTO> register(@RequestParam @Valid StoreRequestDTO.RegisterReviewDTO request,
                                                                    @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                    @ExistMember @RequestParam(name = "memberId") Long memberId) {
        Review review = storeCommandService.registerReview(request);
        return ApiResponse.onSuccess(StoreConverter.toRegisterReviewDTO(review));
    }
}
