package org.cplcursos.ejercicioclaseviispringweb.controladores;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lista")
public class VistaListaCtrl {
    private final VistaListaFactoria vistaListaFactoria;

    @GetMapping("/{nombreEntidad}")
    public String mostrarLista(@PathVariable String nombreEntidad, Model model) {
        // Obtenemos las variables a incluir en la plantilla desde el proveedor de datos para lista de cada entidad,
        // que, a su vez, se obtiene desde la factoría a la que pasamos el nombre de la entidad.

        // Si no exisite ese nombre de entidad, se lanza un error
        ProveedorDeLista proveedor = vistaListaFactoria.getProveedor(nombreEntidad)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidad no encontrada: " + nombreEntidad));
        // Añadimos los atributos que se utilizan en la lista
        model.addAttribute("cabeceras", proveedor.getCabeceras());
        model.addAttribute("filas", proveedor.getFilas());
        model.addAttribute("titulo", proveedor.getTitulo());
        return "vistaLista";
    }

}
