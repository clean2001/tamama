package org.tamama.post.infrastructure;

import org.springframework.stereotype.Repository;
import org.tamama.post.domain.entity.Post;

@Repository
public interface PostRepository {
    Post save(Post post);
}
