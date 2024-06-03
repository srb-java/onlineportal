package com.onlineportal.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    
    
	public Role(String name) {
		super();
		this.name = name;
	}



	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}