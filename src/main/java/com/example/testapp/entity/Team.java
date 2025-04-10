package com.example.testapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Team {
	@Id
	private Integer id;
	private String name;
	@ManyToOne
	private Leagues league;  // 外部キーとしてリーグIDを保持
}

