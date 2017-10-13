package co.ceiba.project.rest;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.ceiba.project.model.Vehiculo;

import co.ceiba.project.service.VehiculoService;




@RestController
public class VehiculoRestController {
	
	@Autowired
    private VehiculoService vehiculoService;	
	
	// GET LISTAR TODOS LOS VEHICULOS
	@RequestMapping(value = "/vehiculos", method = RequestMethod.GET)
    public ResponseEntity<List<Vehiculo>> listAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.findAllVehiculos();
        if(vehiculos.isEmpty()){
            return new ResponseEntity<List<Vehiculo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
    }
	
	// POST CREAR UN VEHICULO
	@RequestMapping(value = "/vehiculos", method = RequestMethod.POST)
    public ResponseEntity<Void> createVehiculo(@RequestBody Vehiculo vehiculo,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creando Vehiculo " + vehiculo.getTipo());
 
        if (vehiculoService.isUserExist(vehiculo)) {
            System.out.println("Un Vehiculo de tipo " + vehiculo.getTipo() + " ya existe");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
		return null;
	
	}
	
	//PUT ACTUALIZAR UN VEHICULO
	@RequestMapping(value = "/vehiculos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable("id") long id, @RequestBody Vehiculo vehiculo) {
        System.out.println("Updating User " + id);
         
        Vehiculo currentVehiculo = vehiculoService.findById(id);
         
        if (currentVehiculo==null) {
            System.out.println("Vehiculo con id " + id + " no encontrado");
            return new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
        }
 
        currentVehiculo.setMarca(vehiculo.getMarca());
        currentVehiculo.setModelo(vehiculo.getModelo());
        currentVehiculo.setPlaca(vehiculo.getPlaca());
        currentVehiculo.setCilindraje(vehiculo.getCilindraje());
        currentVehiculo.setTipo(vehiculo.getTipo());	
        
         
        vehiculoService.updateVehiculo(currentVehiculo);
        return new ResponseEntity<Vehiculo>(currentVehiculo, HttpStatus.OK);
    }
	
	//DELETE ELIMINAR UN VEHICULO
	@RequestMapping(value = "/Vehiculos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Vehiculo> deleteVehiculo(@PathVariable("id") long id) {
        System.out.println("Obteniendo y eliminando Vehiculo con id " + id);
 
        Vehiculo vehiculo = vehiculoService.findById(id);
        if (vehiculo == null) {
            System.out.println("No se puede eliminar. Vehiculo con id " + id + " no encontrado");
            return new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND);
        }
 
        vehiculoService.deleteVehiculoById(id);
        return new ResponseEntity<Vehiculo>(HttpStatus.NO_CONTENT);
    }
	
	//DELETE ELIMINAR TODOS LOS VEHICULOS
	@RequestMapping(value = "/Vehiculos", method = RequestMethod.DELETE)
    public ResponseEntity<Vehiculo> deleteAllVehiculos() {
        System.out.println("Eliminando todos los Vehiculos");
 
        vehiculoService.deleteAllVehiculos();;
        return new ResponseEntity<Vehiculo>(HttpStatus.NO_CONTENT);
    }
}
