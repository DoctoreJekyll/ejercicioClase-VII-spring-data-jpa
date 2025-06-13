package org.cplcursos.ejercicioclaseviispringweb.repositorios;


import org.cplcursos.ejercicioclaseviispringweb.entidades.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta interfaz publica los métodos que se usarán
 */
@Repository
public interface OficinaRepo extends JpaRepository<Oficina, String> {
    List<Oficina> listaOficinas();
    String ciudadOficina(String codigoOficina);

}
