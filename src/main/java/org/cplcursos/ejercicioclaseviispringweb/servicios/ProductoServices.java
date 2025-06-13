package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServices {

    private final ProductoRepo productoRepo;

}
