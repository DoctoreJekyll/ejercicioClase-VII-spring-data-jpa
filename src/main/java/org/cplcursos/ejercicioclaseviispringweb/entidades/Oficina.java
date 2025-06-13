package org.cplcursos.ejercicioclaseviispringweb.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="oficina")
public class Oficina {
    @Id
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    @OneToMany
    private List<Empleado> empleados;

    public String toString(){
        return "Oficina [" + codigoOficina + ", " + ciudad + ", " + pais + ", " + region + ", " +
                codigoPostal + ", " + telefono + ", " + lineaDireccion1 + ", " + lineaDireccion2 + "]";
    }
}
