package umc.spring.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.web.dto.MissionResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "미션", description = "미션 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {

    private final MissionService missionService;

    @Operation(
            summary = "특정 가게의 미션 목록 조회",
            description = "storeId에 해당하는 가게의 미션 리스트를 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "성공적으로 미션을 조회했습니다.")
    @GetMapping("/stores/{storeId}/missions")
    public ResponseEntity<List<MissionResponseDTO>> getMissionsByStore(@PathVariable Long storeId) {
        List<Mission> missions = missionService.getMissionsByStore(storeId);
        List<MissionResponseDTO> result = missions.stream()
                .map(MissionResponseDTO::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }


    @Operation(
            summary = "내가 진행 중인 미션 목록 조회",
            description = "memberId에 해당하는 회원이 진행 중인 미션 리스트를 반환합니다."
    )
    @ApiResponse(responseCode = "200", description = "성공적으로 진행 중인 미션 목록을 조회했습니다.")
    @GetMapping("/members/{memberId}/missions/ongoing")
    public ResponseEntity<List<MissionResponseDTO>> getOngoingMissionsByMember(@PathVariable Long memberId) {
        List<Mission> missions = missionService.getOngoingMissionsByMember(memberId);
        List<MissionResponseDTO> result = missions.stream()
                .map(MissionResponseDTO::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
