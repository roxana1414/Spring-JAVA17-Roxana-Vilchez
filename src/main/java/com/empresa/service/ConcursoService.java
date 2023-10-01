package com.empresa.service;

import java.util.List;


import com.empresa.entity.Concurso;

public interface ConcursoService {

	public abstract Concurso insertaConcurso(Concurso obj);
	public abstract List<Concurso> listaPorNombre(String nombre);
}
