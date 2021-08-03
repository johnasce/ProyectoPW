package ec.edu.ups.pw.business;

import ec.edu.ups.pw.dao.PersonaDAO;
import ec.edu.ups.pw.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaON {
  @Inject
  private PersonaDAO daoPersona;
  
  public void registrarUsuario(Persona persona) throws Exception {
    this.daoPersona.insert(persona);
  }
  
  public List<Persona> getPersonas() {
    return this.daoPersona.getPersonas("%");
  }
  
  public List<Persona> agregarPersonasTable(List<Persona> tablePersona, Persona persona) {
    if (tablePersona == null)
      tablePersona = new ArrayList<>(); 
    tablePersona.add(persona);
    return tablePersona;
  }
  
  public Persona readUsuario(String usuario) throws Exception {
    Persona per = this.daoPersona.read(usuario);
    return per;
  }
}
