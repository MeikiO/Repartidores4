package edu.mondragon.mikel_murua.repartidores4.zzz_seguridad;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccount_Repository extends JpaRepository<UserAccount_Pojo, Long> {
    UserAccount_Pojo findByUsername(String username);

	
	/*
	 -> Optional<Credencial> findBy<Campo para coger en Mayuscrula la primera>(String campo por el que se busca); 
	
	 	+ Documentacion
	 	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	*/
}	

