package edu.aprender.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Con estos 3 puntos hemos terminado el mapeo relacional objeto de la tabla Empleado.

@Entity // @Entity: Significa que esta clase entidad representa una tabla de datos relacional
@Table(name="tb_empleado") // @Table: Es la tabla que representa esta clase entidad
public class Empleado {
	
	@Id // @id: Sirve para indicar el atributo que representa la PK de la tabla
	private int id;
	@Column(name="nombre") // @column: Sirve para indicar que el atributo es una columna, en este caso no es necesario ya que los atributos de la clase tienen el mismo nombre que las columnas de la tabla relacional
	private String nombre;
	private String apellido;
	private int edad;
	private String area;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	// Sobreescribir el método toString para realizar pruebas unitarias
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", edad=" + edad + ", area=" + area + "]";
	}
	
	/*
	  Si muestra un error recuerda que tenemos que asociar la clase a una unidad de persistencia
	  Las configuraciones para JPA se realizan en el archivo persistence.xml
	*/

}
