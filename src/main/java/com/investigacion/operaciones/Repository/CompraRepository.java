package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Compra;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    //Filtar por id de usuario que realiza la venta
    @Query(value = "select * from compra c where c.estado!='E'", nativeQuery = true)
    public List<Compra> getAll();

    @Transactional
    @Modifying
    @Query(value = "update compra set estado='E' where id_compra=?1", nativeQuery = true)
    public void eliminar(int id_compra);

    @Query(value = "select * from compra c where c.estado!='E' AND c.id_compra=?1", nativeQuery = true)
    public Compra buscar(int id_compra);
}
