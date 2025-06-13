package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServices {
    private final PedidoRepo pedidoRepo;

    public List<Pedido> getPedidos(){
        return pedidoRepo.findAll();
    }

}
