package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PersonaDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Persona persona) {
    this.em.persist(persona);
  }
  
  public void update(Persona persona) {
    this.em.merge(persona);
  }
  
  public Persona read(String usuario) {
    Persona persona = (Persona)this.em.find(Persona.class, usuario);
    return persona;
  }
  
  public void delete(String usuario) {
    Persona persona = (Persona)this.em.find(Persona.class, usuario);
    this.em.remove(persona);
  }
  
  public List<Persona> getPersonas(String usuario) {
    String jpq2 = "SELECT p FROM Persona p ";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Persona.class);
    List<Persona> usuarios = typedQuery.getResultList();
    return usuarios;
  }
}
