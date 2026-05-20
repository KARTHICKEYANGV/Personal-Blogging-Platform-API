package com.api.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService blogService;

    //create API
    @PostMapping("/create")
    public ResponseEntity<BlogEntity> createBlog(@RequestBody BlogEntity blogEntity) {
        BlogEntity savedBlog = blogService.save(blogEntity);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BlogEntity> getBlog(@PathVariable Long id) {
        BlogEntity blog = blogService.findById(id);
        if (blog != null) {
            return ResponseEntity.ok(blog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BlogEntity> updateBlog(@PathVariable Long id, @RequestBody BlogEntity updatedBlog) {
        BlogEntity blog = blogService.update(id, updatedBlog);
        if (blog != null) {
            return ResponseEntity.ok(blog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BlogEntity>> getAllBlogs() {
        return new ResponseEntity<List<BlogEntity>>(blogService.findAll(), HttpStatus.OK);
    }

}
