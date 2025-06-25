package org.tamama.post.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamama.post.domain.entity.Post;
import org.tamama.post.domain.value.PostId;

public interface PostJpaRepository extends JpaRepository<Post, PostId> {
}
