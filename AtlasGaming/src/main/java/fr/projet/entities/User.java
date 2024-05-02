package fr.projet.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor   @AllArgsConstructor @Data

public class User {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String email;
    private String mdp;
    

}

