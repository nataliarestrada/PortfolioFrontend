/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Controller;

import com.portfolio.PortfolioBackEnd.Dto.HabilidadDuraDto;
import com.portfolio.PortfolioBackEnd.Entity.HabilidadesDuras;
import com.portfolio.PortfolioBackEnd.Entity.Persona;
import com.portfolio.PortfolioBackEnd.Repository.PersonaRepositority;
import com.portfolio.PortfolioBackEnd.Security.Controller.Mensaje;
import com.portfolio.PortfolioBackEnd.Service.HabilidadDuraService;
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
@RequestMapping("/habidura")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadDuraController {
    @Autowired
    HabilidadDuraService sHD;
    @Autowired
    PersonaRepositority rPerso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesDuras>> list(){
        List<HabilidadesDuras> list = sHD.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesDuras> getById(@PathVariable("id") int id){
        if(!sHD.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadesDuras hd = sHD.getOne(id).get();
        return new ResponseEntity(hd, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHD.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHD.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabilidadDuraDto dtohd){      
        if(StringUtils.isBlank(dtohd.getNombreHD()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona perso = rPerso.findById(dtohd.getPersonaId()).orElse(null);
        HabilidadesDuras hd = new HabilidadesDuras(perso, dtohd.getNombreHD(), dtohd.getPorcentajeHD());
        sHD.save(hd);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadDuraDto dtohd){
        //Validamos si existe el ID
        if(!sHD.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohd.getNombreHD()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabilidadesDuras hd = sHD.getOne(id).get();
        hd.setNombreHD(dtohd.getNombreHD());
        hd.setPorcentajeHD(dtohd.getPorcentajeHD());
        
        sHD.save(hd);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);            
    }
}
