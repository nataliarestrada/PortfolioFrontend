/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Controller;

import com.portfolio.PortfolioBackEnd.Dto.PersonaDto;
import com.portfolio.PortfolioBackEnd.Entity.Persona;
import com.portfolio.PortfolioBackEnd.Security.Controller.Mensaje;
import com.portfolio.PortfolioBackEnd.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natal
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto dtopers){
        if(StringUtils.isBlank(dtopers.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if(personaService.existsByNombreE(dtopers.getNombre())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
        
        Persona persona = new Persona(
                dtopers.getNombre(), dtopers.getOcupacion(), dtopers.getBannerUrl(), dtopers.getEmail()
                , dtopers.getLinkedinUrl(), dtopers.getGithubUrl(), dtopers.getFacebookUrl()
                , dtopers.getTwtterUrl(), dtopers.getInstagramUrl(), dtopers.getDescripcion(), dtopers.getImgUrl()
            );
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
//        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setOcupacion(dtopersona.getOcupacion());
        persona.setBannerUrl(dtopersona.getBannerUrl());
        persona.setEmail(dtopersona.getEmail());
        persona.setLinkedinUrl(dtopersona.getLinkedinUrl());
        persona.setGithubUrl(dtopersona.getGithubUrl());
        persona.setFacebookUrl(dtopersona.getFacebookUrl());
        persona.setTwtterUrl(dtopersona.getTwtterUrl());
        persona.setInstagramUrl(dtopersona.getInstagramUrl());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImgUrl(dtopersona.getImgUrl());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
