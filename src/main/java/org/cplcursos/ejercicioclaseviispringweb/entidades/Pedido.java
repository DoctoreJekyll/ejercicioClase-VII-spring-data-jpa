package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_esperada")
    private LocalDate fechaEsperada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
