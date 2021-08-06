package ec.edu.ups.pw.view;

import ec.edu.ups.pw.business.CategoriaON;
import ec.edu.ups.pw.business.ProductoON;
import ec.edu.ups.pw.model.Categoria;
import ec.edu.ups.pw.model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductoBean implements Serializable {
  private Producto newProducto = new Producto();
  
  @Inject
  private ProductoON productoON;
  
  @Inject
  private CategoriaON categoriaON;
  
  private List<Producto> productos;
  
  private List<Producto> carrito;
  
  private Categoria categoria;
  
  private double totalCarrito;
  
  private double tot;
  
  @PostConstruct
  public void init() {
    this.productos = this.productoON.getProductos();
    this.categoria = new Categoria();
    this.newProducto.setCategoria(this.categoria);
  }
  
  public void guardarProductoCategoria() throws Exception {
    this.categoriaON.guardarCategoria(this.categoria);
    this.productoON.registrarProducto(this.newProducto);
    this.productos = this.productoON.getProductos();
  }
  
  public void buscarCategoria(String nomCategoria) {
    this.categoriaON.bucarCategoria(nomCategoria);
  }
  
  public void actionListenerAgregarProducto(Producto p) {
    this.carrito = this.productoON.agregarProductoCarrito(this.carrito, p);
    this.totalCarrito = this.productoON.calcularTotalCarrito(this.carrito);
    this.tot = productoON.calcularTotal(carrito);
  }
  
  public void actionListenerEliminarProducto(Producto p) {
    this.carrito = this.productoON.eliminarPoductoCarrito(this.carrito, p.getId_producto());
    this.totalCarrito = this.productoON.calcularTotalCarrito(this.carrito);
    this.tot = productoON.calcularTotal(carrito);
  }
  
  public Producto getNewProducto() {
    return this.newProducto;
  }
  
  public void setNewProducto(Producto newProducto) {
    this.newProducto = newProducto;
  }
  
  public List<Producto> getProductos() {
    return this.productos;
  }
  
  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }
  
  public List<Producto> getCarrito() {
    return this.carrito;
  }
  
  public void setCarrito(List<Producto> carrito) {
    this.carrito = carrito;
  }
  
  public double getTotalCarrito() {
    return this.totalCarrito;
  }
  
  public void setTotalCarrito(double totalCarrito) {
    this.totalCarrito = totalCarrito;
  }
  
  public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}
}
