package com.brenomorais.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenomorais.blog.model.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {

	Post findOne(Long id);

}
