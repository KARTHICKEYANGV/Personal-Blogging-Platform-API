package com.api.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService blogService;

    //create API
    @PostMapping("/create")
    public ResponseEntity<BlogEntity> createBlog(@RequestBody BlogEntity blogEntity){
        BlogEntity savedBlog = blogService.save(blogEntity);
        return ResponseEntity.ok(savedBlog);
    }
}
