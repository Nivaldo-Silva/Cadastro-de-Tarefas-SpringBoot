package br.com.spring.cadastro_de_tarefas.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Cadastro {
    
    public Cadastro(Long id, String name, Date date) {
    this.id = id;
    this.name = name;
    this.date = date;
  }

  public Cadastro() {
  }

  private Long id;
  private String name;

  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private Date date;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

}
