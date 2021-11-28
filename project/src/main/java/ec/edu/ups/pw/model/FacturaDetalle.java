package ec.edu.ups.pw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FacturaDetalle {
  @Id
  @GeneratedValue
  private int id_factura_cabecera;
  
  private int cantidad;
  
  private float total;
  
  @ManyToOne
  private Producto producto;
  
  public int getId_factura_cabecera() {
    return this.id_factura_cabecera;
  }
  
  public void setId_factura_cabecera(int id_factura_cabecera) {
    this.id_factura_cabecera = id_factura_cabecera;
  }
  
  public int getCantidad() {
    return this.cantidad;
  }
  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
  public float getTotal() {
    return this.total;
  }
  
  public void setTotal(float total) {
    this.total = total;
  }
  
  public Producto getProducto() {
    return this.producto;
  }
  
  public void setProducto(Producto producto) {
    this.producto = producto;
  }
}
