package umc.jupy.converter;

import umc.jupy.domain.FoodCategory;
import umc.jupy.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodFoodCategoryList){
        // 단방향 연관 관계 설정은 converter에서 해도 괜찮음
        // 하지만 양방향 연관 관계 설정은 converter보다는 service에서
        // 따라서 MemberPrefer 생성시 member를 넣지 않았음

        return foodFoodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
