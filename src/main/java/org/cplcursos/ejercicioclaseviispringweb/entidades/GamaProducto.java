package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "gama")
    private List<Producto> producto;
    // Otros campos...
}

