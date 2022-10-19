package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Marca;

import java.util.List;

@Repository
public interface MarcaRepository  extends JpaRepository<Marca, Integer> {

    //Listar solo activos
    @Query(value = "select * from marca s  where s.estado !='E' order by s.id_marca asc", nativeQuery = true)
    public List<Marca> listarActivos();

    //Activos por Id
    @Query(value = "select * from marca u where u.estado !='E' AND u.id_marca=?1", nativeQuery = true)
    public Marca sucursalActivoPorId(int id_marca);

    //Eliminar
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update marca set estado='E' where id_marca=?1", nativeQuery = true)
    public void elimminar(int id_marca);
}
