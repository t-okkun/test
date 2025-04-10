package com.example.testapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Players {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "team_id")
	    private Team team;

	    private String name;
	    private String tandb;
	    private Integer number;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "position_id")
	    private Position position;

	    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Subposition> subpositions;
	    
	    
	    private String detail;
}


