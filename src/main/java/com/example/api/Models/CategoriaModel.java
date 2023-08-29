package com.example.api.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(unique = true,nullable=false)
  private Long id;
  private String  nombre;

  public CategoriaModel() {
  }

  public CategoriaModel(Long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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
}
