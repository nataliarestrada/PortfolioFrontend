/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Controller;

import com.portfolio.PortfolioBackEnd.Dto.ProyectoDto;
import com.portfolio.PortfolioBackEnd.Entity.Persona;
import com.portfolio.PortfolioBackEnd.Entity.Proyecto;
import com.portfolio.PortfolioBackEnd.Repository.PersonaRepositority;
import com.portfolio.PortfolioBackEnd.Security.Controller.Mensaje;
import com.portfolio.PortfolioBackEnd.Service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService sPro;
    @Autowired
    PersonaRepositority rPerso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sPro.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sPro.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sPro.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPro.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sPro.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto dtopro){      
        if(StringUtils.isBlank(dtopro.getNombreProye()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona perso = rPerso.findById(dtopro.getPersonaId()).orElse(null);
        Proyecto pro = new Proyecto(perso, dtopro.getNombreProye(), dtopro.getDescripcionProye()
                , dtopro.getImgUrl(), dtopro.getRepoUrl());
        sPro.save(pro);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto dtopro){
        //Validamos si existe el ID
        if(!sPro.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombreProye()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto pro = sPro.getOne(id).get();
        pro.setNombreProye(dtopro.getNombreProye());
        pro.setDescripcionProye(dtopro.getDescripcionProye());
        pro.setImgUrl(dtopro.getImgUrl());
        pro.setRepoUrl(dtopro.getRepoUrl());
        
        sPro.save(pro);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);            
    }
}
