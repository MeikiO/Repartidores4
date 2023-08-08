package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;



@Entity
@Table(name="puntoReparto")
public class Cliente_Pojo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "puntoReparto_id")
    private Long id;
	

	private String nombre_cliente;
	private String apellidos_cliente;
	private String tlf1_cliente;
	private String tlf2_cliente;
	private String tlf3_cliente;
	
	
	
	@Column(nullable = false, unique = true)
    private String direccion;
	
	@Column(nullable = false, unique = true)
    private String dni;
	
	private String color_puntero;
	
	
	
	// se pone aqui para ahorrarse conexiones de database
	// que puedan traer errores futuros
	private double coordenadasLatitud;
	private double coordenadasLongitud;
	
	
 
////////////////////////////////////////
/*

 https://www.adictosaltrabajo.com/2020/04/02/hibernate-onetoone-onetomany-manytoone-y-manytomany/  
 
 */    
    @OneToOne
    @JoinColumn(name = "poblacion_id") 
    private Poblacion_Pojo poblacion;
    
    //para el siguiente paso cuando separemos cliente de punto de entrega
    //private Long id_cliente;
    
   
    @OneToOne
    @JoinColumn(name = "credenciales_id") 
    private UserAccount_Pojo user;
    
    
    @OneToMany(mappedBy = "puntoReparto",
            fetch = FetchType.LAZY)
	//@org.hibernate.annotations.ForeignKey(name = "none")
	//desabilitamos la comprobacion del foreign key de pedidos por que sino nos dara error
	// link-> https://stackoverflow.com/questions/41729709/how-do-i-disable-hibernate-foreign-key-constraint-on-a-bidirectional-association
	private Set<Pedido_Pojo> lista_pedidos;
    

	
//////////////////////////////////////////////////    
    

    public Cliente_Pojo() {
    	this.lista_pedidos=new HashSet<>();
	}



public Cliente_Pojo(Long id, String nombre_cliente, String apellidos_cliente, String tlf1_cliente,
		String tlf2_cliente, String tlf3_cliente, String direccion, String dni, String color_puntero,
		double coordenadasLatitud, double coordenadasLongitud, Poblacion_Pojo poblacion, UserAccount_Pojo user,
		Set<Pedido_Pojo> lista_pedidos) {
	super();
	this.id = id;
	this.nombre_cliente = nombre_cliente;
	this.apellidos_cliente = apellidos_cliente;
	this.tlf1_cliente = tlf1_cliente;
	this.tlf2_cliente = tlf2_cliente;
	this.tlf3_cliente = tlf3_cliente;
	this.direccion = direccion;
	this.dni = dni;
	this.color_puntero = color_puntero;
	this.coordenadasLatitud = coordenadasLatitud;
	this.coordenadasLongitud = coordenadasLongitud;
	this.poblacion = poblacion;
	this.user = user;
	this.lista_pedidos = lista_pedidos;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getNombre_cliente() {
	return nombre_cliente;
}



public void setNombre_cliente(String nombre_cliente) {
	this.nombre_cliente = nombre_cliente;
}



public String getApellidos_cliente() {
	return apellidos_cliente;
}



public void setApellidos_cliente(String apellidos_cliente) {
	this.apellidos_cliente = apellidos_cliente;
}



public String getTlf1_cliente() {
	return tlf1_cliente;
}



public void setTlf1_cliente(String tlf1_cliente) {
	this.tlf1_cliente = tlf1_cliente;
}



public String getTlf2_cliente() {
	return tlf2_cliente;
}



public void setTlf2_cliente(String tlf2_cliente) {
	this.tlf2_cliente = tlf2_cliente;
}



public String getTlf3_cliente() {
	return tlf3_cliente;
}



public void setTlf3_cliente(String tlf3_cliente) {
	this.tlf3_cliente = tlf3_cliente;
}



public String getDireccion() {
	return direccion;
}



public void setDireccion(String direccion) {
	this.direccion = direccion;
}



public String getDni() {
	return dni;
}



public void setDni(String dni) {
	this.dni = dni;
}



public String getColor_puntero() {
	return color_puntero;
}



public void setColor_puntero(String color_puntero) {
	this.color_puntero = color_puntero;
}



public double getCoordenadasLatitud() {
	return coordenadasLatitud;
}



public void setCoordenadasLatitud(double coordenadasLatitud) {
	this.coordenadasLatitud = coordenadasLatitud;
}



public double getCoordenadasLongitud() {
	return coordenadasLongitud;
}



public void setCoordenadasLongitud(double coordenadasLongitud) {
	this.coordenadasLongitud = coordenadasLongitud;
}



public Poblacion_Pojo getPoblacion() {
	return poblacion;
}



public void setPoblacion(Poblacion_Pojo poblacion) {
	this.poblacion = poblacion;
}



public UserAccount_Pojo getUser() {
	return user;
}



public void setUser(UserAccount_Pojo user) {
	this.user = user;
}



public Set<Pedido_Pojo> getLista_pedidos() {
	return lista_pedidos;
}



public void setLista_pedidos(Set<Pedido_Pojo> lista_pedidos) {
	this.lista_pedidos = lista_pedidos;
}


	

	
}
