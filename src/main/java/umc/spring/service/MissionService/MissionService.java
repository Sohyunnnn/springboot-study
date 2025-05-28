package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<Mission> getMissionsByStore(Long storeId) {
        return missionRepository.findAllByStoreId(storeId);
    }
}
