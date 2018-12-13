package com.bootcamp.persistence.models;

import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

import java.util.ArrayList;

//@Entity
public class Carrito {
	private Long idCarrito;
	private String user;
	private List<Item> items;
	
	public Carrito() {
		items= new ArrayList<>(); 
	}

	public Carrito(List<Item> items){ //TODO usado para el mock? revisar si se usó
		this.items=items;
	}

	//@Id
	//@GeneratedValue
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
		if(items==null)
			items= new ArrayList<Item>();
		/*if(!items.contains(p))
			items.add(new Item(p,1));*/
		boolean auxContiene=false;
		int auxPosicion=-1; //disernible
		for(int i=0; i<items.size() && auxContiene!=true;i++)
			if(items.get(i).getProducto().getId()==p.getId()){
				auxContiene=true;
				auxPosicion= i;
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
				items.remove(i);
				find = true;
			}
		}/*
		if(items!=null)
			if (items.contains(p)){
				int aux= items.indexOf(p);
				items.remove(aux);
			}*/
	}
	
	public String listaritems() {
		return items.toString();
	}
}
