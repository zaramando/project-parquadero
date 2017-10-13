package co.ceiba.project.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;

import co.ceiba.project.model.Vehiculo;
import co.ceiba.project.testdatabuilder.VehiculoTestDataBuilder;



public class VehiculoTest {

	private static final String MARCA = "renault";
	private static final String MODELO = "sandero";
	private static final String PLACA = "XRE45Y";
	private static final float CILINDRAJE = 1598;
	private static final String TIPO = "Carro";

	@Test
	public void crearVehiculoTest() {
		
		// arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder =  new VehiculoTestDataBuilder().
				conMarca(MARCA).
				conModelo(MODELO).
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE).
				conTipo(TIPO);
		       
		// act
		Vehiculo vehiculo =  vehiculoTestDataBuilder.build();

		// assert
		assertEquals(MARCA, vehiculo.getMarca());
		assertEquals(MODELO, vehiculo.getModelo());
		assertEquals(PLACA, vehiculo.getPlaca());
		assertTrue(CILINDRAJE == vehiculo.getCilindraje());
	}

}
