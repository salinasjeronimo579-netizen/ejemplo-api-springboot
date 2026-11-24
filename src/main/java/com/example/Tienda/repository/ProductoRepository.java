package com.example.Tienda.repository;
import com.example.Tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

    
} 
