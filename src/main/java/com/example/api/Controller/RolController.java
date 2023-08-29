package com.example.api.Controller;

import com.example.api.Models.CategoriaModel;
import com.example.api.Models.RolModel;
import com.example.api.Service.RolService;
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
@RequestMapping("/rol")
public class RolController {
  @Autowired
  RolService rolService;

  @GetMapping
  public ArrayList<RolModel> obtenerRol(){
    return this.rolService.obtenerRol();
  }
  @GetMapping(path="/{id}")
  public Optional<RolModel> obtenerRolPorId(@PathVariable("id") Long id) {
    return this.rolService.obtenerPorId(id);
  }

  @PostMapping()
  public RolModel guardarRol(@RequestBody RolModel rol){
    return  this.rolService.guardarRol(rol);
  }

  @PutMapping(path="/{id}")
  public RolModel actualizarRol(@PathVariable("id") Long id, @RequestBody RolModel rol){
    return this.rolService.actualizarRol(id,rol);
  }

  @DeleteMapping(path="/{id}")
  public String eliminarRol(@PathVariable("id") Long id){
    boolean ok=this.rolService.eliminarRol(id);
    if(ok){
      return "Se eliminó el rol con el id "+id;
    }else{
      return "No se pudo eliminar el rol con el id "+id;
    }
  }


}
