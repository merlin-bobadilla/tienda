
package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceMensaje;
import com.uaemex.fiuaemex.dto.InsertaProductoDto;
import com.uaemex.fiuaemex.dto.ListaProductosDto;
import com.uaemex.fiuaemex.entities.ProductoEntity;
import java.util.List;


public interface ProductoService {
    public ProductoEntity findProductById(long id);
     public ConsumeOrProduceLongDto insertarProducto(InsertaProductoDto insertaProductoDto);
     public boolean existeProducto(long id);

    public ConsumeOrProduceMensaje deleteProducto(ConsumeOrProduceLongDto consumeLongDto);

    public List<ListaProductosDto> getListaProductos();
     
}
