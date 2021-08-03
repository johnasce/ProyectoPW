package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Persona;
import ec.edu.ups.pw.model.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProveedorDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Proveedor proveedor) {
    this.em.persist(proveedor);
  }
  
  public void update(Proveedor proveedor) {
    this.em.merge(proveedor);
  }
  
  public Proveedor read(String nombres) {
    Proveedor proveedor = (Proveedor)this.em.find(Proveedor.class, nombres);
    return proveedor;
  }
  
  public void delete(String nombres) {
    Proveedor proveedor = (Proveedor)this.em.find(Proveedor.class, nombres);
    this.em.remove(proveedor);
  }
  
  public List<Proveedor> getPersonas(String nombres) {
    String jpq2 = "SELECT c FROM Persona c WHERE nombre LIKE ?1 ";
    nombres = String.valueOf(nombres) + "%";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Persona.class);
    typedQuery.setParameter(1, nombres);
    List<Proveedor> proveedores = typedQuery.getResultList();
    return proveedores;
  }
}
