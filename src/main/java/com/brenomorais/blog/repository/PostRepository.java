package com.brenomorais.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenomorais.blog.model.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {

	//Inteface deve estender a clase JpaRepository e declarar nos parametros a entidade Post e o tipo da chave primaria.
	
	
	/* Para evitar refatorar todo implementação pelo novo meotod findById 
	 * O findOne foi substituido pelo findById mas não é uma sustituição exata, pois ele retorna um Option 
	 * e seu antecessor retorna um null. E possivel tranformar um findById em findOne como: orElse(null)
	 * implementado no metodo abaixo, isso evita um refactor gigantesco no sistema 
	 */
	
	default Post findOne(Long id) { 
        return (Post) findById(id).orElse(null); 
    } 

}
