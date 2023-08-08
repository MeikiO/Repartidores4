package edu.mondragon.mikel_murua.repartidores4.pedidos;

import java.util.HashSet;
import java.util.Set;

public class Pedido_Pojo {

	public double precio_total;
		
	Set<Linea_Pojo> lista_Lineas;
	
	public Pedido_Pojo() {
		lista_Lineas=new HashSet<>();
	}
	
	public Pedido_Pojo(double precio_total) {
		super();
		this.precio_total = precio_total;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}


	public void addLinea(Linea_Pojo linea) {
		this.lista_Lineas.add(linea);
	}

	public int getNumeroLineas() {
		return this.lista_Lineas.size();
	}
}
