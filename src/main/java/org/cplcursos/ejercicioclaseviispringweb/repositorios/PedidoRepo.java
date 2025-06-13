package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import jakarta.transaction.Transactional;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Integer> {
    @Query("""
        SELECT p.codigo_pedido, p.fecha_pedido, p.estado, c.nombre_cliente
        FROM pedido p
        JOIN cliente c ON p.codigo_cliente = c.codigo_cliente
    """)
    List<PedidoDTOLista> findAllDTOs();

    @Transactional
}
