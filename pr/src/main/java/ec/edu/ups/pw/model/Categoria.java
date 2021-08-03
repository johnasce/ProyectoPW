package ec.edu.ups.pw.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
  @Id
  @GeneratedValue
  @Column(name = "id_categ")
  private int id_categoria;
  
  private String nombre;
  
  @OneToMany(mappedBy = "categoria", cascade = {CascadeType.ALL})
  private List<Producto> productos = new ArrayList<>();
  
  public int getId_categoria() {
    return this.id_categoria;
  }
  
  public void setId_categoria(int id_categoria) {
    this.id_categoria = id_categoria;
  }
  
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public List<Producto> getProductos() {
    return this.productos;
  }
  
  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }
}
