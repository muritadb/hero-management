package com.murita.hero_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murita.hero_management.entities.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {

}
