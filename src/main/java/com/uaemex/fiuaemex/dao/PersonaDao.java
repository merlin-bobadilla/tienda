package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.PersonaEntity;
import java.util.List;

public interface PersonaDao {

    public PersonaEntity buscarPeronaPorId(long id); //buscar= puede llamarse como quiera solo en la interfaz ya que no esta reservado 
    public long save(PersonaEntity personaEntity);
    public boolean existsById(long id); 
    public List<PersonaEntity> getListaPersonas();
    public String delete(PersonaEntity personaEntity);

}
