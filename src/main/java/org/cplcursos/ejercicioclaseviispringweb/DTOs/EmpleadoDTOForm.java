package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record EmpleadoDTOForm(
        Integer codigoEmpleado,
        String nombre,
        String apellido1,
        String apellido2,
        String extension,
        String email,
        String codigoOficina,
        Integer codigoJefe,  // Puede ser nul,
        String puesto) {}
