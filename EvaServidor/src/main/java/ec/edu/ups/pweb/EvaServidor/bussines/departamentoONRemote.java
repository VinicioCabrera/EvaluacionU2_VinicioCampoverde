package ec.edu.ups.pweb.EvaServidor.bussines;

import javax.ejb.Remote;

import ec.edu.ups.pweb.EvaServidor.model.Departamento;

@Remote
public interface departamentoONRemote {

	public void insert(Departamento p) throws Exception;
	public void update(Departamento d);
	public Departamento read (int id);
}
