package org.tamama.post.common.dto.req;

import org.springframework.web.multipart.MultipartFile;

public record PostReqDto(String title,
                         String contents,
                         MultipartFile image) {
}
