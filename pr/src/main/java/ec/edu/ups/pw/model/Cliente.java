package ec.edu.ups.pw.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
  @Id
  @GeneratedValue
  private int id_cliente;
  
  private String nombres;
  
  private String cedula;
  
  private String direccion;
  
  private String telefono;
  
  private String correo;
  
  @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
  private List<FacturaCabecera> facturas_cabeceras = new ArrayList<>();
  
  public int getId_cliente() {
    return this.id_cliente;
  }
  
  public void setId_cliente(int id_cliente) {
    this.id_cliente = id_cliente;
  }
  
  public String getNombres() {
    return this.nombres;
  }
  
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  
  public String getCedula() {
    return this.cedula;
  }
  
  public void setCedula(String cedula) {
    this.cedula = cedula;
  }
  
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getCorreo() {
    return this.correo;
  }
  
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  public List<FacturaCabecera> getFacturas_cabeceras() {
    return this.facturas_cabeceras;
  }
  
  public void setFacturas_cabeceras(List<FacturaCabecera> facturas_cabeceras) {
    this.facturas_cabeceras = facturas_cabeceras;
  }
}
