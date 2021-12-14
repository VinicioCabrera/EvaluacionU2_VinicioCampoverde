package ec.edu.ups.pweb.EvaServidor.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pweb.EvaServidor.model.Departamento;


@Stateless
public class departamentoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Departamento d) throws Exception{
		em.persist(d);
	}
	public void update(Departamento d) {
		em.merge(d);	
		}
	public Departamento read (int id) {
		Departamento d=em.find(Departamento.class, id);
		return d;
		}
	
	public void actualizar() {
		
	}
	

}
