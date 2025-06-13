package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOForm;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.EmpleadoMapper;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmpleadoSrvc {
    private final EmpleadoRepo empleadoRepo;
    private EmpleadoMapper empleadoMapper;

    public EmpleadoSrvc(EmpleadoRepo empleadoRepo, EmpleadoMapper empleadoMapper) {
        this.empleadoRepo = empleadoRepo;
        this.empleadoMapper = empleadoMapper;
    }

    public List<EmpleadoDTOLista> listarTodos() {
        return empleadoRepo.findAllDtos();
    }

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

    public void grabarEmpleado(Empleado emp) {
        empleadoRepo.save(emp);
    }

    public void borrarEmpleado(int id) {
        empleadoRepo.deleteById(id);
    }
}
