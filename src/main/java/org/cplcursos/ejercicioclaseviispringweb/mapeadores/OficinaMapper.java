package org.cplcursos.ejercicioclaseviispringweb.mapeadores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Oficina;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OficinaMapper {

    public OficinaDTOLista toDTO(ResultSet rs, int rowNum) throws SQLException {
        OficinaDTOLista ofiDTO = new OficinaDTOLista();
        ofiDTO.setCodigoOficina(rs.getString("codigo_oficina"));
        ofiDTO.setCiudad(rs.getString("ciudad"));
        ofiDTO.setLineaDireccion1(rs.getString("linea_direccion1"));
        ofiDTO.setLineaDireccion2(rs.getString("linea_direccion2"));
        ofiDTO.setTelefono(rs.getString("telefono"));
        return ofiDTO;
    }

    // Mapeo desde Entity a DTO (otra opción de mapeo)
    public OficinaDTOLista entityToDTO(Oficina oficina) {
        if (oficina == null) {
            return null;
        }
        OficinaDTOLista dto = new OficinaDTOLista();
        dto.setCodigoOficina(oficina.getCodigoOficina());
        dto.setCiudad(oficina.getCiudad());
        dto.setLineaDireccion1(oficina.getLineaDireccion1());
        dto.setLineaDireccion2(oficina.getLineaDireccion2());
        dto.setTelefono(oficina.getTelefono());
        return dto;
    }


}
