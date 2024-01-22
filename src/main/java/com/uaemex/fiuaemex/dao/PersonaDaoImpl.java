package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.PersonaEntity;
import com.uaemex.fiuaemex.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //identifica como repository
public class PersonaDaoImpl implements PersonaDao { //implementa la interfaz del metodo dao

    @Autowired //crea la instancia de mi objeto solo cuando lo necesite o lo mande llamar
    private PersonaRepository personaRepository; //esto es una inyeccion de interfaces

    @Override
    public PersonaEntity buscarPeronaPorId(long id) {
       //PersonaEntity personaEntity = personaRepository.findById(id);
       //return personaEntity;
        
        return this.personaRepository.findById(id);
    }

    @Override
    public long save(PersonaEntity personaEntity) {
        long id;
        PersonaEntity personaId = this.personaRepository.save(personaEntity);
        id = personaId.getId();
        return id;
    }

    @Override
    public boolean existsById(long id) {
        return this.personaRepository.existsById(id);
    }

    @Override
    public List<PersonaEntity> getListaPersonas() {
        
        return this.personaRepository.findAll();
    }

    @Override
    public String delete(PersonaEntity personaEntity) {
        this.personaRepository.delete(personaEntity);
        return "Persona Eliminada correctamente";
    }

}
