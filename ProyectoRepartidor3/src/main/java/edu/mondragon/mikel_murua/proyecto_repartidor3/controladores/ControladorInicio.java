package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente.Cliente_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.cliente.Cliente_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.Roles;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;


@Controller
public class ControladorInicio {

	 private final Cliente_Repository puntoRepartoRepository;
	 private final UserAccount_Repository userAccountRepository;
	 private final Poblacion_Repository poblacionRepository;
	 private final PasswordEncoder passwordEncoder;
	
	 
	public ControladorInicio(Cliente_Repository puntoRepartoRepository,
			UserAccount_Repository userAccountRepository, Poblacion_Repository poblacionRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.puntoRepartoRepository = puntoRepartoRepository;
		this.userAccountRepository = userAccountRepository;
		this.poblacionRepository = poblacionRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@GetMapping("/register") 
	public String registrar(Model model, String error, String logout) {
        
		model.addAttribute("cliente",new Cliente_Pojo());
		
		System.out.println("Prueba para ver si pasa");
		return "v_aaEntrada_login_register/registroGeneral";
	}

	
	@GetMapping("/register2") 
	public String registrarCliente(Model model, String error, String logout) {
        
		model.addAttribute("cliente",new Cliente_Pojo());
		
		List<Poblacion_Pojo> poblaciones=this.poblacionRepository.findAll();
		
		model.addAttribute("listaPoblaciones", poblaciones);
		
		System.out.println("Prueba para ver si pasa");
		return "v_aaEntrada_login_register/registroClientes";
	}
	
    

	@PostMapping("/register/procesar")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
	        
    	
    	UserAccount_Pojo userAccount = new UserAccount_Pojo();
        userAccount.setUsername(username);
        userAccount.setContrasena(passwordEncoder.encode(password));
        userAccount.setEstaActivo(true);
        
        ArrayList<GrantedAuthority> listaRoles= new ArrayList<>();
        listaRoles.add(new SimpleGrantedAuthority(Roles.ROLE_ADMIN.name()));
        
        
        userAccount.setListaRoles(listaRoles);
        
        userAccountRepository.save(userAccount);
        
        return "redirect:/";
    }
	
	
	

	
	
	@PostMapping("/register2/procesar")
	public String register2(@ModelAttribute("cliente") Cliente_Pojo cliente,
	@RequestParam("username") String username, @RequestParam("password") String password,
	@RequestParam("poblacion_formulario") String poblacion_elegida ) {
	        
	
		
        return "redirect:/";
    }
	
	
	private UserAccount_Pojo formulary_credentials_processing(String username, String password,String role) {
		UserAccount_Pojo userAccount = new UserAccount_Pojo();
        userAccount.setUsername(username);
        userAccount.setContrasena(passwordEncoder.encode(password));
        userAccount.setEstaActivo(true);
        
        ArrayList<GrantedAuthority> listaRoles= new ArrayList<>();
        listaRoles.add(new SimpleGrantedAuthority(role));
        
        userAccount.setListaRoles(listaRoles);
        
        userAccountRepository.save(userAccount);
        
        return userAccount;
	}

	/*
	private void formulary_client_processing(Poblacion_Pojo poblacion_elegida, UserAccount_Pojo userAccount,
			Cliente_Pojo cliente, Coordenadas coordenadasCliente) {

		Cliente_Pojo a_registrar=cliente;
		
		a_registrar.setPoblacion(poblacion_elegida);
		a_registrar.setUser(userAccount);
        a_registrar.setDni(a_registrar.getDni().toUpperCase());
        a_registrar.setCoordenadasLatitud(coordenadasCliente.getCoordenadasLatitud());
        a_registrar.setCoordenadasLongitud(coordenadasCliente.getCoordenadasLongitud());
		
		this.puntoRepartoRepository.save(a_registrar);
	}

*/

	
	
	
	/*
	 * Cosas Importantes:
	   2. MODEL tiene que pasarse OBLIGATORIAMENTE
	 
	  	3. Los programas se activan solo cuando se accede al URL que tiene cada funcion.  localhost:8080/  -> activa el primero {/}
	  		-> por eso el cambio de ventanas se hace por html cambiando a la pagina correspondendiente, al hacer el cambio
	  			se activa la funcion del controlador que hace refencia a ese URL  . 	 
	 */

	
	
	/*
	    con SPRING SECURITY,  si hacemos llamada a cualquier URL de nuestra pagina web. Interceptara la llamada
	    
	    y cargara la ventana de login ( esto esta definido en Seguridad-> SecurityConfiguration  ) y despues de registrarse
	    
	    nos cargara la pagina web que habiamos llamado al inicio.
	    
	    -> ejemplo:  llama a          localhost8080/          -> primero carga el login y cuando entremos entrara a ventana inicio.
	  
	 */
	
	
	@GetMapping("/login") 
	public String paginaLogin(Model model, String error, String logout, String action) {
        
		
		model.addAttribute("error", error);
       
   
		// se pasa siempre el modelo a la pagina web que cargamos

		model.addAttribute("nombreEnControlador", "soy un atributo especificado en el controlador");
		// para usar el interface de REPARTIDORPERSISTENCIA X USAMOS EL SERVICE
		//model.addAttribute("Numero_de_objetos_database", this.repartidores.numero_de_elementos_en_database());

		
		// especificamos que pagina va ha cargar a continuacion (no hace falta poner
		// extension (.html)
		// te lo toma directamente. Y le pasamos el modelo (que se usara como atributo)
		
		
		
		return "v_aaEntrada_login_register/login";
	}

	
    @PostMapping("/logout")
    public String mostrarLaPaginaDeCierre(Model model) {
        return "logout";
    }
    
    
    
    
    
    
    // La redireccion a las ventanas correspondientes, dependiendo de los roles se hace aqui.
    
    @GetMapping({"/"})
    public String redirigirALaPaginaDeInicioCorrespondiente() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	/*
    	 Explicacion principal:
    	 	+ Funciones
    	 	-> https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
    	  
    	  
    	  	el OBJECT PRINCIPAL -> toma el usuario de MyusersDetailService es objeto User, ya que no te coge la autoridad si no lo es
    	  	-> si usamos Credentials todos los datos los recibimos en OBJECT y no podemos utilizar ni los datos ni las funicones de SecurityContextHolder
    	  
    	 */
    	
    	//La diferenciacion de usuarios por rol, se hace en SecurityConfiguration.
    	
    	
    	String charged_page="";
    	GrantedAuthority admin=new SimpleGrantedAuthority(Roles.ROLE_ADMIN.name().toString());
    	GrantedAuthority trabajador=new SimpleGrantedAuthority(Roles.ROLE_TRABAJADOR.name().toString());
    	GrantedAuthority cliente=new SimpleGrantedAuthority(Roles.ROLE_CLIENTE.name().toString());
    	
	    	
    	if(roles.contains(admin)) {
    		 charged_page= "redirect:/admin/entrada";
    	}
    	else if(roles.contains(trabajador)) {
    		 charged_page= "redirect:/repartidor/entrada";
    	}
    	else if(roles.contains(cliente)) {
    		charged_page= "redirect:/cliente/entrada";
    	}
		
    	return charged_page;
    	
    }
    
    
   
}
