package com.theironyard.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="pets")
	private List<Person> owners;
	
	public Pet() {
		owners = new ArrayList<Person>();
	}
	
	public Pet(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public String toString() {
		return "(pet: " + this.name + " owners: " + this.owners.size() + ")";
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

	public List<Person> getPeople() {
		return owners;
	}

	public void setPeople(List<Person> people) {
		this.owners = people;
	}
}
