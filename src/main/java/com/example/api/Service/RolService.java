package com.example.api.Service;

import com.example.api.Models.CategoriaModel;
import com.example.api.Models.RolModel;
import com.example.api.Repository.RolRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
  @Autowired
  RolRepository rolRepository;

  public ArrayList<RolModel> obtenerRol(){
    return (ArrayList<RolModel>) rolRepository.findAll();
  }

  public Optional<RolModel> obtenerPorId(Long id){
    return rolRepository.findById(id);
  }

  public RolModel guardarRol(RolModel rol){
    return rolRepository.save(rol);
  }

  public RolModel actualizarRol(Long id, RolModel rol){
    RolModel ro=rolRepository.findById(id).get();
    ro.setNombre(rol.getNombre());
    ro.setDescripcion(rol.getDescripcion());
    return rolRepository.save(ro);
  }

  public boolean eliminarRol(Long id){
    try {
      rolRepository.deleteById(id);
      return true;
    }catch (Exception e){
      return false;
    }

  }


}
