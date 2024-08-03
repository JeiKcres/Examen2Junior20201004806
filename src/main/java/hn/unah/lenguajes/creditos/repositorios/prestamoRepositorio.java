package hn.unah.lenguajes.creditos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.creditos.modelos.prestamos;

@Repository

public interface prestamoRepositorio extends JpaRepository<prestamos, Long> {

}