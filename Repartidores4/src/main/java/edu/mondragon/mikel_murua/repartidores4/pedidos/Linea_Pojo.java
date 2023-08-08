package edu.mondragon.mikel_murua.repartidores4.pedidos;

public class Linea_Pojo {

	private Producto_Pojo producto;
	private int cantidad;
	
	private Linea_Pojo() { //como es private no te deja llamarlo
	}
	
	public Linea_Pojo(int cantidad,Producto_Pojo producto) {
		this.setCantidad(cantidad);//para hacer la comprobacion se hace con setters
		this.setProducto(producto);
	}

	public Producto_Pojo getProducto() {
		return producto;
	}

	public void setProducto(Producto_Pojo producto) {
				
		if(producto!=null) {
			this.producto = producto;			
		} 
		else {
			throw new IllegalArgumentException("El producto no es correcto");
		}
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		if(cantidad<=0) {
			throw new IllegalArgumentException("La cantidad tiene que ser positiva.");
		}
		else {
			this.cantidad = cantidad;			
		}
	}	
}
