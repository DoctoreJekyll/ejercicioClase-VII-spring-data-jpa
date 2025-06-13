package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pedido")
@Entity
public class Pedido {
    @Id
    private Integer codigoPedido;
    private LocalDate fechaPedido;
    private String estado;
    private Integer codigoCliente;
    // Otros campos...
}
