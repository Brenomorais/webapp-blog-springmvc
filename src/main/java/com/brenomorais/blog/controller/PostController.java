package com.brenomorais.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brenomorais.blog.model.Post;
import com.brenomorais.blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService service;
	
	//Direciona para a pagina principal
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", service.findAll());		
		return mv;		
	}
	
	//Direciona para pagina de criar um novo post
	@GetMapping("/add")
	public ModelAndView add(Post post) {
		
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", post);
		
		return mv;
	}
	
	//Direciona para pagina de alteração de post
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Deleta um post pelo Id e redireciona para pagina principal	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);		
		return findAll();
	}

	//Salva um novo post no banco de dados, se tiver preenchido corretamente salva o post
	//se tiver erro retorna para pagina exibindo as mensagem de erro
	@PostMapping("/save")
	public ModelAndView save(@Valid Post post, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(post);
		}		
		service.save(post);
		
		return findAll();
	}	
	
	//Direciona para pagina de visualização do post
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id") Long id) {	
		
		ModelAndView mv = new ModelAndView("/visualizar");
		mv.addObject("post", service.findOne(id));
		
		return mv;	
		
	}

}
