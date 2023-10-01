package com.empresa.service;

import java.util.List;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract Alumno insertaAlumno(Alumno obj);
	public abstract List<Alumno> listaPorNombre(String nombre);
	public abstract List<Alumno> listaPorDni(String dni);
}