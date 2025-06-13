package org.cplcursos.ejercicioclaseviispringweb.servicios;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JardineriaSrvc {

    private final OficinaRepo oficinaRepo;


    public JardineriaSrvc(OficinaRepo oficinaRepo, EmpleadoRepo empleadoRepo) {
        this.oficinaRepo = oficinaRepo;
    }



    public List<OficinaDTOLista> listarOficinas() {
        return oficinaRepo.listaOficinas();
    }



    /*public List<VentasEmpleadoDTO> listarVentasEmpleados() {
        return empleadoRepo.findAllVentas();
    }*/

}
