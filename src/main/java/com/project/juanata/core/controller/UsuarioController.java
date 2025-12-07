package com.project.juanata.core.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.model.dto.UsuarioDTO;
import com.project.juanata.core.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioServicio;
	
	
	@GetMapping(path = "/registrar")
	public ModelAndView mostrarFormularioRegistroUsuario() {
		return new ModelAndView(Vistas.REGISTRAR_USUARIO);
	}
	
	@ModelAttribute("usuario")
	public UsuarioDTO retornarNuevoUsuarioDTO() {
		return new UsuarioDTO();
	}
	
	@PostMapping("/crear")
	public String registrarUsuario(@ModelAttribute("usuario") UsuarioDTO usuarioDTO) {
		
		try {
			usuarioServicio.crearUsuario(usuarioDTO);
			return "redirect:/usuario/registrar?exito";
		} catch (SQLException e) {
			return "redirect:/usuario/registrar?sinExito";
		}
	}

    @GetMapping("/admin/juanata/login")
    public ModelAndView mostrarLoginAdmin() {
        return new ModelAndView(Vistas.LOGIN);
    }

}
