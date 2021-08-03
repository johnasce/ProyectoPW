package ec.edu.ups.pw.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable {
  @GeneratedValue
  private int id_persona;
  
  private String nombres;
  
  private String cedula;
  
  @Id
  private String usuario;
  
  private String password;
  
  private String rol;
  
  public int getId_persona() {
    return this.id_persona;
  }
  
  public void setId_persona(int id_persona) {
    this.id_persona = id_persona;
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
  
  public String getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getRol() {
    return this.rol;
  }
  
  public void setRol(String rol) {
    this.rol = rol;
  }
}
