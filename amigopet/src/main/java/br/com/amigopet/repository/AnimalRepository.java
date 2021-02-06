package br.com.amigopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
