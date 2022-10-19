package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Marca;
import com.investigacion.operaciones.Entity.Sucursal;
import com.investigacion.operaciones.Service.MarcarService;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin("*")
public class MarcaController {

    @Autowired
    private MarcarService marcarService;

    @PostMapping("/crear")
    public ResponseEntity<Marca> crear(@RequestBody Marca marca){
        Marca marcaObj = marcarService.crearMarca(marca);
        if(marcaObj==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcaObj);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Marca>> listarActivos(){
        List<Marca> marcas = marcarService.listarActivos();
        if(marcas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcas);
    }

    //UPDATE****************
    @PostMapping("/actualizar")
    public Marca updateMarca(@RequestBody  Marca marca){
        return marcarService.crearMarca(marca);
    }

    @GetMapping("/eliminar/{id_marca}")
    public void eliminar(@PathVariable int id_marca){
        marcarService.eliminar(id_marca);
    }

    @GetMapping("/buscar/{id_marca}")
    public ResponseEntity<Marca> activosPorId(@PathVariable int id_marca){
        Marca marcaObj = marcarService.activosPorId(id_marca);
        if(marcaObj==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcaObj);
    }
}
