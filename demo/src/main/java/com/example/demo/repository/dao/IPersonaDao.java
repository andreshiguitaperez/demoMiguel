package com.example.demo.repository.dao;

import com.example.demo.repository.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository <Persona, Long> {
}
