package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.GamaRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamaServices {

    private final GamaRepo gamaRepo;



}
