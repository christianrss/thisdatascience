package com.thisdatascience.portal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thisdatascience.portal.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
	@Query("SELECT p FROM PostModel p WHERE p.Slug = %?1")
	PostModel findBySlug(String Slug);
}
