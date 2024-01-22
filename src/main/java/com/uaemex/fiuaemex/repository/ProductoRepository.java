
package com.uaemex.fiuaemex.repository;


import com.uaemex.fiuaemex.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    public ProductoEntity findById(long id);
}
