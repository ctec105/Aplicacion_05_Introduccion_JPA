package edu.aprender.test;

import java.util.List;

import org.apache.log4j.Logger;

import edu.aprender.persistence.entity.Empleado;
import edu.aprender.persistence.jpa.EmpleadoJPA;

public class EmpleadoTest {
	
	static  Logger logger = Logger.getLogger(EmpleadoTest.class.getName());
	
	public static void main(String[] args) {
		EmpleadoJPA empleadoJPA = new EmpleadoJPA();
		empleadoJPA.setup();
		
		// Se instancia el objeto java y se cargan los valores de los atributos
		Empleado entidadEmpleado = new Empleado();
		entidadEmpleado.setId(1);
		entidadEmpleado.setNombre("Antonio");
		entidadEmpleado.setApellido("Perez");
		entidadEmpleado.setEdad(30);
		entidadEmpleado.setArea("100");
		
		try {
			logger.debug("Registrando un nuevo empleado");
			empleadoJPA.insertar(entidadEmpleado);
			mostrar(empleadoJPA.consultar());

			logger.debug("Actualizamos un empleado");
			entidadEmpleado.setApellido("Gomez");
			empleadoJPA.actualizar(entidadEmpleado);
			mostrar(empleadoJPA.consultar());

			logger.debug("Eliminamos un empleado");
			empleadoJPA.eliminar(1);
			mostrar(empleadoJPA.consultar());

		} catch (Exception e) {
			logger.error("Error " + e.getMessage());
			e.printStackTrace();
		} finally {
			empleadoJPA.close();
		}
	}
	
	private static void mostrar(List<Empleado> listaEntidad){
		for (int i = 0; i < listaEntidad.size(); i++) {
			Empleado entidad = (Empleado) listaEntidad.get(i);
			logger.info(entidad.toString());
		}
	}

}