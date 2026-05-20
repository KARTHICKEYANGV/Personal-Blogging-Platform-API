package com.api.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    List<BlogEntity> findByCategory(String category);
    List<BlogEntity> findByTitle(String title);
    List<BlogEntity> findByCategoryAndTitle(String category, String title);
}
