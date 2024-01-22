package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.ProductoEntity;
import com.uaemex.fiuaemex.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //identifica como repository a la clase productodaoimplements
public class ProductoDaoImpl implements ProductoDao {

    @Autowired //crea la instancia de mi objeto solo cuando lo necesite o lo mande llamar
    private ProductoRepository productoRepository; //esto es una inyeccion de interfaces

    @Override
    public ProductoEntity findByProductId(long id) {

        return productoRepository.findById(id);
    }

    @Override
    public long save(ProductoEntity productoEntity) {
        long id;
        ProductoEntity productoId = this.productoRepository.save(productoEntity);
        id = productoId.getId();

        return id;
    }

    @Override
    public boolean existById(long id) {
        return this.productoRepository.existsById(id);
    }

    @Override
    public ProductoEntity buscarProductoId(long id) {

        return this.productoRepository.findById(id);
    }

    @Override
    public String delete(ProductoEntity productoEntity) {
        this.productoRepository.delete(productoEntity);
        return "Producto Eliminado correctamente";

    }

    @Override
    public List<ProductoEntity> getListaProductos() {

        return this.productoRepository.findAll();
    }

}
