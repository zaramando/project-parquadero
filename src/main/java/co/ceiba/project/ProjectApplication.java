package co.ceiba.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import co.ceiba.project.model.Vehiculo;
import co.ceiba.project.service.VehiculoService;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjectApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(ProjectApplication.class, args);

		VehiculoService vehiculoService = context.getBean(VehiculoService.class);
		Vehiculo v = new Vehiculo("Renault", "Sandero","AXC45H", 1586, "Carro");
		vehiculoService.saveVehiculo(v);
		v.setMarca("R");
		v.setModelo("S");
		v.setPlaca("A");
		v.setCilindraje(1);
		v.setTipo("M");		
		vehiculoService.updateVehiculo(v);
		vehiculoService.saveVehiculo(new Vehiculo("Renault", "Logan","LVM70D", 1456, "Moto"));
	}
}
