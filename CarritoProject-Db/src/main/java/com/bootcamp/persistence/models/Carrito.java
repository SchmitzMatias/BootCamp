package com.bootcamp.persistence.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_carrito", unique = true)
	private Long idCarrito;

	@Column(name = "usuario")
	private String user;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> items;
	
	public Carrito() {
		items= new ArrayList<>(); 
	}

	public Carrito(List<Item> items){
		this.items=items;
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public String getUser(){
		return user;
	}

	public void setUser(String user){
		this.user= user;
	}

	public List<Item> getitems() {
		return items;
	}

	public void setitems(List<Item> items) {
		this.items = items;
	}

	public void addProducto(Producto p) { //si no está, agrega un nuevo item, si está, incrementa en 1 las unidades del mismo
		boolean auxContiene=false;
		int auxPosicion=-1; //disernible
		for(int i=0; i<items.size() && auxContiene!=true;i++){
			if(items.get(i).getProducto().getId()==p.getId()){
				auxContiene=true;
				auxPosicion= i;
			}
		}
		if(auxContiene==false){
			items.add(new Item(p,1));
		}
		else{
			items.get(auxPosicion).setUnidades(items.get(auxPosicion).getUnidades()+1);
		}
	}
	
	public void removeProducto(Producto p) {
		boolean find = false;
		for(int i =0 ; i< items.size() && !find ;i++){
			if(items.get(i).getProducto().getId() == p.getId()){
				if(items.get(i).getUnidades()>1)
					items.get(i).setUnidades(items.get(i).getUnidades()-1);
				if(items.get(i).getUnidades()==1)
					items.remove(i);
				find = true;
			}
		}
	}
	
	public String listaritems() {
		return items.toString();
	}
}
