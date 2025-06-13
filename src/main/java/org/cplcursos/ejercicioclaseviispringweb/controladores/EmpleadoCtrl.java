package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOForm;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.servicios.EmpleadoSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/empleados")
public class EmpleadoCtrl {

    private final EmpleadoSrvc empleadoSrvc;

    public EmpleadoCtrl(EmpleadoSrvc empleadoSrvc) {
        this.empleadoSrvc = empleadoSrvc;
    }

    @GetMapping({"", "/"})
    public String mostrarEmpleadosPorOficina(Model modelo) {
        List<EmpleadoDTOLista> listaEmpleados = empleadoSrvc.listarTodos();
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        List<Map<String, Object>> filas = listaEmpleados.stream()
                .map(e -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("codigo_empleado", e.getCodigoEmpleado());
                    map.put("nombre", e.getNombre());
                    map.put("apellidos", e.getApellidos() );
                    //map.put("apellido2", e.getApellido2());
                    map.put("email", e.getEmail());
                    map.put("ciudadOficina", e.getCiudadOficina());
                    map.put("puesto", e.getPuesto());
                    return map;
                }).toList();

        List<String> cabeceras = List.of("Código", "Nombre", "Apellidos", "Correo", "Ciudad", "Puesto");
        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);
        modelo.addAttribute("urlEdicion","empleados/editar/");
        modelo.addAttribute("urlBorrado","empleados/borrar/");

        // Procesamos la lista de empleados para rellenar el Map
        /*Map<String, List<EmpleadoDTOLista>> mapEmpleados = listaEmpleados.stream()
                .collect(Collectors.groupingBy(EmpleadoDTOLista::getCiudadOficina)
                );*/

        return "vistaLista";
    }

    @GetMapping("/nociudad")
    public String listarEmpleadosSinCiudad(Model modelo){
        List<EmpleadoDTOSinCiudad> listaEmpleados = empleadoSrvc.listarEmpleadoSinCiudad();
        List<Map<String, Object>> filas = listaEmpleados.stream()
                .map(e -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("codigo_empleado", e.codigoEmpleado());
                    map.put("nombre", e.nombre());
                    map.put("apellidos", e.apellidos());
                    map.put("email", e.email());
                    map.put("puesto", e.puesto());
                    return map;
                }).toList();

        List<String> cabeceras = List.of("Código", "Nombre", "Apellidos", "Correo", "Puesto");
        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);
        return "vistaLista";
    }


    @GetMapping("/editar/{id}")
    public String ediatrEmpleado(Model modelo, @PathVariable int id) throws SQLException {
        // Comprobamos si existe el id y, en ese caso, cargamos el empleado. Si no, creamos un DTO vacío
        EmpleadoDTOForm empDTOForm = empleadoSrvc.cargarEmpleado(id);
        modelo.addAttribute("empleado", empDTOForm);
        // Si el DTO está vacío tengo que presentar un mensaje de aviso
        String mensaje = empDTOForm.codigoEmpleado() == 0
            ? "El empleado no existe. Puede crear uno nuevo"
            : "";
        modelo.addAttribute("mensaje", mensaje);
        return "nuevoEmpleado";
    }

    @GetMapping("nuevo")
    public String nuevoEmpleado(Model modelo){
        // tenemos que devolver el formulario de alta de un nuevo empleado
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleado", empleado);
        return "nuevoEmpleado";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(RedirectAttributes redirAttr, Empleado empleado) {
        empleadoSrvc.grabarEmpleado(empleado);
        redirAttr.addFlashAttribute("mensaje", "El empleado se ha guardado con éxito.");
        return "redirect:/empleados";
    }

    @GetMapping("/borrar/{id}")
    public String borrarEmpleado(RedirectAttributes redirAttr, @PathVariable int id) {
        empleadoSrvc.borrarEmpleado(id);
        // Poner mensaje de borrado exitoso
        redirAttr.addFlashAttribute("mensaje", "Empleado borrado satisfactoriamente.");
        redirAttr.addFlashAttribute("clase", "success");
        // volver a la lista de empleados
        return "redirect:/empleados";
    }

    public void mostrarVentasPorEmpleado() {

    }

    private void imprimirEmpleado(EmpleadoDTOLista empleado) {
        System.out.printf("  - %s %s %s (%s) - %s%n",
                empleado.getNombre(),
                //empleado.getApellido1(),
                //empleado.getApellido2() != null ? empleado.getApellido2() : "",
                empleado.getPuesto(),
                empleado.getEmail());
    }

}
