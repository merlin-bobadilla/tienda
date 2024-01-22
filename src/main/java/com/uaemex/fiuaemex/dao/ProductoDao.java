
package com.uaemex.fiuaemex.dao;

import com.uaemex.fiuaemex.entities.ProductoEntity;
import java.util.List;


public interface ProductoDao {
    public ProductoEntity findByProductId(long id);
    public long save(ProductoEntity productoEntity);
    public boolean existById(long id);

    public ProductoEntity buscarProductoId(long value);

    public String delete(ProductoEntity productoEntity);

    public List<ProductoEntity> getListaProductos();
    
}
