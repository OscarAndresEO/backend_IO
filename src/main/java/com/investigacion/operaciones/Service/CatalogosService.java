package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Catalogo;
import com.investigacion.operaciones.Repository.CatalogoRepository;

import java.util.List;

@Service
public class CatalogosService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    //Listado de roles
    public List<Catalogo> getRoles(){
        return catalogoRepository.getRoles();
    }
}
