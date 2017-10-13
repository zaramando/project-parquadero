package co.ceiba.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Vehiculo implements Serializable {
	  
	  private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue
	  @Column(name = "ID")

	  private Long id;	
	  private String marca;	 
	  private String modelo;	 
	  private String placa;	 
	  private float cilindraje;	 
	  private String tipo;

	  public Vehiculo() {
	  }

	  public Vehiculo(String marca, String modelo, String placa, float cilindraje, String tipo) {
	    this.marca = marca;
	    this.modelo = modelo;
	    this.placa = placa;
	    this.cilindraje = cilindraje;
	    this.tipo = tipo;
	  }

	  public Long getId() {
	    return id;
	  }
	  
	  public void setId(Long id){
		  this.id = id;
	  }

	   public String getMarca() {
	    return marca;
	  }
	   
	  public void setMarca(String marca){
		  this.marca = marca;
	  }

	   public String getModelo() {
	    return modelo;
	  }
	   
	  public void setModelo(String modelo){
		  this.modelo = modelo;
	  }

	  public String getPlaca() {
		return placa;
	  }
	  
	  public void setPlaca(String placa){
		  this.placa = placa;
	  }

	   public Float getCilindraje() {
		return cilindraje;
	  }
	   
	  public void setCilindraje(float cilindraje){
		  this.cilindraje = cilindraje;
	  }
		
	  public String getTipo() {
		return tipo;
	  }
	  
	  public void setTipo(String tipo){
		  this.tipo = tipo;
	  }

	  
	
}
