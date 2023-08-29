package com.example.api.Service;

import com.example.api.Models.CategoriaModel;
import com.example.api.Models.ProductoModel;
import com.example.api.Repository.ProductoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
  @Autowired
  ProductoRepository productoRepository;

  public ArrayList<ProductoModel> obtenerProducto(){
    return (ArrayList<ProductoModel>) productoRepository.findAll();
  }

  public Optional<ProductoModel> obtenerPorId(Long id){
    return productoRepository.findById(id);
  }

  public ProductoModel guardarProducto(ProductoModel producto){
    return productoRepository.save(producto);
  }

  public ProductoModel actualizarProducto(Long id, ProductoModel producto){
    ProductoModel prod=productoRepository.findById(id).get();
    prod.setNombre(producto.getNombre());
    prod.setDescripcion(producto.getDescripcion());
    prod.setCategoria(producto.getCategoria());
    return productoRepository.save(prod);
  }
  public boolean eliminarProducto(Long id){
    try {
      productoRepository.deleteById(id);
      return true;
    }catch (Exception e){
      return false;
    }

  }

}
