package co.ceiba.project.service;

import java.util.List;

import co.ceiba.project.model.Vehiculo;

public interface VehiculoService {

    Vehiculo findById(long id);
	
   	void saveVehiculo(Vehiculo vehiculo);
	
	void updateVehiculo(Vehiculo user);
	
	void deleteVehiculoById(long id);

	List<Vehiculo> findAllVehiculos(); 
	
	void deleteAllVehiculos();
	
	public boolean isUserExist(Vehiculo vehiculo);	
	
}
