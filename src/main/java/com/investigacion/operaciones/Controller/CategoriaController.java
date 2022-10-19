package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Categoria;
import com.investigacion.operaciones.Service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/crear")
    public ResponseEntity<Categoria> crear(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.crear(categoria));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listar(){
        List<Categoria> list = categoriaService.listarTodo();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/eliminar/{id_categoria}")
    public void eliminar(@PathVariable int id_categoria){
        categoriaService.eliminar(id_categoria);
    }

    @GetMapping("/buscar/{id_categoria}")
    public ResponseEntity<Categoria> buscar(@PathVariable int id_categoria){
        Categoria categoriaObj = categoriaService.CategoriaById(id_categoria);
        if(categoriaObj==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoriaObj);
    }
}
