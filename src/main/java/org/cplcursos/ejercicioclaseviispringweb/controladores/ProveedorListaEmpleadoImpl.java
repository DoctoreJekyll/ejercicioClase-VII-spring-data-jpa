package org.cplcursos.ejercicioclaseviispringweb.controladores;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.servicios.EmpleadoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor  // Esta anotación crea el constructo inyectando las variables privadas etiquetadas como FINAL
public class ProveedorListaEmpleadoImpl implements ProveedorDeLista{
    private final EmpleadoSrvc empleadoSrvc;

    @Override
    public String getTitulo() {
        return "Lista de empleados";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Código", "Nombre", "Apellidos", "Correo", "Ciudad", "Puesto");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Empleado> listaEmpleados = empleadoSrvc.listarTodos();
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        return listaEmpleados.stream()
                .map(emp -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", emp.getCodigoEmpleado());
                    map.put("nombre", emp.getNombre());
                    map.put("apellidos", emp.getApellido1() +  " " + emp.getApellido2());
                    map.put("correo", emp.getEmail());
                    map.put("puesto", emp.getPuesto());
                    //map.put("ciudad", emp.getCiudadOficina());
                    return map;
                }).toList();
    }

    @Override
    public String getNombreEntidad() {
        return "empleado";
    }
}
