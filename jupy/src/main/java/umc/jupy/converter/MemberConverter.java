package umc.jupy.converter;

import umc.jupy.domain.Member;
import umc.jupy.domain.enums.Gender;
import umc.jupy.web.dto.MemberRequestDTO;
import umc.jupy.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        System.out.println("Member Birth: " + request.getBirth());

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .age(request.getAge())
                .name(request.getName())
                .birth(request.getBirth())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
