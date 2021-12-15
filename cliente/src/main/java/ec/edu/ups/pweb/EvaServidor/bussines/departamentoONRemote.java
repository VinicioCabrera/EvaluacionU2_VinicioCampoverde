package ec.edu.ups.pweb.EvaServidor.bussines;


import ec.edu.ups.pweb.EvaServidor.model.Departamento;


public interface departamentoONRemote {

	public void insert(Departamento p) throws Exception;
	public void update(Departamento d);
	public Departamento read (int id);
}
