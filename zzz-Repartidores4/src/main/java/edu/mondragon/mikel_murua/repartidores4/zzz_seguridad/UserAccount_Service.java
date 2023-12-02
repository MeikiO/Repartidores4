package edu.mondragon.mikel_murua.repartidores4.zzz_seguridad;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserAccount_Service {

	
	public UserAccount_Repository credenciales;

	
	public UserAccount_Service(UserAccount_Repository user) {
		this.credenciales = user;
	}

	
	
	public Long numero_de_elementos_en_database() {
		return this.credenciales.count();
	}


	public UserAccount_Pojo buscarPorID(Long id) {
		//Objeto Optional -> sirve para definir y automatizar el null
    	// y sirve para comprobar si esta o no esta.
        Optional<UserAccount_Pojo> persona = this.credenciales.findById(id);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new UserAccount_Pojo();
        }
	}

	

	public void registrarEnDatabase(UserAccount_Pojo objeto) {
			if (!objeto.getUsername().isBlank() && !objeto.getContrasena().isBlank()) {
	            this.credenciales.save(objeto);
	        }
	}


	public void actualizar(UserAccount_Pojo objeto) {
	 	   if (objeto.getIdInterno() != null & !objeto.getUsername().isBlank() && !objeto.getContrasena().isBlank()) {
	    		  
    		   /*
    		    Para actualizar usa save, para entender esto hay que saber estas 2 cosas:
    		    + Spring boot no guarda y accede directamente a la database, 
    		    lo hace en un cache que tiene, y todos los cambios los vuelca hay, antes de pasarlos a database.
    		    
    		    + Por esta misma razon, si el pojo (entidad) ha sido previamente buscada con
    		    findId(), queda registro de ello y en vez de guardar un nuevo elemento, actualiza el existente
    		    cuando hacemo save().
    		    
    		    */
    		   //this.repa.deleteById(unaPersona.getId_repartidor());
    	       this.credenciales.save(objeto);
    	   }
	}

	public void borrarElemento(Long id) {
	}

	// Esta clase sirve exclusivamente para poder hacer uso de los metodos que nos 
	// da el interface de REPOSITORYREPARTIDOR. para poder hacer uso de los metodos
	// JpaRepository

	
    private boolean userExists(String username) {
        return this.credenciales.findByUsername(username) != null;
    }



}
