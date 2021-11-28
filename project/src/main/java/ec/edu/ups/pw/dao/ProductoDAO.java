package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProductoDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Producto producto) {
    this.em.persist(producto);
  }
  
  public void update(Producto producto) {
    this.em.merge(producto);
  }
  
  public Producto findCodigo(int id_producto) {
    Producto producto = (Producto)this.em.find(Producto.class, Integer.valueOf(id_producto));
    return producto;
  }
  
  public Producto findNombre(String nombre) {
    Producto producto = (Producto)this.em.find(Producto.class, nombre);
    return producto;
  }
  
  public void delete(String nombre) {
    Producto producto = (Producto)this.em.find(Producto.class, nombre);
    this.em.remove(producto);
  }
  
  public List<Producto> getProductos(String nombre) {
    String jpq2 = "SELECT p FROM Producto p ";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Producto.class);
    List<Producto> productos = typedQuery.getResultList();
    return productos;
  }
}
