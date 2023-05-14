/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 1, max = 100, message = "no cumple con la longitud")
    private String nombre;
    private String ocupacion;
    @Size(max = 500, message = "excedio la longitud")
    private String bannerUrl;
    private String email;
    @Size(max = 500, message = "excedio la longitud")
    private String linkedinUrl;
    @Size(max = 500, message = "excedio la longitud")
    private String githubUrl;
    @Size(max = 500, message = "excedio la longitud")
    private String facebookUrl;
    @Size(max = 500, message = "excedio la longitud")
    private String twtterUrl;
    @Size(max = 500, message = "excedio la longitud")
    private String instagramUrl;
    @Size(max = 500, message = "excedio la longitud")
    private String descripcion;
    @Size(max = 500, message = "excedio la longitud")
    private String imgUrl;
    
    
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educaciones;
    
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    @OneToMany(mappedBy = "persona")
    private List<HabilidadesDuras> habilidadD;
    
    @OneToMany(mappedBy = "persona")
    private List<HabilidadesBlandas> habilidadB;
    
    //constructor

    public Persona() {
    }

    //para edicion
    public Persona(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String facebookUrl, String twtterUrl, String instagramUrl, String descripcion, String imgUrl) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.facebookUrl = facebookUrl;
        this.twtterUrl = twtterUrl;
        this.instagramUrl = instagramUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }

    public Persona(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String facebookUrl, String twtterUrl, String instagramUrl, String descripcion, String imgUrl, List<Educacion> educaciones, List<Experiencia> experiencias, List<Proyecto> proyectos, List<HabilidadesDuras> habilidadD, List<HabilidadesBlandas> habilidadB) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.bannerUrl = bannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.facebookUrl = facebookUrl;
        this.twtterUrl = twtterUrl;
        this.instagramUrl = instagramUrl;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.proyectos = proyectos;
        this.habilidadD = habilidadD;
        this.habilidadB = habilidadB;
    }

}
