package com.mariacristina.securevault.controller;

import com.mariacristina.securevault.dto.CredentialRequestDTO;
import com.mariacristina.securevault.dto.CredentialResponseDTO;
import com.mariacristina.securevault.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialController {

    @Autowired
    private CredentialService service;

    // 1. POST: Cria a senha (já criptografa automático no Service)
    @PostMapping
    public ResponseEntity<CredentialResponseDTO> create(@RequestBody CredentialRequestDTO dto) throws Exception {
        return ResponseEntity.ok(service.create(dto));
    }

    // 2. GET: Lista todas (mas SEM a senha, só o resumo)
    @GetMapping
    public List<CredentialResponseDTO> findAll() {
        return service.findAll();
    }

    // 3. GET por ID: Mostra a senha descriptografada (CUIDADO!)
    @GetMapping("/{id}")
    public ResponseEntity<String> getDecryptedPassword(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.getDecryptedPassword(id));
    }
}