package com.project.juanata.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.juanata.core.entity.Color;
import com.project.juanata.core.model.dto.ColorDTO;
import com.project.juanata.core.repository.ColorRepository;

@Service
public class CartaDeColoresServiceImpl implements CartaDeColoresService {
	
	@Autowired
	ColorRepository colorRepository;
	

	@Override
	public List<ColorDTO> obtenerColores() {
		
		List<ColorDTO> coloresDTO = new ArrayList<>();
		Iterable<Color> colores = colorRepository.findAll();
		
		for (Color color : colores) {
			coloresDTO.add(transformarObjetoColorAColorDTO(color));
		}
		
		return coloresDTO;
	}
	
	private ColorDTO transformarObjetoColorAColorDTO(Color color) {
		
		ColorDTO colorDTO = new ColorDTO();
		
		colorDTO.setId(color.getId());
		colorDTO.setColor(color.getColor());
		colorDTO.setClaseColor(color.getClaseColor());
		
		return colorDTO;
	}

}
