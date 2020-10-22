package com.jhonatanfrade.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problema {
  
  private Integer status;
  private LocalDateTime dataHora;
  private String titulo;
  private List<Campo> campos;

  public static class Campo {
    private String nome;
    private String mensage;

    public Campo(String nome, String mensage) {
      this.nome = nome;
      this.mensage = mensage;
    }

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getMensage() {
      return mensage;
    }

    public void setMensage(String mensage) {
      this.mensage = mensage;
    }
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<Campo> getCampos() {
    return campos;
  }

  public void setCampos(List<Campo> campos) {
    this.campos = campos;
  }
}
