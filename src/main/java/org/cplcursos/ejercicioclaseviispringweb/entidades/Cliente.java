package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private Integer codigoCliente;
    private String nombreCliente;
    private String telefono;
    private String lineaDireccion1;
    private String ciudad;
    @ManyToOne
    private Empleado repVentas;
    // Otros campos que no se usarán en la lista...
}
