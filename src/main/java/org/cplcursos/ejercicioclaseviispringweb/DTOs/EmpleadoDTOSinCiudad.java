package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record EmpleadoDTOSinCiudad(
        int codigoEmpleado,
        String nombre,
        String apellidos,
        String email,
        String puesto
) {
}
