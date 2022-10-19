package com.investigacion.operaciones.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.investigacion.operaciones.Repository.CategoriaRepository;
import com.investigacion.operaciones.Entity.Categoria;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crear(Categoria categoria){
        Categoria nuevo = categoriaRepository.save(categoria);
        return nuevo;
    }

    public List<Categoria> listarTodo(){
        return categoriaRepository.listarActivos();
    }

    public void eliminar(int id_categoria){
        categoriaRepository.elimminar(id_categoria);
    }

    public Categoria CategoriaById(int id){
        return categoriaRepository.ActivoPorId(id);
    }
}
