package ec.edu.ups.pw.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pw.business.PersonaON;
import ec.edu.ups.pw.model.Persona;
import ec.edu.ups.pw.services.modelo.PersonaTemp;

@Path("persona")
public class PersonaServiceRS {

	@Inject
	private PersonaON personaON;
	
	// put para insertar un registro
	@PUT
	@Path("/registrar")
	// cual es el resultado que voy a producir
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje registrarPersona(Persona persona) {
		Mensaje msj = new Mensaje();
		try {
			personaON.registrarUsuario(persona);
			msj.setCodigo("01");
			msj.setMensaje("OK");
			return msj;
		} catch (Exception e) {
			e.printStackTrace();
			msj.setCodigo("99");
			msj.setMensaje("Error PERSONA SERVICE RS");
			return msj;
		}
	}
	
	@POST
	@Path("/sumar")
	@Produces(MediaType.APPLICATION_JSON)
	public int sumar(@QueryParam("p_a") int a, @QueryParam("p_b")int b) {
		return a+b;
	}
	
	@POST
	@Path("/sumar2/{a}/{b}")
	@Produces(MediaType.APPLICATION_JSON)
	public int sumar2(@PathParam("a") int a, @PathParam("b")int b) {
		return a+b;
	}
	
	// consulta
	@GET
	@Path("usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaTemp> getPersonas(){
		// DEBERIAMOS OBJETOS TEMPORALES
		List<Persona> listado = personaON.getPersonas();
		List<PersonaTemp> clientes = new ArrayList<PersonaTemp>();
		for (Persona p : listado) {
			PersonaTemp pt = new PersonaTemp();
			pt.setCedula(p.getCedula());
			pt.setNombres(p.getNombres());
			pt.setPassword(p.getPassword());
			pt.setUsuario(p.getUsuario());
			pt.setRol(p.getRol());
			clientes.add(pt);
		}
		return clientes;
	}
}
