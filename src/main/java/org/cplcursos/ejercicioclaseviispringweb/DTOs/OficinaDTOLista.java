package org.cplcursos.ejercicioclaseviispringweb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDTOLista {
    private String codigoOficina;
    private String ciudad;
    private String lineaDireccion1;
    private String lineaDireccion2;
    private String telefono;
}
