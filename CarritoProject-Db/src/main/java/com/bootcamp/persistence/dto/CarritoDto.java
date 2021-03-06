package com.bootcamp.persistence.dto;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.persistence.models.Item;

public class CarritoDto{

    public Long id;
    public String user;
    public List<Item> items= new ArrayList<>();

    public CarritoDto(){

    }

    public CarritoDto(Long id,String user,List<Item> items){
        this.id=id;
        this.user=user;
        this.items=items;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return this.id;
    }

    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    public void setitems(List<Item> items){
        this.items=items;
    }
    
    public List<Item> getItems(){
        return items;
    }

    public int getUnidadesProducto(ProductoDto producto){
        boolean aux=false;
        for(int i=0; i<items.size() && aux!=true;i++)
            if(items.get(i).getProducto().getId()==producto.getId()){
                aux=true;
                return items.get(i).getUnidades();
            }
        return 0;
    }

    public Double getTotalAPagar() {
		Double temporal=0D;
		for(Item i:items) {
			temporal+=i.getProducto().getCosto()*i.getUnidades();
		}
		return temporal;
	}
}