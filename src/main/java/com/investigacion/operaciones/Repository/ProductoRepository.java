package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "select p.id_producto,p.nombre_producto,p.id_marca,m.descripcion,p.linea,\n" +
            "p.modelo, p.cilindraje, p.espec_tecnicas, p.existencias,p.precio,\n" +
            "p.id_categoria, c.descripcion_cat, p.id_usuario,u.nombre_usuario,\n" +
            "p.id_persona, pr.nombre_persona, p.estado, p.usuario_creacion,\n" +
            "p.usuario_modificacion, p.fecha_creacion, p.fecha_modificacion\n" +
            "from producto p \n" +
            "inner join marca m on p.id_marca=m.id_marca\n" +
            "inner join categoria c on p.id_categoria=c.id_categoria\n" +
            "inner join usuario u on p.id_usuario=u.id_usuario\n" +
            "inner join persona pr on p.id_persona=pr.id_persona where p.estado!='E'", nativeQuery = true)
    public List<Producto> listarActivos();

    //Buscar activos por id
    @Query(value = "select * from producto p where p.estado !='E' AND p.id_producto=?1", nativeQuery = true)
    public Producto productoActivoPorId(int id_producto);

    //Eliminar producto
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update producto set estado='E' where id_producto=?1", nativeQuery = true)
    public void elimminar(int id_producto);

}
