package com.example.testapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Position {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	}


