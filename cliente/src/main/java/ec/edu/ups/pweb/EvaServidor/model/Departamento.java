package ec.edu.ups.pweb.EvaServidor.model;

import java.io.Serializable;


public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
		
		private int codigo;
		
		
		private double precio;
		
	
		private String telefono;
		
		
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
