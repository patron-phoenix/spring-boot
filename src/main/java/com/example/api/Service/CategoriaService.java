package com.example.api.Service;

import com.example.api.Models.CategoriaModel;
import com.example.api.Repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
  @Autowired
  CategoriaRepository categoriaRepository;

  public ArrayList<CategoriaModel> obtenerCategoria(){
    return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
  }

  public Optional<CategoriaModel> obtenerPorId(Long id){
    return categoriaRepository.findById(id);
  }

  public CategoriaModel guardarCategoria(CategoriaModel categoria){
    return categoriaRepository.save(categoria);
  }

  public CategoriaModel actualizarCategoria(Long id, CategoriaModel categoria){
    CategoriaModel cate=categoriaRepository.findById(id).get();
    cate.setNombre(categoria.getNombre());
    return categoriaRepository.save(cate);
  }

  public boolean eliminarCategoria(Long id){
    try {
      categoriaRepository.deleteById(id);
      return true;
    }catch (Exception e){
      return false;
    }

  }
}
