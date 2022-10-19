package com.investigacion.operaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.investigacion.operaciones.Entity.Catalogo;

import java.util.List;

//@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {

    //Listado de roles
    @Query(value = "select * from catalogo c where c.tipo_catalogo = 'R' and c.estado!='E'",
            nativeQuery = true)
    public List<Catalogo> getRoles();
}
