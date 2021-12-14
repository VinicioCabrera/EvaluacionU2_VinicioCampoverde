package ec.edu.ups.pweb.EvaServidor.bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pweb.EvaServidor.DAO.departamentoDAO;
import ec.edu.ups.pweb.EvaServidor.model.Departamento;

@Stateless
public class departamentoON implements departamentoONRemote{
	
	@Inject
	private departamentoDAO depDAO;
	
	public void insert(Departamento p) throws Exception{
		depDAO.insert(p);
	}
	
}
