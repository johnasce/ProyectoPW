package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.FacturaCabecera;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class FacturaCabeceraDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(FacturaCabecera facturaCabecera) {
    this.em.persist(facturaCabecera);
  }
  
  public void update(FacturaCabecera facturaCabecera) {
    this.em.merge(facturaCabecera);
  }
  
  public FacturaCabecera read(int id) {
    FacturaCabecera facturaCabecera = (FacturaCabecera)this.em.find(FacturaCabecera.class, Integer.valueOf(id));
    return facturaCabecera;
  }
  
  public void delete(int id) {
    FacturaCabecera facturaCabecera = (FacturaCabecera)this.em.find(FacturaCabecera.class, Integer.valueOf(id));
    this.em.remove(facturaCabecera);
  }
  
  public List<FacturaCabecera> getFacturas(String nombre) {
    String jpq2 = "SELECT f FROM FacturaCabecera f ";
    TypedQuery typedQuery = this.em.createQuery(jpq2, FacturaCabecera.class);
    List<FacturaCabecera> facturasCabeceras = typedQuery.getResultList();
    return facturasCabeceras;
  }
}
