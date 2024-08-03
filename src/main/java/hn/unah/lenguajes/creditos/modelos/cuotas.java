package hn.unah.lenguajes.creditos.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuotas")

public class cuotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocuota")
    private Long codigoCuota;

    private int mes;

    private Double interes;

    private Double capital;

    private Double saldo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigoprestamo", referencedColumnName = "codigoprestamo")
    private prestamos prestamos;

}