package org.tamama.post.domain.value;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class PostId implements Serializable {
    private Long id;
}
