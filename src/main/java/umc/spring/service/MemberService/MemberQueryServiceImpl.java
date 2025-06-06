package umc.spring.service.MemberService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.mapping.Member;
import umc.spring.web.dto.MemberResponseDTO;

public class MemberQueryServiceImpl {
    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }

}
