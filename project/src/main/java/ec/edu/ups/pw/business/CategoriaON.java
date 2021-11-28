package ec.edu.ups.pw.business;

import ec.edu.ups.pw.dao.CategoriaDAO;
import ec.edu.ups.pw.dao.ProductoDAO;
import ec.edu.ups.pw.model.Categoria;
import ec.edu.ups.pw.model.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoriaON {
  @Inject
  private CategoriaDAO daoCategoria;
  
  @Inject
  private ProductoDAO daoProducto;
  
  private Producto producto;
  
  private List<Producto> productos;
  
  public void guardarCategoria(Categoria categoria) {
    this.daoCategoria.insert(categoria);
  }
  
  public void bucarCategoria(String nombreCategoria) {
    this.daoCategoria.findNombre(nombreCategoria);
  }
  
  public CategoriaDAO getDaoCategoria() {
    return this.daoCategoria;
  }
  
  public void setDaoCategoria(CategoriaDAO daoCategoria) {
    this.daoCategoria = daoCategoria;
  }
  
  public List<Producto> getProductos() {
    return this.productos;
  }
  
  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }
}
