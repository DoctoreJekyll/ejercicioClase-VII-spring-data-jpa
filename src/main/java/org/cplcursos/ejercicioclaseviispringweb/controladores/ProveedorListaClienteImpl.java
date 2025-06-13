package org.cplcursos.ejercicioclaseviispringweb.controladores;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Cliente;
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
        return List.of("Código", "Nombre", "Teléfono", "Dirección", "Ciudad", "Rep. Vtas.");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Cliente> listaClientes = clienteSrvc.listarTodos();
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        List<Map<String, Object>> mapa =  listaClientes.stream()
                .map(cl -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", cl.getCodigoCliente());
                    map.put("nombre", cl.getNombreCliente());
                    map.put("telefono", cl.getTelefono());
                    map.put("linea_direccion1", cl.getLineaDireccion1());
                    map.put("ciudad", cl.getCiudad());
                    map.put("repVentas", cl.getRepVentas() != null
                            ? cl.getRepVentas().getNombre()
                            : "Sin rep. vtas.");
                    return map;
                }).toList();
        return mapa;
    }

    @Override
    public String getNombreEntidad() {
        return "cliente";
    }
}
