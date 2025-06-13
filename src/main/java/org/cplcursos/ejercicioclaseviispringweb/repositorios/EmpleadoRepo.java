package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer> {
    @Query("""
            SELECT e.codigo_empleado, e.nombre, CONCAT(e.apellido1, ' ' ,e.apellido2) AS apellidos,
                   e.email, e.puesto, o.ciudad as ciudad_oficina
            FROM empleado e
            INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
            ORDER BY o.ciudad, e.apellido1, e.nombre
            """)
    List<EmpleadoDTOLista> findAllDtos();  // <-- ejecuta un "SELECT * FROM empleado"

    @Query("""
            SELECT e.codigo_empleado, e.nombre, CONCAT(e.apellido1, ' ', e.apellido2) AS apellidos,
                   e.email, e.puesto
            FROM empleado e
            ORDER BY e.apellido1, e.nombre
            """)
    List<EmpleadoDTOSinCiudad> listaEmpleadosSinCiudad();

    List<Empleado> findAll();

    /*@Query("SELECT * FROM empleado WHERE codigo_empleado = :id")
    Optional<Empleado> findById(@Param("id") int id);*/
    Optional<Empleado> findById(int id);
}
