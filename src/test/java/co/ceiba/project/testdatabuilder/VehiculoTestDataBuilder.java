package co.ceiba.project.testdatabuilder;

import co.ceiba.project.model.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String MARCA = "renault";
	private static final String MODELO = "sandero";
	private static final String PLACA = "XRE45Y";
	private static final float CILINDRAJE = 1598;
	private static final String TIPO ="Carro";
	
	private String marca;
	private String modelo;
	private String placa;
	private float cilindraje;
	private String tipo;

	public VehiculoTestDataBuilder() {
		this.marca = MARCA;
		this.modelo = MODELO;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO;
	}
	
	public VehiculoTestDataBuilder conMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public VehiculoTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(float cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public Vehiculo build() {
		return new Vehiculo(this.marca, this.modelo, this.placa, this.cilindraje, this.tipo);
	}

}