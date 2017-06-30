package com.theironyard.many2many;

import org.springframework.stereotype.Service;

@Service class Repos {
	private SkillRepository skills;
	private PersonRepository people;
	private PetRepository pets;
	
	public Repos(SkillRepository skills, PersonRepository people, PetRepository pets) {
		this.skills = skills;
		this.people = people;
		this.pets = pets;
	}

	public SkillRepository getSkills() {
		return skills;
	}

	public PersonRepository getPeople() {
		return people;
	}

	public PetRepository getPets() {
		return pets;
	} 
}