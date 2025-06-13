package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "gama_producto")
public class GamaProducto {
    @Id
    private String gama;
    private String descripcionTexto;
    // Otros campos...
}

