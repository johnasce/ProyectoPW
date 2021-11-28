package ec.edu.ups.pw.model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Stateless
public class Compra {
  @Id
  @GeneratedValue
  private int id_compra;
  
  private String fecha;
  
  @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
  private List<Proveedor> proveedores = new ArrayList<>();
  
  public int getId_compra() {
    return this.id_compra;
  }
  
  public void setId_compra(int id_compra) {
    this.id_compra = id_compra;
  }
  
  public String getFecha() {
    return this.fecha;
  }
  
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  
  public List<Proveedor> getProveedores() {
    return this.proveedores;
  }
  
  public void setProveedores(List<Proveedor> proveedores) {
    this.proveedores = proveedores;
  }
}
