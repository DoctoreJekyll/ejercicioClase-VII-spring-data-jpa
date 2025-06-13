package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmpleadoSrvc {
    private final EmpleadoRepo empleadoRepo;

    public EmpleadoSrvc(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> listarTodos() {
        return empleadoRepo.findAllDtos();
    }

    public void grabarEmpleado(Empleado emp) {
        empleadoRepo.save(emp);
    }

    public void borrarEmpleado(int id) {
        empleadoRepo.deleteById(id);
    }
}
