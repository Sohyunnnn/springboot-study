package umc.spring.web.dto;

import lombok.*;
import umc.spring.domain.Mission;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@AllArgsConstructor
@Schema(description = "가게 미션 응답 DTO")
public class MissionResponseDTO {

    @Schema(description = "미션 ID")
    private Long id;

    @Schema(description = "미션 보상 금액")
    private Integer reward;

    @Schema(description = "미션 마감일")
    private LocalDate deadline;

    @Schema(description = "미션 설명")
    private String missionSpec;

    public static MissionResponseDTO from(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getReward(),
                mission.getDeadline(),
                mission.getMissionSpec()
        );
    }
}

