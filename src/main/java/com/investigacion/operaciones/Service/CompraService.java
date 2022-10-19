package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Compra;
import com.investigacion.operaciones.Repository.CompraRepository;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAll(){
        return compraRepository.getAll();
    }

    public Compra guardar(Compra compra){
        return compraRepository.save(compra);
    }

    public Compra actualizar(Compra compra){
        return compraRepository.save(compra);
    }

    public void eliminar(int id_compra){
        compraRepository.eliminar(id_compra);
    }

    public Compra buscarPorId(int id_compra){
        return compraRepository.buscar(id_compra);
    }



}
