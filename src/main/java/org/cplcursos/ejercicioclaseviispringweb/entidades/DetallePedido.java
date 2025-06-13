package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_pedido")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetallePedido {

    //Esto hace que "id" sea igual a la clave compuesta que hemos creado en la clase DetallePedidoID
    @EmbeddedId
    private DetallePedidoId id;


    @ManyToOne
    @MapsId("codigoPedido") // indica que esta parte del ID es un FK
    @JoinColumn(name = "codigo_pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("codigoProducto")
    @JoinColumn(name = "codigo_producto")
    private Producto producto;


    //Estos serian todos los campos adicionales que lleva la tabla intermedia
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unidad")
    private double precioUnidad;

    @Column(name = "numero_linea")
    private short numeroLinea;
}

