package com.api.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogEntity save(BlogEntity blogEntity) {
        return blogRepository.save(blogEntity);
    }

}
