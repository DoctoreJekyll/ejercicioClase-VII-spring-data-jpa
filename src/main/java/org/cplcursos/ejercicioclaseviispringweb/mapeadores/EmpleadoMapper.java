package org.cplcursos.ejercicioclaseviispringweb.mapeadores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOForm;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class EmpleadoMapper {

    public EmpleadoDTOLista toDTO(ResultSet rs, int rowNum) throws SQLException {
        EmpleadoDTOLista empleDTO = new EmpleadoDTOLista();
        empleDTO.setCodigoEmpleado(rs.getInt("codigo_empleado"));
        empleDTO.setNombre(rs.getString("nombre"));
        empleDTO.setApellidos(rs.getString("apellido1") +" " +rs.getString("apellido2"));
        //empleDTO.setApellido2(rs.getString("apellido2"));
        empleDTO.setEmail(rs.getString("email"));
        empleDTO.setPuesto(rs.getString("puesto"));
        // necesitamos obtener la ciudad de su oficina
        empleDTO.setCiudadOficina(rs.getString("ciudad_oficina"));
        return empleDTO;
    }

    public EmpleadoDTOForm toDTOForm(Empleado empleado) throws SQLException {
        return new EmpleadoDTOForm(
                empleado.getCodigoEmpleado(),
                empleado.getNombre(),
                empleado.getApellido1(),
                empleado.getApellido2(),
                empleado.getExtension(),
                empleado.getEmail(),
                empleado.getCodigoOficina(),
                empleado.getCodigoJefe(),
                empleado.getPuesto());
    }

    public Empleado toEntity(EmpleadoDTOForm empDTO) throws SQLException {
        return new Empleado(
                empDTO.codigoEmpleado(),
                empDTO.nombre(),
                empDTO.apellido1(),
                empDTO.apellido2(),
                empDTO.extension(),
                empDTO.email(),
                empDTO.codigoOficina(),
                empDTO.codigoJefe(),
                empDTO.puesto()
        );
    }

    public EmpleadoDTOForm toDTOFormVacio() {
        return new EmpleadoDTOForm(0, "","","","","","",0,"");
    }
}
