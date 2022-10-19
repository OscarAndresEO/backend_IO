package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.investigacion.operaciones.Entity.Persona;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    /***Metodos en Comun ***/
    //Eliminar
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update persona set estado='E' where id_persona=?1", nativeQuery = true)
    public void elimminarProveedor(int id_persona);

    /*** Metodos de Proveedores***/

    //Listar PROVEEDORES activos
    @Query(value = "select * from persona p  where p.estado !='E' and p.tipo_persona='P' order by p.id_persona asc",
            nativeQuery = true)
    public List<Persona> listarProveedoresActivos();

    //Buscar Proveedor por Id
    @Query(value = "select * from persona p where p.estado !='E' and p.tipo_persona='P' AND p.id_persona =?1",
            nativeQuery = true)
    public Persona proveedorPorId(int id_persona);

    /*** Metodos de Clientes ***/

    //Listar CLIENTES activos
    @Query(value = "select * from persona p  where p.estado !='E' and p.tipo_persona='C' order by p.id_persona asc",
            nativeQuery = true)
    public List<Persona> listarClientesActivos();

    //Buscar Cliente por ID
    @Query(value = "select * from persona p where p.estado !='E' and p.tipo_persona='C' AND p.id_persona =?1",
            nativeQuery = true)
    public Persona clientePorId(int id_persona);

}
