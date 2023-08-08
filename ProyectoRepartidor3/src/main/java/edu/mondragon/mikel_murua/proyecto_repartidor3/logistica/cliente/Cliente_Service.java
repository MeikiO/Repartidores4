package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class Cliente_Service implements DaoServices<Cliente_Pojo>{

	public Cliente_Repository puntos;

	public Cliente_Service(Cliente_Repository puntos) {
		this.puntos = puntos;
	}

	
	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public Cliente_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(Cliente_Pojo objeto) {
	}

	@Override
	public void actualizar(Cliente_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}
	
	
	
}
