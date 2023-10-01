package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, Integer>{
	
	public List<Concurso> findByNombreIgnoreCase(String nombre);

}
