package org.cplcursos.ejercicioclaseviispringweb.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "codigo_producto")
    private String id;
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "gama")
    private GamaProducto gama;

    private String dimensiones;
    private String proveedor;
    private String descripcion;
    @Column(name = "cantidad_en_stock")
    private String stock;
    @Column(name = "precio_venta")
    private String precioVenta;
    @Column(name = "precio_proveedor")
    private String precioProveedor;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetallePedido> detalles;
}
