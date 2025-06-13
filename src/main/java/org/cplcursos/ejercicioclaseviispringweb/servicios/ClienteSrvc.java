package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Cliente;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteSrvc {

    private final ClienteRepo clienteRepo;

    public List<Cliente> listarTodos(){
        return clienteRepo.finAllDTOs();
    }

}
