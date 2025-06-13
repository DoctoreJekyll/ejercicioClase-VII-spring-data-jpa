package org.cplcursos.ejercicioclaseviispringweb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentasEmpleadoDTO {
    private Integer codigoEmpleado;
    private String nombreCompleto;
    private String ciudadOficina;
    private String puesto;
    private BigDecimal ventasGama;
    private String gama;
}
