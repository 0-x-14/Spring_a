package umc.jupy.service.MemberService;

import umc.jupy.domain.Member;
import umc.jupy.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
