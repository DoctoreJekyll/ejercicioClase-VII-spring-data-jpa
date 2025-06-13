package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record ClienteDTOLista(
        Integer codigoCliente,
        String nombreCliente,
        String telefono,
        String lineaDireccion1,
        String ciudad
) {}