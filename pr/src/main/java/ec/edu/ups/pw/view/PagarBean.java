package ec.edu.ups.pw.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw.business.PagarON;
import ec.edu.ups.pw.model.Cliente;
import ec.edu.ups.pw.model.FacturaCabecera;

@Named
@RequestScoped
public class PagarBean implements Serializable{

	private FacturaCabecera factCabecera;
	private Cliente newcliente;
	
	@Inject
	private PagarON pagarON;
	
	@PostConstruct
	public void init() {
		newcliente = new Cliente();
		factCabecera = new FacturaCabecera();
		factCabecera.setCliente(newcliente);
		
		
	}
	
	public void cargarCliente() throws Exception{
		pagarON.guardarCliente(newcliente);
		//pagarON.buscarClienteCedula(newcliente.getCedula());
	}
	
	public String doGuardarFacturaCabecera() {
		pagarON.guardarFactura(factCabecera);
		return null;
	}

	public FacturaCabecera getFactCabecera() {
		return factCabecera;
	}

	public void setFactCabecera(FacturaCabecera factCabecera) {
		this.factCabecera = factCabecera;
	}

	public Cliente getNewcliente() {
		return newcliente;
	}

	public void setNewcliente(Cliente newcliente) {
		this.newcliente = newcliente;
	}

	
	
	
}
