package com.investigacion.operaciones.Controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Persona;
import com.investigacion.operaciones.Service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin("*")
public class ProveedorController {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona persona){
        return  ResponseEntity.ok(personaService.crearPersona(persona));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> list = personaService.listarProveedoresActivos();
        if(list.isEmpty()){
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/eliminar/{id_persona}")
    public void eliminar(@PathVariable int id_persona){
        personaService.eliminarPersona(id_persona);
    }

    @GetMapping("/buscar/{id_persona}")
    public ResponseEntity<Persona> buscar(@PathVariable int id_persona){
        Persona personaObj = personaService.proveedorPorId(id_persona);
        if(personaObj==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personaObj);
    }

}
