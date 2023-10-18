package com.alfrendo.web.controller;

import com.alfrendo.web.dto.PostDto;
import com.alfrendo.web.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // create handler method, GET request and return model and view
    @GetMapping(path = "admin/posts")
    public String posts(Model model) {
        var postDtos = postService.findAllPosts();
        model.addAttribute("posts", postDtos);
        return "admin/posts";
    }

    // handler method to handle new post request
    @GetMapping(path = "admin/posts/create")
    public String createPostForm(Model model) {
        var postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "admin/create-post";
    }

    // handler method to handle form submit request
    @PostMapping(path = "admin/posts/create/process")
    public String createPost(
            @Valid @ModelAttribute(name = "post") PostDto postDto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("post", postDto);
            return "admin/create-post";
        }

        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    // handler method to handle update post request
    @GetMapping(path = "admin/posts/{post-id}/update")
    public String updatePostForm(@PathVariable(name = "post-id") Long postId, Model model) {
        var post = postService.findPostById(postId);
        model.addAttribute("post", post);
        return "admin/update-post";
    }

    private static String getUrl(String postTitle) {
        // OOPS Concepts Explained in Java
        // oops-concept-explained-in-java
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }

}
