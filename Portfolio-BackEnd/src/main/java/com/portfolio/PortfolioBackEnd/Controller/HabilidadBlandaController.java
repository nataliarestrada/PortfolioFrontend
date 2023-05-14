/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Controller;

import com.portfolio.PortfolioBackEnd.Dto.HabilidadBlandaDto;
import com.portfolio.PortfolioBackEnd.Entity.HabilidadesBlandas;
import com.portfolio.PortfolioBackEnd.Entity.Persona;
import com.portfolio.PortfolioBackEnd.Repository.PersonaRepositority;
import com.portfolio.PortfolioBackEnd.Security.Controller.Mensaje;
import com.portfolio.PortfolioBackEnd.Service.HabilidadBlandaService;
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
@RequestMapping("/habiblanda")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadBlandaController {
    @Autowired
    HabilidadBlandaService sHB;
    @Autowired
    PersonaRepositority rPerso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesBlandas>> list(){
        List<HabilidadesBlandas> list = sHB.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesBlandas> getById(@PathVariable("id") int id){
        if(!sHB.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadesBlandas hb = sHB.getOne(id).get();
        return new ResponseEntity(hb, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHB.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHB.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabilidadBlandaDto dtohb){      
        if(StringUtils.isBlank(dtohb.getNombreHB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona perso = rPerso.findById(dtohb.getPersonaId()).orElse(null);
        HabilidadesBlandas hb = new HabilidadesBlandas(perso, dtohb.getNombreHB(), dtohb.getPorcentajeHB());
        sHB.save(hb);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadBlandaDto dtohb){
        //Validamos si existe el ID
        if(!sHB.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohb.getNombreHB()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        HabilidadesBlandas hb = sHB.getOne(id).get();
        hb.setNombreHB(dtohb.getNombreHB());
        hb.setPorcentajeHB(dtohb.getPorcentajeHB());
        
        sHB.save(hb);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);            
    }
}
