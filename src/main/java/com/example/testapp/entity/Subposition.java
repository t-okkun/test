package com.example.testapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Subposition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "player_id")
	    private Players player;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "position_id")
	    private Position position;

	    private String name;
}
