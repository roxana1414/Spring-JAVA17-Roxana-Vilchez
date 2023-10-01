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
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping(value = "/verAlumno" )
	public String ver() {
		return "registraAlumno";
	}

	
	@PostMapping("/registraAlumno")
	@ResponseBody
	public Map<String, Object> registra(Alumno obj){
		Map<String, Object> mapSalida = new HashMap<>();
		Alumno objSalida = alumnoService.insertaAlumno(obj);
		if (objSalida == null) {
			mapSalida.put("mensaje", "Error en el registro");
		}else {
			mapSalida.put("mensaje", "Registro exitoso de Alumno ID => " + objSalida.getIdAlumno());
		}
		return mapSalida; 
	}


	@GetMapping("/buscaAlumnoPorNombre")
	@ResponseBody
	public String validaNombre(String nombre) {
		List <Alumno>listaAlumno = alumnoService.listaPorNombre(nombre);
		if(CollectionUtils.isEmpty(listaAlumno)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}
	
	@GetMapping("/buscaAlumnoPorDni")
	@ResponseBody
	public String validaDni(String dni) {
		List <Alumno>listaAlumno = alumnoService.listaPorDni(dni);
		if(CollectionUtils.isEmpty(listaAlumno)) {
			return "{\"valid\":true}";
		}else {
			return "{\"valid\":false}";
		}
	}

}