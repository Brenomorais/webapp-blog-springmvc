package com.brenomorais.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenomorais.blog.model.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {

	//Inteface deve estender a clase JpaRepository e declarar nos parametros
	// a entidade Post e o tipo da chave primaria.
	
	Post findOne(Long id);

}
