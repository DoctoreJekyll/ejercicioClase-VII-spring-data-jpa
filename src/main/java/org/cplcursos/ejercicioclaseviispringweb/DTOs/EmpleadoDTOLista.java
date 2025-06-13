package org.cplcursos.ejercicioclaseviispringweb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTOLista {
    private int codigoEmpleado;
    private String nombre;
    private String apellidos;
    private String email;
    private String ciudadOficina;
    private String puesto;
}
