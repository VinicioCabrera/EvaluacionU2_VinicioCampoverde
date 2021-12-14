package ec.edu.ups.pweb.cliente.view;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.pweb.EvaServidor.bussines.departamentoONRemote;
import ec.edu.ups.pweb.EvaServidor.model.Departamento;

public class Ventana {
	
	private departamentoONRemote depONOnRemote;
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");  
              
            final Context context = new InitialContext(jndiProperties);  
            
            //departamento 
            final String lookupName = "ejb:/EvaServidor/departamentoON!ec.edu.ups.pweb.EvaServidor.bussines.departamentoONRemote";   
            	this.depONOnRemote = (departamentoONRemote) context.lookup(lookupName);  
           
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void crearDepartamento() {
		Departamento d=new Departamento();
		d.setCodigo(1);
		d.setDireccion("monay");
		d.setPrecio(120.9);
		d.setTelefono("0992345123");
		try {
			depONOnRemote.insert(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana vt=new Ventana();
		vt.crearDepartamento();

	}

}
