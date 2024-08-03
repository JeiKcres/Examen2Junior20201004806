package hn.unah.lenguajes.creditos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.creditos.modelos.prestamos;
import hn.unah.lenguajes.creditos.servicios.prestamoServicio;

@RestController
@RequestMapping("/api/prestamos")
public class prestamoControlador {

    @Autowired
    private prestamoServicio prestamoServicio;

    @PostMapping("/asociarCliente/{codigo}")
    public prestamos asociarCliente(@PathVariable(name = "codigo") String dni,
            @RequestBody prestamos prestamos) {
        return this.prestamoServicio.asociarPrestamoMaestro(dni, prestamos);
    }
}
