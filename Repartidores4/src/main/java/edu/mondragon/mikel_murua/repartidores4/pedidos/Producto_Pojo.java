package edu.mondragon.mikel_murua.repartidores4.pedidos;

public class Producto_Pojo {

	private int precio;

	public Producto_Pojo() {
	}
	
	public Producto_Pojo(int i) {
		this.precio=i;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}	
}
