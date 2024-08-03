package hn.unah.lenguajes.creditos.modelos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "prestamos")

public class prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoprestamo")
    private Long codigoPrestamo;

    @Column(name = "fechaapertura")
    private Date fechaApertura;

    private Double monto;

    private Double cuota;

    private int plazo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "prestamos", cascade = CascadeType.ALL)
    private List<cuotas> cuotas;

}