package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoSrvc {
    private final EmpleadoRepo empleadoRepo;
    //private EmpleadoMapper empleadoMapper;

    public EmpleadoSrvc(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
        //this.empleadoMapper = empleadoMapper;
    }

    public List<Empleado> listarTodos() {
        return empleadoRepo.findAll();
    }
/*
    public List<EmpleadoDTOSinCiudad> listarEmpleadoSinCiudad() {
        return empleadoRepo.listaEmpleadosSinCiudad();
    }

    public EmpleadoDTOForm cargarEmpleado(int id) {
        return empleadoRepo.findById(id)
                .map(emp -> {
                    try {
                        return empleadoMapper.toDTOForm(emp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> empleadoMapper.toDTOFormVacio());
    }
*/
    public void grabarEmpleado(Empleado emp) {
        empleadoRepo.save(emp);
    }

    public void borrarEmpleado(int id) {
        empleadoRepo.deleteById(id);
    }
}
