package umc.spring.service.MemberService;

import umc.spring.domain.mapping.Member;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
