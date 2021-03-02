package com.example.demo.service;

import com.example.demo.repository.dao.IPersonaDao;
import com.example.demo.repository.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> findAll(){return (List<Persona>) personaDao.findAll();}

    @Override
    public Persona findById(Long id){return personaDao.findById(id).orElse(null);}

    @Override
    public Persona save(Persona persona){return personaDao.save(persona);}

    @Override
    public void delete(Long id){ personaDao.deleteById(id);}



}
