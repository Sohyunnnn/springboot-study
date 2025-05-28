package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public List<Mission> getMissionsByStore(Long storeId) {
        return missionRepository.findAllByStoreId(storeId);
    }

    // ✅ 내가 진행 중인 미션 목록 조회 메서드
    public List<Mission> getOngoingMissionsByMember(Long memberId) {
        List<MemberMission> ongoingMissions = memberMissionRepository
                .findAllByMemberIdAndStatus(memberId, MissionStatus.ONGOING);

        return ongoingMissions.stream()
                .map(MemberMission::getMission)
                .collect(Collectors.toList());
    }
}
