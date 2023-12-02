package edu.mondragon.mikel_murua.repartidores4.pedidos;

import java.util.HashSet;
import java.util.Set;

public class Pedido_Pojo {
		
	Set<Linea_Pojo> lista_Lineas;
	
	public Pedido_Pojo() {
		lista_Lineas=new HashSet<>();
	}
	

	public void addLinea(Linea_Pojo linea) {
		this.lista_Lineas.add(linea);
	}

	public int getNumeroLineas() {
		return this.lista_Lineas.size();
	}
	

	public double calcularTotalPedido() {
		double result=0.0;
		
		for(Linea_Pojo actual : this.lista_Lineas) {
			result = result + actual.calcularTotalLinea();
		}
		
		return result;
	}
	
}
