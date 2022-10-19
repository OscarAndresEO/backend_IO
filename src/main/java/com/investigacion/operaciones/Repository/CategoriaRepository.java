package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    //Listar solo activos
    @Query(value = "select * from categoria s  where s.estado !='E' order by s.id_categoria asc", nativeQuery = true)
    public List<Categoria> listarActivos();

    @Query(value = "select * from categoria u where u.estado !='E' AND u.id_categoria=?1", nativeQuery = true)
    public Categoria ActivoPorId(int id_categoria);

    //Eliminar sucursal
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update categoria set estado='E' where id_categoria=?1", nativeQuery = true)
    public void elimminar(int id_categoria);
}
