package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Sucursal;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    //Listar solo activos
    @Query(value = "select * from sucursal s  where s.estado !='E' order by s.id_sucursal asc", nativeQuery = true)
    public List<Sucursal> listarActivos();

    @Query(value = "select * from sucursal u where u.estado !='E' AND u.id_sucursal=?1", nativeQuery = true)
    public Sucursal sucursalActivoPorId(int id_sucursal);

    //Eliminar sucursal
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update sucursal set estado='E' where id_sucursal=?1", nativeQuery = true)
    public void elimminar(int id_sucursal);


}
