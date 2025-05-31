package org.tamama.member.domain.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.tamama.member.domain.enums.SocialType;

import java.io.Serializable;

@Embeddable
public class SocialLoginInfo implements Serializable {

    @Column(name = "social_type")
    private SocialType socialType;

    @Column(name = "social_id")
    private String socialId;
}
