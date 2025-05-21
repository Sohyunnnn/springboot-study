package umc.spring.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.mapping.Member;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)  // Many-to-One 관계 설정
    @JoinColumn(name = "member_id")  // 외래 키 컬럼 이름 설정

    private Member member;

}