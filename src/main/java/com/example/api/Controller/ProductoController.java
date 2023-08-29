package com.example.api.Controller;

import com.example.api.Models.CategoriaModel;
import com.example.api.Models.ProductoModel;
import com.example.api.Service.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {
  @Autowired
  ProductoService productoService;

  @GetMapping
  public ArrayList<ProductoModel> obtenerProducto(){
    return this.productoService.obtenerProducto();
  }
  @GetMapping(path="/{id}")
  public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Long id) {
    return this.productoService.obtenerPorId(id);
  }

  @PostMapping()
  public ProductoModel guardarProducto(@RequestBody ProductoModel producto){
    return  this.productoService.guardarProducto(producto);
  }

  @PutMapping(path="/{id}")
  public ProductoModel actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductoModel producto){
    return this.productoService.actualizarProducto(id,producto);
  }

  @DeleteMapping(path="/{id}")
  public String eliminarProducto(@PathVariable("id") Long id){
    boolean ok=this.productoService.eliminarProducto(id);
    if(ok){
      return "Se eliminó el producto con el id "+id;
    }else{
      return "No se pudo eliminar el producto con el id "+id;
    }
  }


}
