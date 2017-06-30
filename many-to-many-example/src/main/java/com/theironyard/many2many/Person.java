package com.theironyard.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="person") 
class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	// This "mappedBy" attribute means that
	// the person-skill relationship will share
	// a single join table. If you do not have
	// the "mappedBy", the person-skill relationship
	// would be different than the skill-person
	// relationship yielding two unidirectional
	// relationships.
	@ManyToMany(mappedBy="people")
	private List<Skill> skills;
	
	// Cascade inserts and updates to the pets,
	// too.
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Pet> pets;
	
	public Person() {
		skills = new ArrayList<Skill>();
		pets = new ArrayList<Pet>();
	}
	
	public Person(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}