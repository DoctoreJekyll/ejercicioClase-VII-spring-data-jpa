package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.GamaProductoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.GamaProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamaProductoSrvc {
    private final GamaProductoRepo gamaProductoRepo;

    public List<GamaProductoDTOLista> listarTodos() {
        return gamaProductoRepo.findAllDTOs();
    }
}
