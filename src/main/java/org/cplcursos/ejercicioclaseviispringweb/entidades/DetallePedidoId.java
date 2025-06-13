package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;



//Esto hace que la PK de la tabla intermedia en vez de usar una nueva esta compuesta por estas dos foraneas lo que nos hace una clave compuesta
@Embeddable
public class DetallePedidoId implements Serializable {
    @Column(name = "codigo_pedido")
    private Integer codigoPedido;

    @Column(name = "codigo_producto")
    private String codigoProducto;
}
