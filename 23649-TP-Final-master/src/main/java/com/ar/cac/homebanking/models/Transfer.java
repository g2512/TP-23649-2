package com.ar.cac.homebanking.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "transfers")
@Getter
@Setter
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "cta_origen")
    private String cbu_origen;

    @Column(name = "cta_destino")
    private String cbu_destino;

    @Column(name = "fecha")
    private String fecha;





}
