package com.example.testapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Leagues {
	@Id
	private Integer id;
	private String name;

}
