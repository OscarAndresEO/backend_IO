package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Sucursal;
import com.investigacion.operaciones.Repository.SucursalRepository;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal crearSucursal(Sucursal sucursal){
        Sucursal nuevo = sucursalRepository.save(sucursal);
        return nuevo;
    }

    public List<Sucursal> listarTodo(){
        return sucursalRepository.listarActivos();
    }

    public void eliminar(int id_sucursal){
       sucursalRepository.elimminar(id_sucursal);
    }

    public Sucursal sucursalById(int id){
        return sucursalRepository.sucursalActivoPorId(id);
    }
}
