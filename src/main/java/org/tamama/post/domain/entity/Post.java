package org.tamama.post.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.tamama.common.entity.BaseTimeEntity;
import org.tamama.post.domain.converter.PublicYnConverter;
import org.tamama.post.domain.value.Creator;
import org.tamama.post.domain.value.PostId;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PostId id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private String imageUrl;

    @Embedded
    private Creator creator;

    @Column(name = "public_yn", columnDefinition = "varchar(1)")
    @Convert(converter = PublicYnConverter.class)
    private boolean isPublic;
}
