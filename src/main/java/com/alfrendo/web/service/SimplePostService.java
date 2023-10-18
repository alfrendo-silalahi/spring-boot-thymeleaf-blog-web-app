package com.alfrendo.web.service;

import com.alfrendo.web.dto.PostDto;
import com.alfrendo.web.entity.Post;
import com.alfrendo.web.mapper.PostMapper;
import com.alfrendo.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimplePostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDto> findAllPosts() {
        return postRepository.findAll()
                .stream().map(PostMapper::mapPostToPostDto).toList();
    }

    @Override
    public void createPost(PostDto postDto) {
        var post = PostMapper.mapPostDtoToPost(postDto);
        System.out.println(post);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
        var post = postRepository.findById(postId).get();
        return PostMapper.mapPostToPostDto(post);
    }

}
