//package org.tamama.post.application.service;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.tamama.post.common.dto.req.PostReqDto;
//import org.tamama.post.common.dto.res.PostResDto;
//import org.tamama.post.common.mapper.PostMapper;
//import org.tamama.post.domain.entity.Post;
//import org.tamama.post.infrastructure.PostRepository;
////import org.tamama.support.application.service.FileService;
//
//@RequiredArgsConstructor
//@Service
//public class PostService {
//    private final PostMapper postMapper;
//    private final PostRepository postRepository;
//    private final FileService fileService;
//
//    @Transactional
//    public PostResDto createPost(PostReqDto postReqDto) {
//        // 이미지 처리
//        String imageUrl = fileService.uploadFile(postReqDto.image());
//
//        // DB에 포스트 저장
//        Post post = Post.builder()
//                .title(postReqDto.title())
//                .contents(postReqDto.contents())
//                .imageUrl(imageUrl)
//                .build();
//
//        postRepository.save(post);
//
//        return postMapper.toDto(post);
//    }
//}
