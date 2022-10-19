package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Sucursal;
import com.investigacion.operaciones.Service.SucursalService;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
//http://localhost:4200 o pj en heroku
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/crear")
    public ResponseEntity<Sucursal> crear(@RequestBody Sucursal sucursal){
        Sucursal objSucursal = sucursalService.crearSucursal(sucursal);
        return ResponseEntity.ok(objSucursal);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Sucursal>> listar(){
        List<Sucursal> lista = sucursalService.listarTodo();
        if(lista.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/actualizar")
    public Sucursal actualizar(@RequestBody Sucursal sucursal){
        return sucursalService.crearSucursal(sucursal);
    }


    @GetMapping("/eliminar/{id_sucursal}")
    public void eliminar(@PathVariable int id_sucursal){
        sucursalService.eliminar(id_sucursal);
    }

    @GetMapping("/buscar/{id_sucursal}")
    public ResponseEntity<Sucursal> buscarPorId(@PathVariable int id_sucursal){
        Sucursal sucursal = sucursalService.sucursalById(id_sucursal);
        if(sucursal==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sucursal);
    }
}
