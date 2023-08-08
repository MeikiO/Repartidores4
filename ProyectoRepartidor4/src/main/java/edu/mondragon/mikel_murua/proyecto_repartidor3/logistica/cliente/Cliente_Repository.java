package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;


public interface Cliente_Repository extends JpaRepository<Cliente_Pojo, Long> {
	Cliente_Pojo findByUser(UserAccount_Pojo user);
}
