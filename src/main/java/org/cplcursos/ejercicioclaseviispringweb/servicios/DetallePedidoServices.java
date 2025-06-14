package org.cplcursos.ejercicioclaseviispringweb.servicios;


import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.DetallePedido;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.DetallePedidoRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetallePedidoServices {
    private final DetallePedidoRepo detallePedidoRepo;

    public void saveDetallePedido(DetallePedido detallePedido){
        detallePedidoRepo.save(detallePedido);
    }

    public void deleteDetallePedido (int id) {
        detallePedidoRepo.deleteById(id);
    }
}
