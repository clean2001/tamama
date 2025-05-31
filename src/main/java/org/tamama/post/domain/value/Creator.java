package org.tamama.post.domain.value;

import jakarta.persistence.Column;

import java.io.Serializable;

public class Creator implements Serializable {
    @Column(name = "member_id")
    private String id;

    @Column(name = "creator_nickname")
    private String nickname;
}
