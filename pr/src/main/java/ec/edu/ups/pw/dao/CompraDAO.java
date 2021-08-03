package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Compra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CompraDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Compra compra) {
    this.em.persist(compra);
  }
  
  public void update(Compra compra) {
    this.em.merge(compra);
  }
  
  public Compra read(int id) {
    Compra compra = (Compra)this.em.find(Compra.class, Integer.valueOf(id));
    return compra;
  }
  
  public void delete(int id) {
    Compra compra = (Compra)this.em.find(Compra.class, Integer.valueOf(id));
    this.em.remove(compra);
  }
  
  public List<Compra> getFacturas(String nombre) {
    String jpq2 = "SELECT f FROM FacturaCabecera f ";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Compra.class);
    List<Compra> compras = typedQuery.getResultList();
    return compras;
  }
}
