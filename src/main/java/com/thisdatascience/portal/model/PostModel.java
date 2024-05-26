package com.thisdatascience.portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PostModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Title;
	private String Description;
	private String Content;
	public String getTitle() {
		// TODO Auto-generated method stub
		return Title;
	}
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		Title = title;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
		
	}
}
