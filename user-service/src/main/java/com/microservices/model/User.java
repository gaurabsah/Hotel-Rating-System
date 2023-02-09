package com.microservices.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "userTbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "userName", length = 25)
	private String name;

	@Column(name = "userEmail", unique = true)
	private String email;

	@Column(name = "userAbout", length = 150)
	private String about;

//	we don't want to save ratings in db so use Transient
	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
