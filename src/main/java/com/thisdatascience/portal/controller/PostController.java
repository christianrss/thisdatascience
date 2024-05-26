package com.thisdatascience.portal.controller;

import com.thisdatascience.portal.model.PostModel;
import com.thisdatascience.portal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private PostRepository repository;
	
	@GetMapping("/")
	public List<PostModel> getPosts() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public PostModel createPost(@RequestBody PostModel post) {
		return repository.save(post);
	}
	
	@PutMapping("/{id}")
	public Optional<PostModel> updatePost(@PathVariable Long id, @RequestBody PostModel post) {
		return Optional.ofNullable(repository.findById(id).map(t -> {
			t.setTitle(post.getTitle());
			t.setDescription(post.getDescription());
			return repository.save(t);
		}).orElseThrow(() -> new RuntimeException("Post not found")));
	}
}
