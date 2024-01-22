
package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dto.ReporteTotalDto;
import com.uaemex.fiuaemex.entities.TiendaEntity;
import java.util.List;


public interface TiendaService {
    public TiendaEntity findTiendaById(long id);
    public List<ReporteTotalDto> getReporteTotal();
}
