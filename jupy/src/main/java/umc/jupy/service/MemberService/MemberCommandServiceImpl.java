package umc.jupy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.jupy.apiPayload.code.status.ErrorStatus;
import umc.jupy.apiPayload.exception.handler.FoodCategoryHandler;
import umc.jupy.converter.MemberConverter;
import umc.jupy.converter.MemberPreferConverter;
import umc.jupy.domain.FoodCategory;
import umc.jupy.domain.Member;
import umc.jupy.domain.mapping.MemberPrefer;
import umc.jupy.dto.MemberRequestDTO;
import umc.jupy.repository.FoodCategoryRepository;
import umc.jupy.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        // 요청이 들어온 멤버의 정보를 MemberConverter를 통해 Member 객체로 변환해서 newMember에 저장함

        List<FoodCategory> foodFoodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    // 응답받은 카테고리 리스트를 Category 객체 리스트로 변환해서 foodCategoryList에 저장
                    // 만약 카테고리의 id를 찾지 못할 경우 FoodCategoryHandler 예외 발생
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodFoodCategoryList);
        // foodCategoryList를 MemberPreferList로 변환

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        // 각 MemberPrefer 객체에 newMember 설정

        return memberRepository.save(newMember);
        // newMember를 db에 저장
    }
}
