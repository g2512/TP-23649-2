package com.ar.cac.homebanking.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class TransferDTO {
    private Long id;
    private BigDecimal monto;

    private String cbu_origen;

    private String cbu_destino;

    private String fecha;
}
