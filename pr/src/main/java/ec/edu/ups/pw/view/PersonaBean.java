package ec.edu.ups.pw.view;

import ec.edu.ups.pw.business.PersonaON;
import ec.edu.ups.pw.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PersonaBean implements Serializable {
  private Persona newPersona = new Persona();
  
  @Inject
  private PersonaON personaON;
  
  private List<Persona> personas;
  
  private List<Persona> tablePersonas;
  
  private Persona user;
  
  @PostConstruct
  public void init() {
    this.newPersona = new Persona();
    this.personas = this.personaON.getPersonas();
  }
  
  public String validarUsuario() throws Exception {
    this.newPersona = this.personaON.readUsuario(this.newPersona.getUsuario());
    System.out.println(this.newPersona);
    return null;
  }
  
  public void actionGuardarUsuario() throws Exception {
    this.personaON.registrarUsuario(this.newPersona);
    this.personas = this.personaON.getPersonas();
  }
  
  public Persona getNewPersona() {
    return this.newPersona;
  }
  
  public void setNewPersona(Persona newPersona) {
    this.newPersona = newPersona;
  }
  
  public List<Persona> getPersonas() {
    return this.personas;
  }
  
  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }
  
  public String doGuardarUsuario() throws Exception {
    this.personaON.registrarUsuario(this.newPersona);
    return null;
  }
  
  public List<Persona> getTablePersonas() {
    return this.tablePersonas;
  }
  
  public void setTablePersonas(List<Persona> tablePersonas) {
    this.tablePersonas = tablePersonas;
  }
  
  public Persona getUser() {
    return this.user;
  }
  
  public void setUser(Persona user) {
    this.user = user;
  }
}
