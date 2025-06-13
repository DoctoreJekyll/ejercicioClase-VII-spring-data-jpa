package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;
    @Column(name = "fecha_esperada")
    private LocalDate fechaEsperada;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntregada;
    private String estado;
    private String comentarios;
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;
    // Otros campos...

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<DetallePedido> detalles;
}
