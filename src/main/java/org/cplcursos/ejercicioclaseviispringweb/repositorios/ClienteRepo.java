package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    // Necesitamos una consulta que devuelva los campos de ClienteDTOLista
    @Query("""
        SELECT codigo_cliente, nombre_cliente, telefono, linea_direccion1, ciudad
        FROM cliente
        ORDER BY nombre_cliente
    """
    )
    List<ClienteDTOLista> finAllDTOs();
}
