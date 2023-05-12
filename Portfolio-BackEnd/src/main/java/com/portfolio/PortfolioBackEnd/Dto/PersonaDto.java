/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author natal
 */
@Getter @Setter
public class PersonaDto {
    
    private String nombre;
    private String ocupacion;
    private String bannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String facebookUrl;
    private String twtterUrl;
    private String instagramUrl;
    private String descripcion;
    private String imgUrl;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String ocupacion, String bannerUrl, String email, String linkedinUrl, String githubUrl, String facebookUrl, String twtterUrl, String instagramUrl, String descripcion, String imgUrl) {
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
    
    
}
