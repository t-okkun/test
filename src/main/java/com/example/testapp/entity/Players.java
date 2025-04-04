package com.example.testapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Players {
	
	private Integer id;
	private String team;
	private String name;
	private String tandb;
	private Integer number;
	private String position;
	private String subposition;
	private String detail;

}
