package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Sucursal;
import com.investigacion.operaciones.Entity.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Listar solo activos
    //@Query(value = "select * from usuario u where u.estado !='E' order by u.id_usuario asc", nativeQuery = true)
    @Query(value = "select u.id_usuario, u.nombre, u.direccion, u.email, u.cui,\n" +
            "u.username, u.clave, u.rol, u.estado, u.id_sucursal,\n" +
            "u.usuario_creacion, u.usuario_modificacion,\n" +
            "u.fecha_creacion, u.fecha_modificacion,\n" +
            "s.nombre_sucursal,\n" +
            "s.ubicacion_sucursal\n" +
            "from usuario u\n" +
            "inner join sucursal s on u.id_sucursal = s.id_sucursal\n" +
            " where u.estado!='E'\n" +
            "order by u.id_usuario asc", nativeQuery = true)
    public List<Usuario> listarActivos();

    @Query(value = "select * from usuario u where u.estado !='E' AND u.id_usuario=?1", nativeQuery = true)
    public Usuario usuarioActivoPorId(int id_usuario);

    //Cambiar estado a eliminado logico
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update usuario set estado='E' where id_usuario=?1", nativeQuery = true)
    public void eliminarUsuario(int id_usuario);


    @Query(value = "select * from usuario where nombre=?1 and clave=?2 ", nativeQuery = true)
    public Optional<Usuario> login(String username, String clave);
}
