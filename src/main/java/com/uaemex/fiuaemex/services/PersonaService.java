
package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceMensaje;
import com.uaemex.fiuaemex.dto.InsertaPersonaDto;
import com.uaemex.fiuaemex.dto.ListadoPersonasDto;
import com.uaemex.fiuaemex.entities.PersonaEntity;
import java.util.List;


public interface PersonaService {
     public PersonaEntity buscarPeronaPorId(long id);
     public ConsumeOrProduceLongDto insertarPersona(InsertaPersonaDto insertaPersonaDto);
     public boolean existePersona(long id);
     public List<ListadoPersonasDto> getListaPersonas();
     
     public ConsumeOrProduceMensaje deletePersona(ConsumeOrProduceLongDto consumeOrProduceLongDto);
}
