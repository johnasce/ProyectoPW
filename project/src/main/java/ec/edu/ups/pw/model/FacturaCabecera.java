package ec.edu.ups.pw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FacturaCabecera {
	
  @Id
  @GeneratedValue
  private int id_factura_cabecera;
  
  private String fecha;
  
  private float subtotal;
  
  private float total;
  
  private float iva;
  
  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;
  
  public int getId_factura_cabecera() {
    return this.id_factura_cabecera;
  }
  
  public void setId_factura_cabecera(int id_factura_cabecera) {
    this.id_factura_cabecera = id_factura_cabecera;
  }
  
  public String getFecha() {
    return this.fecha;
  }
  
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  
  public float getSubtotal() {
    return this.subtotal;
  }
  
  public void setSubtotal(float subtotal) {
    this.subtotal = subtotal;
  }
  
  public float getTotal() {
    return this.total;
  }
  
  public void setTotal(float total) {
    this.total = total;
  }
  
  public float getIva() {
    return this.iva;
  }
  
  public void setIva(float iva) {
    this.iva = iva;
  }
  
  public Cliente getCliente() {
    return this.cliente;
  }
  
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
