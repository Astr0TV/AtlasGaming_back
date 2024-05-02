package fr.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projet.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
