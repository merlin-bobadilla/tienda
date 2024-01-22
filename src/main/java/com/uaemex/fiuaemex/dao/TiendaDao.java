
package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.TiendaEntity;
import java.util.List;


public interface TiendaDao {
    public TiendaEntity findTiendaById(long id); //buscar= puede llamarse como quiera solo en la interfaz ya que no esta reservado
    public List<TiendaEntity> findAll();

}
