package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dao.PersonaDao;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceMensaje;
import com.uaemex.fiuaemex.dto.InsertaPersonaDto;
import com.uaemex.fiuaemex.dto.ListadoPersonasDto;
import com.uaemex.fiuaemex.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public PersonaEntity buscarPeronaPorId(long id) {

        return this.personaDao.buscarPeronaPorId(id);
    }

    @Override
    public ConsumeOrProduceLongDto insertarPersona(InsertaPersonaDto insertaPersonaDto) {
        ConsumeOrProduceLongDto consumeOrProduceLongDto = new ConsumeOrProduceLongDto();
        PersonaEntity personaEntity;

        if (insertaPersonaDto.getId() == 0) {
            personaEntity = new PersonaEntity();
        } else {
            personaEntity = this.personaDao.buscarPeronaPorId(insertaPersonaDto.getId());
        }
        
        personaEntity.setApellidosPersona(insertaPersonaDto.getApellidos());
        personaEntity.setNombrePersona(insertaPersonaDto.getNombre());
        personaEntity.setFechaNacimientoPersona(insertaPersonaDto.getFechaNacimiento());
        personaEntity.setSexoPersona(insertaPersonaDto.getSexo());
        long id = this.personaDao.save(personaEntity);
        consumeOrProduceLongDto.setValue(id);
        
        return consumeOrProduceLongDto;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePersona(long id) {
        return this.personaDao.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListadoPersonasDto> getListaPersonas() {
        List<ListadoPersonasDto> listadoPersonasDto = new ArrayList<>();
        ListadoPersonasDto personaDto;
        List<PersonaEntity>listaPersonaEntity = this.personaDao.getListaPersonas();
        
        for (PersonaEntity personaEntity : listaPersonaEntity) {
            personaDto = new ListadoPersonasDto();
            personaDto.setId(personaEntity.getId());
            personaDto.setNombre(personaEntity.getNombrePersona());
            personaDto.setApellidos(personaEntity.getApellidosPersona());
            listadoPersonasDto.add(personaDto);
        }
        
        
        
        return listadoPersonasDto;
    }

    @Override
    public ConsumeOrProduceMensaje deletePersona(ConsumeOrProduceLongDto consumeOrProduceLongDto) {
        ConsumeOrProduceMensaje consumeOrProduceMensaje = new ConsumeOrProduceMensaje();
           PersonaEntity personaEntity = this.personaDao.buscarPeronaPorId(consumeOrProduceLongDto.getValue());
           String mensaje = personaDao.delete(personaEntity);
           consumeOrProduceMensaje.setMensaje(mensaje);
        return consumeOrProduceMensaje;
    }

}
