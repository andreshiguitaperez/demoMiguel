package com.example.demo.controller;


import com.example.demo.repository.dao.IPersonaDao;
import com.example.demo.repository.entity.Persona;
import com.example.demo.service.IPersonaService;
import com.example.demo.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@CrossOrigin(origins = {"puerto en el que corre el front"})
@RestController
@RequestMapping("/api")
public class PersonaRestController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> index() {return personaService.findAll();}

    @GetMapping("/personas/{id}")
    public Persona sho(@PathVariable Long id){return personaService.findById(id);}

    @PostMapping("/personas")
    public Persona create(@RequestBody Persona persona){return personaService.save(persona);}

    @PutMapping("/personas/{id}")
    public Persona update(@RequestBody Persona persona, @PathVariable Long id){
        Persona personaActual = personaService.findById(id);

        personaActual.setNombres(persona.getNombres());
        personaActual.setApellidos(persona.getApellidos());
        personaActual.setDocumento(persona.getDocumento());
        personaActual.setTelefono(persona.getTelefono());

        return personaService.save(personaActual);
    }

    @DeleteMapping("/personas/{id}")
    public void delet(@PathVariable Long id) {personaService.delete(id);}


}
