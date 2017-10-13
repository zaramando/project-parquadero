package co.ceiba.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.project.model.Vehiculo;
import co.ceiba.project.repository.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	  private VehiculoRepository vehiculoRepository;
	
	@Override
	public List<Vehiculo> findAllVehiculos() {
		return (List<Vehiculo>) vehiculoRepository.findAll();
	}

	@Override
	public Vehiculo findById(long id) {
		return vehiculoRepository.findOne(id);
	}
	

	@Override
	public void saveVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
		
	}

	@Override
	public void updateVehiculo(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
		
	}

	@Override
	public void deleteVehiculoById(long id) {
		vehiculoRepository.delete(id);
		
	}
	

	@Override
	public void deleteAllVehiculos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(Vehiculo vehiculo) {
		return findById(vehiculo.getId())!=null;
	}	

	  

}
