package com.uaemex.fiuaemex.services;

import com.uaemex.fiuaemex.dao.ProductoDao;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceMensaje;
import com.uaemex.fiuaemex.dto.InsertaProductoDto;
import com.uaemex.fiuaemex.dto.ListaProductosDto;
import com.uaemex.fiuaemex.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public ProductoEntity findProductById(long id) {

        return this.productoDao.findByProductId(id);
    }

    @Override
    public ConsumeOrProduceLongDto insertarProducto(InsertaProductoDto insertaProductoDto) {
        ConsumeOrProduceLongDto consumeOrProduceLongDto = new ConsumeOrProduceLongDto();
        ProductoEntity productoEntity;

        if (insertaProductoDto.getId() == 0) {
            productoEntity = new ProductoEntity();
        } else {
            productoEntity = this.productoDao.findByProductId(insertaProductoDto.getId());
        }

        productoEntity.setNombreProducto(insertaProductoDto.getNombre());
        productoEntity.setCantidadProducto(insertaProductoDto.getCantidad());
        long id = this.productoDao.save(productoEntity);
        consumeOrProduceLongDto.setValue(id);

        return consumeOrProduceLongDto;

    }

    @Override
    public boolean existeProducto(long id) {

        return this.productoDao.existById(id);
    }

    @Override
    public ConsumeOrProduceMensaje deleteProducto(ConsumeOrProduceLongDto consumeLongDto) {
        ConsumeOrProduceMensaje consumeOrProduceMensaje = new ConsumeOrProduceMensaje();
        ProductoEntity productoEntity = this.productoDao.buscarProductoId(consumeLongDto.getValue());
        String mensaje = productoDao.delete(productoEntity);
        consumeOrProduceMensaje.setMensaje(mensaje);
        return consumeOrProduceMensaje;

    }

    @Override
    public List<ListaProductosDto> getListaProductos() {
        List<ListaProductosDto> listadoProductosDto = new ArrayList<>();
        ListaProductosDto productoDto;
        List<ProductoEntity> listaProdcutoEntity = this.productoDao.getListaProductos();

        for (ProductoEntity productoEntity : listaProdcutoEntity) {
            productoDto = new ListaProductosDto();
            productoDto.setId(productoEntity.getId());
            productoDto.setNombre(productoEntity.getNombreProducto());
            productoDto.setCantidad(productoEntity.getCantidadProducto());
            listadoProductosDto.add(productoDto);

        }
        return listadoProductosDto;

    }
}
