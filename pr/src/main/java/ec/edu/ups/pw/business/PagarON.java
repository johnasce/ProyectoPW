package ec.edu.ups.pw.business;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ec.edu.ups.pw.dao.ClienteDAO;
import ec.edu.ups.pw.dao.FacturaCabeceraDAO;
import ec.edu.ups.pw.model.Cliente;
import ec.edu.ups.pw.model.FacturaCabecera;

@Stateless
public class PagarON {

	@Inject 
	private ClienteDAO daoCliente;
	
	@Inject
	private FacturaCabeceraDAO daoFacturaCabecera;
	
	
	public void guardarFactura(FacturaCabecera facturaCabecera) {
		Cliente cli = daoCliente.read(facturaCabecera.getCliente().getCedula());
		if (cli == null) {
			daoCliente.insert(facturaCabecera.getCliente());
		}else {
			daoCliente.update(facturaCabecera.getCliente());
		}
		daoFacturaCabecera.insert(facturaCabecera);
	}
	
	public Cliente buscarClienteCedula(String cedula) {
		
		Cliente cli = daoCliente.read(cedula);
		if (cli != null) {
			daoCliente.insert(cli);
			cli = daoCliente.read(cedula);
		}else {
			daoCliente.update(cli);
			cli = daoCliente.read(cedula);
		}
		return cli;
	}
	
	public void guardarCliente(Cliente cli) {
		daoCliente.insert(cli);
	}
	
}
