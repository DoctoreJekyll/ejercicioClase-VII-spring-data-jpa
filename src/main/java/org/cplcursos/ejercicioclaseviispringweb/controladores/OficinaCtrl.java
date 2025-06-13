package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.servicios.JardineriaSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/oficinas")
public class OficinaCtrl {

    private final JardineriaSrvc jardineriaSrvc;

    public OficinaCtrl(JardineriaSrvc jardineriaSrvc) {
        this.jardineriaSrvc = jardineriaSrvc;
    }

    @GetMapping({"", "/"})
    public String mostrarListaOficinas(Model modelo) {
        List<OficinaDTOLista> listaOficinas = jardineriaSrvc.listarOficinas();
        List<String> cabeceras = List.of("Código", "Ciudad", "Dirección 1", "Dirección 2", "Teléfono");
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        List<Map<String, Object>> filas = listaOficinas.stream()
                        .map(e -> {
                            Map<String, Object> fila = new LinkedHashMap<>();
                            fila.put("codigo_oficina", e.getCodigoOficina());
                            fila.put("ciudad", e.getCiudad());
                            fila.put("lineaDireccion1", e.getLineaDireccion1());
                            fila.put("lineaDireccion2", e.getLineaDireccion2());
                            fila.put("telefono", e.getTelefono());
                            return fila;
                        }).toList();

        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);


        /*
        *************** Ejemplo de diferencia de acceso a cada elemento de una colección ****************
        *                       OJO: ¡NO FORMA PARTE DEL CÓDIGO DEL EJERCICIO!
        *
        * En el Array, accedemos mediante el índice, ya que los elementos se van añadiendo uno tras otro.
        * En el Map se añaden parejas de (clave,valor), por lo que para acceder a cada elemento usamos el nombre de la
        * clave
        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add("Pepe");
        listaNombres.add("Alba");
        listaNombres.add("Ana");
        System.out.println("el nombre del segundo elemento es: " + listaNombres.get(1));

        Map<String, Object> fila = new LinkedHashMap<>();
        fila.put("codigo_oficina", "MAD-ES");
        fila.put("ciudad", "Madrid");
        fila.put("lineaDireccion1","Goya 12");
        System.out.println("el nombre de la oficina es:" + (String) fila.get("codigo_oficina"));
        */

        return "vistaLista";
    }
}
