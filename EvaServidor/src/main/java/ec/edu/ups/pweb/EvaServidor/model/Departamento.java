package ec.edu.ups.pweb.EvaServidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_Departamento")
public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
		@Id
		@Column(name="dep_codigo")
		private int codigo;
		
		@Column(name="dep_precio")
		private double precio;
		
		@Column(name="dep_telefono")
		private String telefono;
		
		@Column(name="dep_direccion")
		private String direccion;

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public static void setSerialversionuid(long serialversionuid) {
			serialVersionUID = serialversionuid;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

	
}
