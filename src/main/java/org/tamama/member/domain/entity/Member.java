package org.tamama.member.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tamama.common.entity.BaseTimeEntity;
import org.tamama.member.domain.converter.TierConverter;
import org.tamama.member.domain.value.SocialLoginInfo;
import org.tamama.member.domain.value.Tier;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    private String email;

    private String password;

    @Embedded
    private SocialLoginInfo socialLoginInfo;

    private LocalDate birthdate;

    @Convert(converter = TierConverter.class)
    private Tier tier;
}
