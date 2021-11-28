package ec.edu.ups.pw.dao;

import ec.edu.ups.pw.model.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CategoriaDAO {
  @PersistenceContext
  private EntityManager em;
  
  public void insert(Categoria categoria) {
    this.em.persist(categoria);
  }
  
  public void update(Categoria categoria) {
    this.em.merge(categoria);
  }
  
  public Categoria findCodigo(int id_categoria) {
    Categoria categoria = (Categoria)this.em.find(Categoria.class, Integer.valueOf(id_categoria));
    return categoria;
  }
  
  public Categoria findNombre(String nombre) {
    Categoria categoria = (Categoria)this.em.find(Categoria.class, nombre);
    return categoria;
  }
  
  public void delete(String nombre) {
    Categoria categoria = (Categoria)this.em.find(Categoria.class, nombre);
    this.em.remove(categoria);
  }
  
  public List<Categoria> getCategorias(String nombre) {
    String jpq2 = "SELECT f FROM Categoria f ";
    TypedQuery typedQuery = this.em.createQuery(jpq2, Categoria.class);
    List<Categoria> categorias = typedQuery.getResultList();
    return categorias;
  }
}
