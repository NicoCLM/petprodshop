package com.nico.petsprodshop.models;

import jakarta.validation.constraints.NotEmpty;

public class PersonaDto {

	@NotEmpty(message = "Hay un campo vacio")
	private String ciudad;
	
	@NotEmpty(message = "Hay un campo vacio")
	private String correo_electronico;
	
	@NotEmpty(message = "Hay un campo vacio")
	private String direccion;
	
	@NotEmpty(message = "Hay un campo vacio")
	private String identificacion;
	
	@NotEmpty(message = "Hay un campo vacio")
	private String nombre;
	
	@NotEmpty(message = "Hay un campo vacio")
	private String telefono;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
