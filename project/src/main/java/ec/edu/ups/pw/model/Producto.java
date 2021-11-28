package ec.edu.ups.pw.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto {
  @Id
  @GeneratedValue
  private int id_producto;
  
  private String nombre;
  
  private float precio;
  
  private int stock;
  
  private float precio_compra;
  
  @ManyToOne
  @JoinColumn
  private Categoria categoria;
  
  @OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL})
  private List<FacturaDetalle> facturas_detalles = new ArrayList<>();
  
  @ManyToOne
  @JoinColumn(name = "id_proveedor")
  private Proveedor proveedor;
  
  public int getId_producto() {
    return this.id_producto;
  }
  
  public void setId_producto(int id_producto) {
    this.id_producto = id_producto;
  }
  
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public float getPrecio() {
    return this.precio;
  }
  
  public void setPrecio(float precio) {
    this.precio = precio;
  }
  
  public int getStock() {
    return this.stock;
  }
  
  public void setStock(int stock) {
    this.stock = stock;
  }
  
  public float getPrecio_compra() {
    return this.precio_compra;
  }
  
  public void setPrecio_compra(float precio_compra) {
    this.precio_compra = precio_compra;
  }
  
  public List<FacturaDetalle> getFacturas_detalles() {
    return this.facturas_detalles;
  }
  
  public void setFacturas_detalles(List<FacturaDetalle> facturas_detalles) {
    this.facturas_detalles = facturas_detalles;
  }
  
  public Categoria getCategoria() {
    return this.categoria;
  }
  
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
  
  public Proveedor getProveedor() {
    return this.proveedor;
  }
  
  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }
}
