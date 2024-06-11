package com.thisdatascience.portal.controller;

import com.thisdatascience.portal.model.PostModel;
import com.thisdatascience.portal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
	@Autowired
	private PostRepository repository;
	
	@GetMapping("/all")
	public List<PostModel> getPosts() {
		return repository.findAll();
	}

	@GetMapping("/{slug}")
	public PostModel getPost(@PathVariable String slug) {
		return repository.findBySlug(slug);
	}
	
	@PostMapping("/create")
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
