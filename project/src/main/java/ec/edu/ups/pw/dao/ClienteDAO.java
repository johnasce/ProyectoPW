package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ClienteDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Cliente cliente) {
    this.em.persist(cliente);
  }
  
  public void update(Cliente cliente) {
    this.em.merge(cliente);
  }
  
  public Cliente read(String cedula) {
    Cliente cliente = (Cliente)this.em.find(Cliente.class, cedula);
    return cliente;
  }
  
  public void delete(String cedula) {
    Cliente cliente = (Cliente)this.em.find(Cliente.class, cedula);
    this.em.remove(cliente);
  }
  
  public List<Cliente> getClientes(String nombre) {
    String jpq2 = "SELECT c FROM Cliente c WHERE nombre LIKE ?1 ";
    nombre = String.valueOf(nombre) + "%";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Cliente.class);
    typedQuery.setParameter(1, nombre);
    List<Cliente> clientes = typedQuery.getResultList();
    return clientes;
  }
}
