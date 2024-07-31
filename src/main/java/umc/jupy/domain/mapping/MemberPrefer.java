package umc.jupy.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.jupy.domain.FoodCategory;
import umc.jupy.domain.Member;
import umc.jupy.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member){
        if(this.member != null)
            // 객체가 이미 다른 member에 속한 경우 해당 member의 MemberPreferList에서 이 객체를 제거함
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
        // member 객체의 MemberPreferList에 현재 MemberPrefer 객체를 추가함
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
        // MemberPrefer 객체의 foodCategory 필드를 설정
    }

}