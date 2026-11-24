package com.example.Tienda.service;

import com.example.Tienda.model.Producto;
import com.example.Tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service 
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> consultarProductos(){
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto){
        producto.setId(null);
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto producto){
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        productoRepository.delete(producto);
    }

}
