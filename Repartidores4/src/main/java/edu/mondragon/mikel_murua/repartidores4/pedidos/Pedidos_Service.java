package edu.mondragon.mikel_murua.repartidores4.pedidos;

public class Pedidos_Service {
	
	public Pedidos_Service() {
	
	}
	
	public double calcularTotalLinea(Linea_Pojo linea) {
		double totalLinea=Math.abs(linea.getCantidad()*linea.getProducto().getPrecio());
		
		totalLinea = Math.abs(totalLinea - ((totalLinea * linea.getProducto().getDescuento())/100));
		
		return totalLinea;
	}

	public double calcularTotalPedido(Pedido_Pojo pedido) {
		double result=0.0;
		
		for(Linea_Pojo actual : pedido.lista_Lineas) {
			result = result+this.calcularTotalLinea(actual);
		}
		
		return result;
	}

}
