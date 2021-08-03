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
public class Proveedor {
  @Id
  @GeneratedValue
  private int id_proveedor;
  
  private String nombres;
  
  private String telefono;
  
  private String direccion;
  
  @OneToMany(mappedBy = "proveedor", cascade = {CascadeType.ALL})
  private List<Producto> productos = new ArrayList<>();
  
  @ManyToOne
  @JoinColumn(name = "id_compra")
  private Proveedor proveedor;
  
  public int getId_proveedor() {
    return this.id_proveedor;
  }
  
  public void setId_proveedor(int id_proveedor) {
    this.id_proveedor = id_proveedor;
  }
  
  public String getNombres() {
    return this.nombres;
  }
  
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  
  public String getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public List<Producto> getProductos() {
    return this.productos;
  }
  
  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }
  
  public Proveedor getProveedor() {
    return this.proveedor;
  }
  
  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }
}
