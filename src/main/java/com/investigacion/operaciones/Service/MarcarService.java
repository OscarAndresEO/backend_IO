package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Marca;
import com.investigacion.operaciones.Repository.MarcaRepository;

import java.util.List;

@Service
public class MarcarService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca crearMarca(Marca marca){
        Marca marcaObj = marcaRepository.save(marca);
        return marcaObj;
    }

    public List<Marca> listarActivos(){
        return marcaRepository.listarActivos();
    }

    public void eliminar(int id_marca){
        marcaRepository.elimminar(id_marca);
    }

    public Marca activosPorId(int id_marca){
        return marcaRepository.sucursalActivoPorId(id_marca);
    }
}
