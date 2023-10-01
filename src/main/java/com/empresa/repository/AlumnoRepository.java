package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	public List<Alumno> findByNombreIgnoreCase(String nombre);
	public List<Alumno> findByDniIgnoreCase(String dni);
}
