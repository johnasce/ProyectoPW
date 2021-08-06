package ec.edu.ups.pw.business;

import ec.edu.ups.pw.dao.ProductoDAO;
import ec.edu.ups.pw.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductoON {
  @Inject
  private ProductoDAO daoProducto;
  
  public void registrarProducto(Producto producto) throws Exception {
    this.daoProducto.insert(producto);
  }
  
  public List<Producto> getProductos() {
    return this.daoProducto.getProductos("%");
  }
  
  public List<Producto> agregarProductoCarrito(List<Producto> carrito, Producto p) {
    if (carrito == null)
      carrito = new ArrayList<>(); 
    carrito.add(p);
    return carrito;
  }
  
  public List<Producto> eliminarPoductoCarrito(List<Producto> carrito, int codProducot) {
    if (carrito == null)
      return null; 
    int i = 0;
    for (Producto p : carrito) {
      if (p.getId_producto() == codProducot) {
        carrito.remove(i);
        break;
      } 
      i++;
    } 
    return carrito;
  }
  
  public double calcularTotalCarrito(List<Producto> carrito) {
    double suma = 0.0D;
    for (Producto p : carrito)
      suma += p.getPrecio(); 
    return suma;
  }
  
  public double calcularTotal(List<Producto> carrito) {
	    double suma = 0.0D;
	    for (Producto p : carrito) {
	    	suma += p.getPrecio(); 
	    }
	      suma = suma + suma*0.12;
	    return suma;
	  }
}
