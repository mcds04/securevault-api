package com.mariacristina.securevault.dto;

public record CredentialResponseDTO(
        Long id,
        String service,
        String username
) {}