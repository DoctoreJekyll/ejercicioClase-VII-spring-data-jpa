package org.cplcursos.ejercicioclaseviispringweb.DTOs;

import java.time.LocalDate;

public record PedidoDTOLista(
        Integer codigoPedido,
        LocalDate fechaPedido,
        String estado,
        String nombreCliente // Campo obtenido con un JOIN
) {}
