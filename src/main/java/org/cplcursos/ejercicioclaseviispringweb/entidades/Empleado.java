package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="empleado")
public class Empleado {
        @Id
        private int codigoEmpleado;
        private String nombre;
        private String apellido1;
        private String apellido2;
        private String extension;
        private String email;
        private String codigoOficina;
        private Integer codigoJefe; // Puede ser null
        private String puesto;

        @OneToMany
        private List<Cliente> clientes;


        public String toString() {
            return "Empleado [codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre + ", apellido1=" + apellido1 +
                    ", apellido2=" + apellido2 + "]";
        }

}
