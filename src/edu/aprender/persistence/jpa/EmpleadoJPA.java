package edu.aprender.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.aprender.persistence.entity.Empleado;

public class EmpleadoJPA {

	// Definimos dos propiedades en la clase
	private EntityManagerFactory emf;
	private EntityManager em;
	
	// Definimos un m�todo con nombre setup para configurar los valores iniciales de esas propiedades	
	public void setup() {
		// Referenciamos a nuestra unidad de persistencia Aplicacion_05 para gestionar nuestras entidades
		emf = Persistence.createEntityManagerFactory("Aplicacion_05_Introduccion_JPA");
		// Creamos instancia del EntityManager
		em = emf.createEntityManager();
	}

	// Definimos un m�todo close para liberar el objeto Entity Manager.
	public void close() {
		// cierra el EntityManager
		em.close();
	}

	// Ahora definimos un m�todo para ejecutar sentencias SELECT:
	public List<Empleado> consultar() throws Exception {
		// 1. Definimos JPQL
		String query = "SELECT o FROM Empleado o ORDER BY o.id";
		Query emquery = em.createQuery(query);
		// 2.Ejecutamos query
		List<Empleado> listaEntidad = emquery.getResultList();
		return listaEntidad;
	}

	// Luego, un m�todo para Ejecutar sentencias INSERT
	public void insertar(Empleado entidadEmpleado) throws Exception {
		// 1.Inicia la transacci�n
		em.getTransaction().begin();
		// 2.Prepara operacion INSERT
		em.persist(entidadEmpleado);
		// 3.Ejecuta operaci�n. 
		em.flush(); // De no usar este m�todo, las operaciones se ejecutar�n al invocar m�todo commit()
		// 4.Ejecuta commit a la transacci�n
		em.getTransaction().commit();
	}

	// Luego, un m�todo para Ejecutar sentencias UPDATE
	public void actualizar(Empleado entidadEmpleado) throws Exception {
		// 1.Inicia la transacci�n
		em.getTransaction().begin();
		// 2 Prepara operaci�n UPDATE
		em.merge(entidadEmpleado);
		// 3.Ejecuta operaci�n. 
		em.flush(); // De no usar este m�todo, las operaciones se ejecutar�n al invocar m�todo commit()
		// 4.Ejecuta commit a la transacci�n
		em.getTransaction().commit();
	}

	// Luego, un m�todo para Ejecutar sentencias DELETE
	public void eliminar(Integer id) throws Exception {
		// 1.Inicia la transacci�n
		em.getTransaction().begin();
		// 2. Prepara las operaciones
		// 2.1 busca Empleado por llave primaria
		Empleado entidadEmpleado = (Empleado) em.find(Empleado.class, id);
		// 2.2 Elimina Empleado
		em.remove(entidadEmpleado);
		// 3.Ejecuta operaci�n. 
		em.flush(); // De no usar este m�todo, las operaciones se ejecutar�n al invocar m�todo commit()
		// 4.Ejecuta commit a la transacci�n
		em.getTransaction().commit();
	}

}