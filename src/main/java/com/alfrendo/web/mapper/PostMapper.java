package com.alfrendo.web.mapper;

import com.alfrendo.web.dto.PostDto;
import com.alfrendo.web.entity.Post;

public class PostMapper {

    // map post entity to post dto
    public static PostDto mapPostToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updateOn(post.getUpdateOn())
                .build();
    }

    // map post dto to post entity
    public static Post mapPostDtoToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updateOn(postDto.getUpdateOn())
                .build();
    }

}
