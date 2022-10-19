package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Compra;
import com.investigacion.operaciones.Service.CompraService;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin("*")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/listar")
    public ResponseEntity<List<Compra>> listar(){
        List<Compra> compras = compraService.getAll();
        if(compras.isEmpty()){
          return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compras);
    }

    @PostMapping("/crear")
    public ResponseEntity<Compra> crear(@RequestBody Compra compra){
       // Compra compraObj = compraService.guardar(compra);
       // if(compraObj==null){
       //     return ResponseEntity.noContent().build();
       // }
        return ResponseEntity.ok(compraService.guardar(compra));
    }

    @GetMapping("/eliminar/{id_compra}")
    public void eliminar(@PathVariable int id_compra){
        compraService.eliminar(id_compra);
    }

    @GetMapping("/buscar/{id_compra}")
    public ResponseEntity<Compra> buscar(@PathVariable int id_compra){
        Compra compraObj = compraService.buscarPorId(id_compra);
        if(compraObj==null){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compraObj);
    }
}
