package com.dogether.dogether_back.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이미지에 대한 entity

@Getter @Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte Data;
}
