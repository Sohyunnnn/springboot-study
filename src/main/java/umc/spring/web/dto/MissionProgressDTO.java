package umc.spring.web.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import umc.spring.domain.Mission;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "진행 중인 미션 응답 DTO")
public class MissionProgressDTO {

    @Schema(description = "미션 ID")
    private Long id;

    @Schema(description = "미션 설명")
    private String missionSpec;

    @Schema(description = "미션 보상")
    private Integer reward;

    @Schema(description = "마감일")
    private LocalDate deadline;

    public static MissionProgressDTO from(Mission mission) {
        return MissionProgressDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }
}
