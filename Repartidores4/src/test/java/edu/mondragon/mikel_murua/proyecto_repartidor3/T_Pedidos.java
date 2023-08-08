package edu.mondragon.mikel_murua.proyecto_repartidor3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.mondragon.mikel_murua.repartidores4.pedidos.Linea_Pojo;
import edu.mondragon.mikel_murua.repartidores4.pedidos.Pedido_Pojo;



class T_Pedidos {

	@Test
	void seObtienePrecioTotal() {
		Pedido_Pojo nuevoPedido=new Pedido_Pojo();
		nuevoPedido.setPrecio_total(25);
		assertEquals(nuevoPedido.getPrecio_total(),25);
		
		//	 	1. Minimo absoluto para calcular Correctamente el precio total
 		//			- Tener precioTotal
		
	}

	
	@Test
	void pedidoTieneComoMinimo1Linea() {
		Pedido_Pojo nuevoPedido=new Pedido_Pojo();
		Linea_Pojo linea=new Linea_Pojo(); // solo hace falta la linea, los datos no hace falta para el test
		nuevoPedido.addLinea(linea);
		
		int numeroLineas=nuevoPedido.getNumeroLineas();
		
		assertTrue(nuevoPedido.getNumeroLineas()>0);
	}
	
	
	//Nota: El test se hace y se corre antes de hacer los cambios
	//			TIENES QUE VER COMO FALLA POR NO TENER CODIGO
	
	
	@Test
	void sePuedeAnadirUnaLineaMasAlPedido() {
		Pedido_Pojo nuevoPedido=new Pedido_Pojo();
		Linea_Pojo linea=new Linea_Pojo(); 
		
		int numeroLineas=nuevoPedido.getNumeroLineas();
		
		nuevoPedido.addLinea(linea);
			
		assertTrue(numeroLineas+1 == nuevoPedido.getNumeroLineas());
	}
	
	
	/*
	 
	@Test
	void todasLasLineasTienenQueTenerCantidadYProducto() {
		Producto_Pojo producto=new Producto_Pojo();
		Linea_Pojo linea=new Linea_Pojo(); // solo hace falta la linea, los datos no hace falta para el test
		
		//hay que comprobar todos los posibles fallos
		assertNotNull(linea.getProducto());
		assertNotNull(linea.getCantidad());
	}
	  
	-> Para esta comprobacion es mas facil y efectivo quitar el test, y asegurarse de que no sea posible
	  que llegue a ese estado
	  
	-> ASIGNACION A TRAVES DEL SETTER (CONTROLANDO LAS CONDICIONES).
	  
	  -> FALTA HACERLO
	  
	 */
	

	
	
	
	
}