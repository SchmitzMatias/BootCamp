package carritoPackage.models;

import java.util.HashMap;

public class Producto {
	private String nombre;
	private Long id;
	private Double costo;
	//private HashMap<String, Object> cualidades; //nombre , valor
	
	/*public Producto(Long id, String nombre){ TODO comprobar que no sea necesario antes de borrar
		this.nombre= nombre;
		this.id= id;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	/*public HashMap<String, Object> getCualidades() {
		return cualidades;
	}

	public void setCualidades(HashMap<String, Object> cualidades) {
		this.cualidades = cualidades;
	}
	
	public void addCualidad(String nombre, Object valor) {
		if(!cualidades.containsKey(nombre))
			cualidades.put(nombre, valor);
		else
			cualidades.replace(nombre, valor);
	}
	
	public void removeCualidad(String nombre, Object valor) {
		if(cualidades.containsKey(nombre))
			cualidades.remove(nombre);
	}*/
}
