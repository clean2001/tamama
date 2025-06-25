package org.tamama.post.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.tamama.post.common.dto.req.PostReqDto;
import org.tamama.post.common.dto.res.PostResDto;
import org.tamama.post.domain.entity.Post;

@Mapper(componentModel = "spring") // Spring에서 의존성 주입 가능하도록 함
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResDto toDto(Post post);
    Post toEntity(PostReqDto postResDto);
}
