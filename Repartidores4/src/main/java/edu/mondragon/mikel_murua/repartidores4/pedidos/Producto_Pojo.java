package edu.mondragon.mikel_murua.repartidores4.pedidos;

public class Producto_Pojo {

	private int precio;
	private int descuento;

	public Producto_Pojo() {
	}
	
	public Producto_Pojo(int i, int j) {
		this.precio=i;
		this.descuento=j;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
}
