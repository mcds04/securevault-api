package com.mariacristina.securevault.service;

import com.mariacristina.securevault.dto.CredentialRequestDTO;
import com.mariacristina.securevault.dto.CredentialResponseDTO;
import com.mariacristina.securevault.entity.Credential;
import com.mariacristina.securevault.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CredentialService {

    @Autowired
    private CredentialRepository repository;

    @Autowired
    private CryptoService cryptoService;

    // 1. SALVAR (Criptografando a senha)
    public CredentialResponseDTO create(CredentialRequestDTO dto) throws Exception {
        Credential credential = new Credential();
        credential.setService(dto.service());
        credential.setUsername(dto.username());

        // AQUI A MÁGICA: A senha entra "123" e vira "x8s7d8..."
        String encryptedPassword = cryptoService.encrypt(dto.password());
        credential.setPassword(encryptedPassword);

        repository.save(credential);

        return new CredentialResponseDTO(
                credential.getId(),
                credential.getService(),
                credential.getUsername()
        );
    }

    // 2. LISTAR TUDO (Sem mostrar senhas)
    public List<CredentialResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(c -> new CredentialResponseDTO(c.getId(), c.getService(), c.getUsername()))
                .collect(Collectors.toList());
    }

    // 3. RECUPERAR SENHA (Descriptografar)
    public String getDecryptedPassword(Long id) throws Exception {
        Credential credential = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credential not found"));

        // Descriptografa a senha para o usuário ver
        return cryptoService.decrypt(credential.getPassword());
    }
}