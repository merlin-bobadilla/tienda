
package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.TiendaEntity;
import com.uaemex.fiuaemex.repository.TiendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //identifica  la clase como repository, le dice a spring que la clase es un repositorio
public class TiendaDaoImpl implements TiendaDao{
    
     @Autowired
     private TiendaRepository tiendaRepository;

    @Override
    public TiendaEntity findTiendaById(long id) {
        
        return this.tiendaRepository.findById(id);
        
        
    }

    @Override
    public List<TiendaEntity> findAll() {
        return this.tiendaRepository.findAll();
    }
    
}
