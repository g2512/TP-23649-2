package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.models.dtos.AccountDTO;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.services.TransferService;
import com.ar.cac.homebanking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    // Generar una instancia del Service (UserService) -> Inyectar una instancia mediante Spring Boot
    @Autowired
    private final TransferService service;

    public TransferController(TransferService service){
        this.service = service;
    }

    // Para cada método HTTP permitido debemos realizar una acción
    // Definir el DTO y el Service (Inyección de Dependencia)

    // CRUD: Crear, Leer, Modificar, Eliminar

    @GetMapping
    public ResponseEntity<List<TransferDTO>> getTransfers(){
        List<TransferDTO> lista = service.getTransfers();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<TransferDTO>getTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransferById(id));
    }

    @PostMapping
    public ResponseEntity<TransferDTO> createTransfer(@RequestBody TransferDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransfer(dto));
        }

@PutMapping(value = "/{id}")
    public ResponseEntity<TransferDTO> updateTransfer(@PathVariable Long id,@RequestBody TransferDTO dto){
    return ResponseEntity.status(HttpStatus.OK).body(service.updateTransfer(id,dto));
        }
@DeleteMapping (value="/{id}")
    public ResponseEntity<String>deleteTransfer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransfer(id));
        }


}
