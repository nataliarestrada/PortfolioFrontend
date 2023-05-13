/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Controller;

import com.portfolio.PortfolioBackEnd.Dto.EducacionDto;
import com.portfolio.PortfolioBackEnd.Entity.Educacion;
import com.portfolio.PortfolioBackEnd.Entity.Persona;
import com.portfolio.PortfolioBackEnd.Repository.PersonaRepositority;
import com.portfolio.PortfolioBackEnd.Security.Controller.Mensaje;
import com.portfolio.PortfolioBackEnd.Service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    EducacionService sEdu;
    @Autowired
    PersonaRepositority rPerso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEdu.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEdu.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEdu.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEdu.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEdu.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto dtoedu){      
        if(StringUtils.isBlank(dtoedu.getTituloEdu()))
            return new ResponseEntity(new Mensaje("El nombre del titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona perso = rPerso.findById(dtoedu.getPersonaId()).orElse(null);
        Educacion edu = new Educacion(perso, dtoedu.getTituloEdu(), dtoedu.getPeriodoEdu()
                ,dtoedu.getInstitucionEdu(), dtoedu.getDescripcionEdu(), dtoedu.getUrlLogoEdu());
        sEdu.save(edu);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto dtoedu){
        //Validamos si existe el ID
        if(!sEdu.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoedu.getTituloEdu()))
            return new ResponseEntity(new Mensaje("El nombre del titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion edu = sEdu.getOne(id).get();
        edu.setTituloEdu(dtoedu.getTituloEdu());
        edu.setPeriodoEdu(dtoedu.getPeriodoEdu());
        edu.setInstitucionEdu(dtoedu.getInstitucionEdu());
        edu.setDescripcionEdu(dtoedu.getDescripcionEdu());
        edu.setUrlLogoEdu(dtoedu.getUrlLogoEdu());
        
        sEdu.save(edu);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);            
    }
}
