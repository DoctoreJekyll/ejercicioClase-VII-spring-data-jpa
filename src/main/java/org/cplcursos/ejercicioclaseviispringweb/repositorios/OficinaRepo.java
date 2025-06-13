package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.entidades.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz publica los métodos que se usarán
 */
@Repository
public interface OficinaRepo extends JpaRepository<Oficina, String> {
}
