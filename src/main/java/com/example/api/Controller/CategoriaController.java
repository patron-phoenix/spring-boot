package com.example.api.Controller;

import com.example.api.Models.CategoriaModel;
import com.example.api.Service.CategoriaService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
  @Autowired
  CategoriaService categoriaService;
  @GetMapping
  public ArrayList<CategoriaModel>obtenerCategoria(){
    return this.categoriaService.obtenerCategoria();
  }
  @GetMapping(path="/{id}")
  public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id") Long id) {
    return this.categoriaService.obtenerPorId(id);
  }

  @PostMapping()
  public CategoriaModel guardarCategoria(@RequestBody CategoriaModel categoria){
    return  this.categoriaService.guardarCategoria(categoria);
  }

  @PutMapping(path="/{id}")
  public CategoriaModel actualizarCategoria(@PathVariable("id") Long id, @RequestBody CategoriaModel categoria){
    return this.categoriaService.actualizarCategoria(id,categoria);
  }

  @DeleteMapping(path="/{id}")
  public String eliminarCategoria(@PathVariable("id") Long id){
    boolean ok=this.categoriaService.eliminarCategoria(id);
    if(ok){
      return "Se eliminó la categoría con el id "+id;
    }else{
      return "No se pudo eliminar la categoría con el id "+id;
    }
  }

}
