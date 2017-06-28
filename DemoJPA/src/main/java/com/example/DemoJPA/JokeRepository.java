package com.example.DemoJPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<Joke, Integer> {
	
}