package com.investigacion.operaciones.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Entity.Persona;
import com.investigacion.operaciones.Repository.PersonaRepository;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    /*** Metodos en Comun***/
    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void eliminarPersona(int id_persona){
        personaRepository.elimminarProveedor(id_persona);
    }

    /***  Proveedores ****/
    public List<Persona> listarProveedoresActivos(){
        return personaRepository.listarProveedoresActivos();
    }

    public Persona proveedorPorId(int id_persona){
        return personaRepository.proveedorPorId(id_persona);
    }
    /*** Clientes ***/

    public List<Persona> listarClientesActivos(){
        return personaRepository.listarClientesActivos();
    }

    public Persona clientePorId(int id_persona){
        return personaRepository.clientePorId(id_persona);
    }
}
