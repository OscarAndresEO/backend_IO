package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Usuario;
import com.investigacion.operaciones.Repository.UsuarioRepository;
import  com.investigacion.operaciones.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){
        //Usuario user = usuarioRepository.save(usuario);
        //return user;
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.listarActivos();
    }

   public void eliminar(int id_usuario){
        usuarioRepository.eliminarUsuario(id_usuario);
   }

   public Usuario buscarPorId(int id_usuario){
        return usuarioRepository.usuarioActivoPorId(id_usuario);
   }

   public Optional<Usuario> login(UsuarioDTO usuario){
        return usuarioRepository.login(usuario.getUsername(), usuario.getClave());
   }

}
