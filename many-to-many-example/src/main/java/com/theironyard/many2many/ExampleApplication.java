package com.theironyard.many2many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExampleApplication.class, args);
		Repos repos = (Repos)context.getBean(Repos.class);
		SkillRepository skills = repos.getSkills();
		PersonRepository people = repos.getPeople();
		PetRepository pets = repos.getPets();
		
		// There's no cascading relationship
		// between Person and Skill, so you
		// can only use already-persisted
		// instances of things.
		Skill[] facets = {
			skills.save(new Skill("Swords fighting")),
			skills.save(new Skill("Cooking")),
			skills.save(new Skill("Driving")),
			skills.save(new Skill("Orating")),
			skills.save(new Skill("Falling over"))
		};
		
		Person[] folks = {
			people.save(new Person("Asha")),
			people.save(new Person("Alberto")),
			people.save(new Person("Alexandra")),
			people.save(new Person("Andy"))
		};
		
		// Because Person has the "mappedBy"
		// attribute on the @ManyToMany, this
		// does not save any changes to the
		// database.
		folks[0].getSkills().add(facets[0]);
		people.save(folks[0]);
		
		// Skill "owns" the relationship, so
		// adding the person to the people
		// collection of the skill will save
		// the skill-person relationship.
		facets[2].getPeople().add(folks[1]);
		skills.save(facets[2]);
		
		// Even with a cascade option on,
		// when you save a relationship between
		// two previously-saved persisted
		// objects, everything works as
		// expected.
		Pet pet = pets.save(new Pet("Ubu"));
		folks[0].getPets().add(pet);
		people.save(folks[0]);
		
		// Person "owns" the pet relationship
		// AND has a cascade setting that will
		// save and update new objects when the
		// owning object is saved or updated.
		folks[1].getPets().add(new Pet("Fido"));
		people.save(folks[1]);
		
		
		Person person = new Person("Zapata");
		Pet spot = new Pet("Spot");
		person.getPets().add(spot);
		people.save(person);
		System.out.println(person);
	}
}
