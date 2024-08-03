package hn.unah.lenguajes.creditos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.creditos.modelos.cliente;
import hn.unah.lenguajes.creditos.servicios.clienteServicio;

@RestController
@RequestMapping("/api/cliente")
public class clienteControlador {

    @Autowired
    private clienteServicio clienteServicio;

    @GetMapping("/obtener/todos")
    public List<cliente> todosClientes() {
        return this.clienteServicio.obtenerTodos();
    }

    @PostMapping("/crear/nuevo")
    public cliente crearCliente(@RequestBody cliente nvoCliente) {
        return clienteServicio.crearNuevoCliente(nvoCliente);
    }

}
