package com.project.juanata.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.juanata.core.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{
	

}
