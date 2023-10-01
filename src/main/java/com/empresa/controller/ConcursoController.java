package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Alumno;
import com.empresa.entity.Concurso;
import com.empresa.service.ConcursoService;

@Controller
public class ConcursoController {
 
	@Autowired
	private ConcursoService concursoService;
	
	@GetMapping(value = "/verConcurso" )
	public String verConcurso() {
		return "registrarConcurso";
	}
	
	
	
	
	@PostMapping("/registraConcurso")
	@ResponseBody
	public Map<String, Object> registra(Concurso obj){
		Map<String, Object> mapSalida = new HashMap<>();
		Concurso objSalida = concursoService.insertaConcurso(obj);
		if (objSalida == null) {
			mapSalida.put("mensaje", "Error en el registro");
		}else {
			mapSalida.put("mensaje", "Registro exitoso del Concurso ID => " + objSalida.getIdConcurso());
		}
		return mapSalida; 
	}
	
	

	@GetMapping("/buscaConcursoPorNombre")
	@ResponseBody
	public String validaNombre(String nombre) {
		List <Concurso>listaConcurso = concursoService.listaPorNombre(nombre);
		if(CollectionUtils.isEmpty(listaConcurso)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}
	
}
