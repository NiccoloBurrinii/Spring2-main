package TPSIT.meucci.Spring2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TPSIT.meucci.Spring2.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

    List<Persona> findByName(String name);
}