package com.dogether.dogether_back.domain.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    private String userId;
    private MultipartFile image; // 이미지를 받음
}
