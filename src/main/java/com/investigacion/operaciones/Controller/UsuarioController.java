package com.investigacion.operaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.investigacion.operaciones.Entity.Catalogo;
import com.investigacion.operaciones.Entity.Usuario;
import com.investigacion.operaciones.Service.CatalogosService;
import com.investigacion.operaciones.Service.UsuarioService;
import com.investigacion.operaciones.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CatalogosService catalogosService;
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> list = usuarioService.listarUsuarios();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/eliminar/{id_usuario}")
    public void eliminar(@PathVariable int id_usuario){
        usuarioService.eliminar(id_usuario);
    }

    @GetMapping("/buscar/{id_usuario}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id_usuario){
        Usuario usuario = usuarioService.buscarPorId(id_usuario);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/catalogos")
    public ResponseEntity<List<Catalogo>> getRoles(){
        List<Catalogo> roles = catalogosService.getRoles();
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }


    @PostMapping("/login")
    public ResponseEntity<Optional<Usuario>> login(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(usuarioService.login(usuario));
    }
}
