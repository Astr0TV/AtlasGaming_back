package fr.projet.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.projet.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByEmailAndMdp (String email ,String mdp);

}