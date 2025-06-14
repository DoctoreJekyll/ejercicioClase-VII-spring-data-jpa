package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.entidades.DetallePedido;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.entidades.Producto;
import org.cplcursos.ejercicioclaseviispringweb.servicios.DetallePedidoServices;
import org.cplcursos.ejercicioclaseviispringweb.servicios.PedidoServices;
import org.cplcursos.ejercicioclaseviispringweb.servicios.ProductoServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidoServices pedidoServices;
    private final DetallePedidoServices detallePedidoServices;
    private final ProductoServices productoServices;

    public PedidosController(PedidoServices pedidoServices,  DetallePedidoServices detallePedidoServices, ProductoServices productoServices) {
        this.pedidoServices = pedidoServices;
        this.detallePedidoServices = detallePedidoServices;
        this.productoServices = productoServices;
    }

    @GetMapping({"","/"})
    public String mostrarPedidos(Model model){
        List<Pedido> pedidos = pedidoServices.getPedidos();
        List<String> cabeceras = List.of("ID", "NOMBRE", "GAMA","DIMENSIONES","PROVEEDOR", "DESCRIPCION",
        "STOCK","PRECIO VENTA","PRECIO PROVEEDOR");

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("cabeceras", cabeceras);

        return "vistaPedidos";
    }

    @GetMapping("form/nuevo")
    public String nuevoPedido (Model model) {
        Pedido pedido = new Pedido();

        DetallePedido detallePedido = new DetallePedido();
        pedido.setDetalles(List.of(detallePedido));

        List<Producto> productos = productoServices.findAll();

        model.addAttribute("pedido", pedido);
        model.addAttribute("producto", productos);
        return "formPedido";
    }

    @GetMapping("editar/{id}")
    public String editarPedido (Model model, @PathVariable int id, RedirectAttributes redirectAttributes) {
        //Pasos generales para montar un endpoint
        //1.Crear
        Optional<Pedido> pedido = pedidoServices.getPedidoById(id);


        if(pedido.isPresent()){
            //2.Rellenar o enviar
            boolean entregado = isEntregado(pedido);

            model.addAttribute("pedido", pedido.get());
            model.addAttribute("entregado", entregado);
        } else {
            redirectAttributes.addFlashAttribute("error", "Pedido no existe :) a tu casa crack ");
            return "redirect:/pedidos";
        }

        //3.Devolver
        return "formPedido";
    }

    private boolean isEntregado(Optional<Pedido> pedido) {
        boolean entregado = false;
        Pedido pedidoEditar = pedido.get();
        if(pedidoEditar.getFechaEntregada() != null)
        {
            entregado = true;
        }else{
            entregado = false;
        }
        return entregado;
    }

    // ESTO ES SOLO LA ACCIÓN DE GUARDAR !!! NO RELLENO
    @PostMapping("/guardar")
    public String guardarPedido (@ModelAttribute Pedido pedido){
        pedidoServices.savePedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping ("/borrar/{id}")
    public String borrarPedido (@PathVariable int id) {
        pedidoServices.deletePedido(id);
        return "redirect:/pedidos";
    }


}
