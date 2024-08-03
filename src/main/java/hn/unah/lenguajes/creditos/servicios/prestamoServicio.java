package hn.unah.lenguajes.creditos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.creditos.modelos.prestamos;
import hn.unah.lenguajes.creditos.repositorios.clienteRepositorio;
import hn.unah.lenguajes.creditos.repositorios.prestamoRepositorio;

@Service

public class prestamoServicio {

    @Autowired
    private prestamoRepositorio prestamoRepositorio;

    @Autowired
    private clienteRepositorio clienteRepositorio;

    public prestamos asociarPrestamoMaestro(String dni, prestamos prestamo) {
        if (this.clienteRepositorio.existsById(dni)) {
            prestamo.setCliente(this.clienteRepositorio.findById(dni).get());
            prestamo.setCuota(
                    ((prestamo.getMonto() * 0.09) * Math.pow((1 + 0.09), 60)) / ((Math.pow((1 + 0.09), 60)) - 1));
            return this.prestamoRepositorio.save(prestamo);
        }
        return null;
    }

    public prestamos buscarPorCodigo(Long codigoPrestamo) {
        if (this.prestamoRepositorio.existsById(codigoPrestamo)) {
            return this.prestamoRepositorio.getById(codigoPrestamo);
        }
        return null;
    }

}
