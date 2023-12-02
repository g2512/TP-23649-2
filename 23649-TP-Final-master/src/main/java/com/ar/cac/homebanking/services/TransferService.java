package com.ar.cac.homebanking.services;

import com.ar.cac.homebanking.exceptions.UserNotExistsException;
import com.ar.cac.homebanking.mappers.AccountMapper;
import com.ar.cac.homebanking.mappers.TransferMapper;
import com.ar.cac.homebanking.models.Account;
import com.ar.cac.homebanking.models.Transfer;
import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import com.ar.cac.homebanking.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransferService {
    // Inyectar una instancia del Repositorio
    @Autowired
    private final TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }
    // Metodos

    public List<TransferDTO> getTransfers() {
        List<Transfer> transfers = repository.findAll();
        return transfers.stream()
                .map(TransferMapper::transferToDto)
                .collect(Collectors.toList());
    }

    public TransferDTO createTransfer(TransferDTO dto) {
        Transfer newTransfer = repository.save(TransferMapper.dtoToTransfer(dto));
        return TransferMapper.transferToDto(newTransfer);

    }

    public TransferDTO getTransferById(Long id) {
        Transfer entity = repository.findById(id).get();
        return TransferMapper.transferToDto(entity);
    }

    public String deleteTransfer(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "La tranasferecia con id: " + id + " ha sido eliminada";
        } else {
            // TODO: REFACTOR create new exception
            throw new UserNotExistsException("La transferencia a eliminar no existe");
        }
    }
    public TransferDTO updateTransfer(Long id, TransferDTO dto) {
        if (repository.existsById(id)) {
            Transfer transferToModify = repository.findById(id).get();
            // Validar qué datos no vienen en null para setearlos al objeto ya creado

            // Logica del Patch
            if (dto.getMonto() != null) {
                transferToModify.setMonto(dto.getMonto());
            }

            if (dto.getCbu_origen() != null) {
                transferToModify.setCbu_origen(dto.getCbu_origen());
            }

            if (dto.getCbu_destino() != null) {
                transferToModify.setCbu_destino(dto.getCbu_destino());
            }

            if (dto.getFecha() != null) {
                transferToModify.setFecha(dto.getFecha());
            }

            Transfer transferModified = repository.save(transferToModify);

            return TransferMapper.transferToDto(transferModified);
        }
        return null;
    }

}