package hn.unah.lenguajes.creditos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.creditos.modelos.cliente;
//import hn.unah.lenguajes.creditos.modelos.cuotas;
import hn.unah.lenguajes.creditos.modelos.prestamos;
import hn.unah.lenguajes.creditos.repositorios.clienteRepositorio;

@Service

public class clienteServicio {

    @Autowired
    private clienteRepositorio clienteRepositorio;

    public List<cliente> obtenerTodos() {
        return this.clienteRepositorio.findAll();
    }

    public cliente crearNuevoCliente(cliente nvoCliente) {
        if (this.clienteRepositorio.existsById(nvoCliente.getDni())) {
            return null;
        }

        List<prestamos> prestamos = nvoCliente.getPrestamos();
        if (prestamos != null) {
            for (prestamos prestamo : prestamos) {
                prestamo.setCliente(nvoCliente);
                prestamo.setCuota(
                        ((prestamo.getMonto() * 0.09) * Math.pow((1 + 0.09), 60)) / ((Math.pow((1 + 0.09), 60)) - 1));

            }

            // *cuotas cuotas = prestamos.getCuota();
            /*
             * if (cuotas != null) {
             * for (prestamos prestamo : prestamos) {
             * int contar = 0;
             * prestamo.setCliente(nvoCliente);
             * 
             * 
             * }
             * }
             */
        }

        return this.clienteRepositorio.save(nvoCliente);
    }
}
