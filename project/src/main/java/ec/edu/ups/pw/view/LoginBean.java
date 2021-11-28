package ec.edu.ups.pw.view;

import ec.edu.ups.pw.business.PersonaON;
import ec.edu.ups.pw.model.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginBean implements Serializable {
  @Inject
  private PersonaON personaON;
  
  private Persona usuario;
  
  @PostConstruct
  public void init() {
    this.usuario = new Persona();
  }
  
  public Persona getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(Persona usuario) {
    this.usuario = usuario;
  }
  
  public String iniciarSesion() {
    String redireccion = null;
    try {
      this.usuario = this.personaON.readUsuario(this.usuario.getUsuario());
      if (this.usuario != null) {
        if (this.usuario.getRol().equals("A")) {
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", this.usuario);
          redireccion = "admin/prin.xhtml?faces-redirect=true";
        } else if (this.usuario.getRol().equals("B")) {
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", this.usuario);
          redireccion = "bode/principal.xhtml?faces-redirect=true";
        } 
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
      } 
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
    } 
    return redireccion;
  }
  
  public void verificarSesion() {
    try {
      Persona us = (Persona)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid");
      if (us == null)
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../permisos-insuficientes.xhtml"); 
    } catch (Exception exception) {}
  }
  
  public void cerrarSesion() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }
  
  public String volverLogin() {
    return "log.xhtml?faces-redirect=true";
  }
}
