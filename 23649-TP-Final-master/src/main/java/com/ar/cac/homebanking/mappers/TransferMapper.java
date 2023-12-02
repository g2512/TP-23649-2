package com.ar.cac.homebanking.mappers;

import com.ar.cac.homebanking.models.Transfer;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    // Metodos para transformar objetos

    public  TransferDTO transferToDto(Transfer transfer){
        TransferDTO dto = new TransferDTO();
        dto.setMonto(transfer.getMonto());
        dto.setCbu_origen(transfer.getCbu_origen());
        dto.setCbu_destino(transfer.getCbu_destino());
        dto.setFecha(transfer.getFecha());
        dto.setId(transfer.getId());
        return dto;
    }

    public  Transfer dtoToTransfer(TransferDTO dto){
        Transfer transfer = new Transfer();
        transfer.setMonto(dto.getMonto());
        transfer.setCbu_origen(dto.getCbu_origen());
        transfer.setCbu_destino(dto.getCbu_destino());
        transfer.setFecha(dto.getFecha());
        return transfer;
    }

}
