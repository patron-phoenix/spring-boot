package com.example.api.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoModel {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(unique = true,nullable=false)
  private Long id;
  private String  nombre;
  private String descripcion;
  @ManyToOne
  private  CategoriaModel categoria;

  public ProductoModel() {
  }

  public ProductoModel(Long id, String nombre, String descripcion, CategoriaModel categoria) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public CategoriaModel getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaModel categoria) {
    this.categoria = categoria;
  }
}
