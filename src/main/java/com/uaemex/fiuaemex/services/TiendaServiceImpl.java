
package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dao.TiendaDao;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongStringDto;
import com.uaemex.fiuaemex.dto.ReporteTotalDto;
import com.uaemex.fiuaemex.entities.TiendaEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiendaServiceImpl implements TiendaService{
    
    @Autowired
    private TiendaDao tiendaDao;

    @Override
    @Transactional(readOnly = true)
    public TiendaEntity findTiendaById(long id) {
            
        return tiendaDao.findTiendaById(id);
    }

    @Override
    public List<ReporteTotalDto> getReporteTotal() {
        List <ReporteTotalDto> reportesTotalDto = new ArrayList<>();
        ReporteTotalDto reporteTotalDto;
        List<TiendaEntity> tiendasDao = this.tiendaDao.findAll();
        ConsumeOrProduceLongStringDto tienda;
        ConsumeOrProduceLongStringDto persona;
        ConsumeOrProduceLongStringDto producto;
        List<ConsumeOrProduceLongStringDto> personas = new ArrayList<>();
        List<ConsumeOrProduceLongStringDto> productos = new ArrayList<>();
        for (TiendaEntity tiendaEntity : tiendasDao) {
            reporteTotalDto = new ReporteTotalDto();
           // if(tiendaEntity.getId()== 3){
                tienda = new ConsumeOrProduceLongStringDto();
                tienda.setKey(tiendaEntity.getId());
                tienda.setValue(tiendaEntity.getNombre());
                producto = new ConsumeOrProduceLongStringDto();
                producto.setKey(tiendaEntity.getProducto().getId());
                producto.setValue(tiendaEntity.getProducto().getNombreProducto());
                productos.add(producto);
                reporteTotalDto.setProductos(productos);
                persona = new ConsumeOrProduceLongStringDto();
                persona.setKey(tiendaEntity.getPersona().getId());
                persona.setValue(tiendaEntity.getPersona().getNombrePersona());
                personas.add(persona);
                reporteTotalDto.setPersonas(personas);
                reporteTotalDto.setTienda(tienda);
                
                reportesTotalDto.add(reporteTotalDto);
          //  }
          
            
        }
        return reportesTotalDto;
    }
    
}
