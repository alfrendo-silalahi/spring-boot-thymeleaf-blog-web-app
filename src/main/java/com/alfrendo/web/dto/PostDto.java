package com.alfrendo.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostDto {

    private Long id;

    @NotEmpty(message = "Post title should not be empty")
    private String title;

    private String url;

    @NotEmpty(message = "Content title should not be empty")
    private String content;

    @NotEmpty(message = "Short description should not be empty")
    private String shortDescription;

    private LocalDateTime createdOn;

    private LocalDateTime updateOn;

}
