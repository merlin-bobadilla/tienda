
package com.uaemex.fiuaemex.repository;

import com.uaemex.fiuaemex.entities.TiendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TiendaRepository extends JpaRepository<TiendaEntity, Long>{
    public TiendaEntity findById (long id);
}
