package org.cplcursos.ejercicioclaseviispringweb.servicios;

import lombok.RequiredArgsConstructor;
import org.cplcursos.ejercicioclaseviispringweb.entidades.DetallePedido;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServices {
    private final PedidoRepo pedidoRepo;

    public List<Pedido> getPedidos(){
        return pedidoRepo.findAll();
    }

    public Optional<Pedido> getPedidoById(int id){
        Optional<Pedido> pedido = pedidoRepo.findById(id);
        Pedido emptyPedido = new Pedido();

        if(pedido.isPresent()){
            return pedido;
        }else {
            return Optional.of(emptyPedido);
        }
    }

    public void savePedido(Pedido pedido){
        pedidoRepo.save(pedido);
    }


    public void deletePedido(int id){
        pedidoRepo.deleteById(id);
    }


}
