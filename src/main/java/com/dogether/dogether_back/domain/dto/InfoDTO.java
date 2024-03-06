package com.dogether.dogether_back.domain.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoDTO {

    private Long id;
    private String userId;
    private String name;
    private byte[] profileImage;
}
