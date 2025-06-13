package org.cplcursos.ejercicioclaseviispringweb.controladores;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.servicios.ClienteSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor  // Esta anotación crea el constructo inyectando las variables privadas etiquetadas como FINAL
public class ProveedorListaClienteImpl implements ProveedorDeLista{
    private final ClienteSrvc clienteSrvc;

    @Override
    public String getTitulo() {
        return "Lista de clientes";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Código", "Nombre", "Teléfono", "Dirección", "Ciudad");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<ClienteDTOLista> listaClientes = clienteSrvc.listarTodos();
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        return listaClientes.stream()
                .map(cl -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", cl.codigoCliente());
                    map.put("nombre", cl.nombreCliente());
                    map.put("telefono", cl.telefono());
                    map.put("linea_direccion1", cl.lineaDireccion1());
                    map.put("ciudad", cl.ciudad());
                    return map;
                }).toList();
    }

    @Override
    public String getNombreEntidad() {
        return "cliente";
    }
}
