package com.portfolio.PortfolioBackEnd.Interface;

import com.portfolio.PortfolioBackEnd.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //traer lista de presonas
    public List<Persona> getPersona();
    
    //Guardar un obj tipo persona
    public void savePersona(Persona persona);
    
    //Elimina un obj pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);
}
