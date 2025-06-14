package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Producto;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServices {

    private final ProductoRepo productoRepo;

    public List<Producto> findAll(){
        return productoRepo.findAll();
    }

    public void saveProducto (Producto producto){
        productoRepo.save(producto);
    }

    public void deleteProducto (Producto producto){
        productoRepo.delete(producto);
    }
}
