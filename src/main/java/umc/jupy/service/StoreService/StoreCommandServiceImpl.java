package umc.jupy.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.jupy.converter.StoreConverter;
import umc.jupy.domain.Review;
import umc.jupy.repository.MemberRepository;
import umc.jupy.repository.ReviewRepository;
import umc.jupy.repository.StoreRepository;
import umc.jupy.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review registerReview(StoreRequestDTO.RegisterReviewDTO request) {
        Review newReview = StoreConverter.toReview(request);
    }
}
