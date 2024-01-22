
package com.uaemex.fiuaemex.dto;

import java.util.List;


public class ReporteTotalDto {
    private ConsumeOrProduceLongStringDto tienda;
    private List<ConsumeOrProduceLongStringDto> personas;
   private List<ConsumeOrProduceLongStringDto> productos; 

    public ConsumeOrProduceLongStringDto getTienda() {
        return tienda;
    }

    public void setTienda(ConsumeOrProduceLongStringDto tienda) {
        this.tienda = tienda;
    }

    public List<ConsumeOrProduceLongStringDto> getPersonas() {
        return personas;
    }

    public void setPersonas(List<ConsumeOrProduceLongStringDto> personas) {
        this.personas = personas;
    }

    public List<ConsumeOrProduceLongStringDto> getProductos() {
        return productos;
    }

    public void setProductos(List<ConsumeOrProduceLongStringDto> productos) {
        this.productos = productos;
    }

  
   
}
