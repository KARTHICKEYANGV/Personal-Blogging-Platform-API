package com.api.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogEntity save(BlogEntity blogEntity) {
        return blogRepository.save(blogEntity);
    }

    public BlogEntity findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public BlogEntity update(Long id, BlogEntity blogEntity) {
        BlogEntity existingBlog = blogRepository.findById(id).orElse(null);
        if (existingBlog != null) {
            existingBlog.setTitle(blogEntity.getTitle());
            existingBlog.setContent(blogEntity.getContent());
            existingBlog.setCategory(blogEntity.getCategory());
            existingBlog.setTags(blogEntity.getTags());
            return blogRepository.save(existingBlog);
        }
        return null;
    }

    public List<BlogEntity> findAll(String category, String title) {
        if (category != null && title != null) {
            return blogRepository.findByCategoryAndTitle(category, title);
        }
        if (category != null) {
            return blogRepository.findByCategory(category);
        }
        if (title != null) {
            return blogRepository.findByTitle(title);
        }
        return blogRepository.findAll();
    }

}
