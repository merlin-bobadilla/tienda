package com.uaemex.fiuaemex.repository;

import com.uaemex.fiuaemex.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

        public PersonaEntity findById(long id);
        
}
