package com.api.blog;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "posts")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String category;

    @ElementCollection
    @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id"))
    @Column(name = "tag")
    private List<String> tags;


}
