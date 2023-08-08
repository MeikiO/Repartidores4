package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente.Cliente_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Pojo;

public interface Pedidos_Repository extends JpaRepository<Pedido_Pojo, Long> {
	List<Pedido_Pojo> findByPuntoReparto(Cliente_Pojo puntoReparto);
	List<Pedido_Pojo> findByEstadoPedido(String estadoPedido);
	Set<Pedido_Pojo>  findByRepartidorEncargado(Repartidor_Pojo repartidorEncargado);
}
