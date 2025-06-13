package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.entidades.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.PedidoRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidoRepo pedidoRepo;

    public PedidosController(PedidoRepo pedidoRepo){
        this.pedidoRepo = pedidoRepo;
    }

    @GetMapping({"","/"})
    public String mostrarPedidos(Model model){
        List<Pedido> pedidos = pedidoRepo.findAll();
        List<String> cabeceras = List.of("ID", "NOMBRE", "GAMA","DIMENSIONES","PROVEEDOR", "DESCRIPCION",
        "STOCK","PRECIO VENTA","PRECIO PROVEEDOR");

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("cabeceras", cabeceras);

        return "vistaPedidos";
    }


}
