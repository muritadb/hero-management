package com.murita.hero_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murita.hero_management.entities.Hero;
import com.murita.hero_management.repositories.HeroRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/heroes")
public class HeroController {

  @Autowired
  private HeroRepository heroRepository;

  @GetMapping
  public List<Hero> listar() {
    return heroRepository.findAll();
  }

  @PostMapping
  public List<Hero> insert(@RequestBody List<Hero> hero) {
    return heroRepository.saveAll(hero);
  }

  @PutMapping
  public Hero update(@RequestBody Hero hero) {
    if (hero.getId() > 0) {
      return heroRepository.save(hero);
    }

    return null;
  }

  @DeleteMapping
  public String delete(@RequestBody Hero hero) {
    if (hero.getId() > 0) {
      heroRepository.delete(hero);
      return "heroi deletado com sucesso !";
    }

    return "heroi nao encontrado";
  }
}
