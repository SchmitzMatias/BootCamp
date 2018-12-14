package com.bootcamp.persistence.dao;

import com.bootcamp.persistence.models.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long>{

}