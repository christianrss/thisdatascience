package com.thisdatascience.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisdatascience.portal.model.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Long> {

}
