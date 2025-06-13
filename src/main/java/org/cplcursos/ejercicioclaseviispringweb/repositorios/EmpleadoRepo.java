package org.cplcursos.ejercicioclaseviispringweb.repositorios;


import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer> {

    List<Empleado> findAllDtos();  // <-- ejecuta un "SELECT * FROM empleado"
    List<Empleado> findAll();
    Optional<Empleado> findById(int id);
}
