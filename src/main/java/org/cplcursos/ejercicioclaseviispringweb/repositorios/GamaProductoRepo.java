package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.GamaProductoDTOLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GamaProductoRepo extends JpaRepository<GamaProductoRepo, String> {
    @Query("""
        SELECT gama, descripcion_texto
        FROM gama_producto
        ORDER BY gama
        """)
    List<GamaProductoDTOLista> findAllDTOs();
}
