package com.thisdatascience.portal.controller;

import com.thisdatascience.portal.model.Post;
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
	public List<Post> getPosts() {
		return repository.findAll();
	}

	@GetMapping("/{slug}")
	public Post getPost(@PathVariable String slug) {
		return repository.findBySlug(slug);
	}
	
	@PostMapping("/create")
	public Post createPost(@RequestBody Post post) {
		return repository.save(post);
	}
	
	@PutMapping("/{id}")
	public Optional<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
		return Optional.ofNullable(repository.findById(id).map(t -> {
			t.setTitle(post.getTitle());
			t.setDescription(post.getDescription());
			return repository.save(t);
		}).orElseThrow(() -> new RuntimeException("Post not found")));
	}
}
