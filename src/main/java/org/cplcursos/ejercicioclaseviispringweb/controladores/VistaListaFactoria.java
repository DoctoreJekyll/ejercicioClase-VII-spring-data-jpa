package org.cplcursos.ejercicioclaseviispringweb.controladores;

/**
 * Permite obtener el proveedor de vista de lista de cada entidad
 */

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class VistaListaFactoria {
    // Esta variable contiene el proveedor de datos -tipo ProveedorLista***Impl- para la vista de lista
    private final Map<String, ProveedorDeLista> mapProveedorLista;

    // Spring inyecta todas las implementaciones de ProveedorDeLista en una lista.
    public VistaListaFactoria(List<ProveedorDeLista> proveedoresDeDatosParaLaVistaLista) {
        // Creamos un mapa donde la clave es el nombre de la entidad y el valor es el proveedor.
        this.mapProveedorLista = proveedoresDeDatosParaLaVistaLista.stream()
                .collect(Collectors.toMap(ProveedorDeLista::getNombreEntidad, Function.identity()));
    }

    public Optional<ProveedorDeLista> getProveedor(String nombreEntidad) {
        return Optional.ofNullable(mapProveedorLista.get(nombreEntidad));
    }
}
