package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoSrvc {

    private final PedidoRepo pedidoRepo;

    public List<PedidoDTOLista> listarTodos() {
        return pedidoRepo.findAllDTOs();
    }
}
