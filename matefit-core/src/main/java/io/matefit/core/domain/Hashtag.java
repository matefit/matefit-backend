package io.matefit.core.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hashtag_id;

    // H2 Data type 적용에 문제가 없는지 확인해봐야 함
    // 1. 흡연
    @Column(nullable = false, unique = true)
    private char smoking;

    // 2. 애완 동물
    @Column(nullable = false, unique = true)
    private char pet;

    // 3. 직장인
    @Column(nullable = false, unique = true)
    private char job;

    // 4. 학생
    @Column(nullable = false, unique = true)
    private char student;

    // 5. 코골이
    @Column(nullable = false, unique = true)
    private char snoring;

    // 6. 아침형 인간
    @Column(nullable = false, unique = true)
    private char morning;

    // 7. 야행성
    @Column(nullable = false, unique = true)
    private char night;

    // 8. 야식
    @Column(nullable = false, unique = true)
    private char nightEating;

    // 9. 조용한 사람
    @Column(nullable = false, unique = true)
    private char quiet;

    // 10. 사교적인 사람
    @Column(nullable = false, unique = true)
    private char social;

    // 태그 추가할 것

    @Builder
    public Hashtag(char smoking, char pet, char job, char student, char snoring, char morning, char night, char nightEating, char quiet, char social) {
        this.smoking = smoking;
        this.pet = pet;
        this.job = job;
        this.student = student;
        this.snoring = snoring;
        this.morning = morning;
        this.night = night;
        this.nightEating = nightEating;
        this.quiet = quiet;
        this.social = social;
    }

}
