package com.mariacristina.securevault.dto;

public record CredentialRequestDTO(
        String service,
        String username,
        String password
) {}