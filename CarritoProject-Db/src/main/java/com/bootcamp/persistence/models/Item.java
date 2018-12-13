package com.bootcamp.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_item", unique = true)
    private int id; //solo se utiliza para las tablas

    @OneToOne
    @JoinColumn(name ="id_producto")
    private Producto producto;

    @Column(name= "unidades")
    private int unidades;

    public Item(Producto producto, int unidades){
        this.producto= producto;
        this.unidades= unidades;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setProducto(Producto producto){
        this.producto= producto;
    }

    public int getUnidades(){
        return unidades;
    }

    public void setUnidades(int unidades){
        this.unidades= unidades;
    }
}