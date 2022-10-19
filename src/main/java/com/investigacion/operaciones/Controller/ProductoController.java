package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Catalogo;
import com.investigacion.operaciones.Entity.Producto;
import com.investigacion.operaciones.Service.CatalogosService;
import com.investigacion.operaciones.Service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CatalogosService catalogosService;

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> list = productoService.listarActivos();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/eliminar/{id_producto}")
    public void eliminar(@PathVariable int id_producto){
        productoService.eliminar(id_producto);
    }

    @GetMapping("/buscar/{id_producto}")
    public ResponseEntity<Producto> buscar(@PathVariable int id_producto){
        Producto productoObj = productoService.buscarPorId(id_producto);
        if(productoObj==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productoObj);
    }



}
