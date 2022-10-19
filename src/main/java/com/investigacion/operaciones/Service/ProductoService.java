package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Producto;
import com.investigacion.operaciones.Repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService{


    @Autowired
    private ProductoRepository productoRepository;

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> listarActivos(){
        return productoRepository.listarActivos();
    }

    public void eliminar(int id_producto){
        productoRepository.elimminar(id_producto);
    }

    public Producto buscarPorId(int id_producto){
        return productoRepository.productoActivoPorId(id_producto);
    }

}
