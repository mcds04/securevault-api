# 🛡️ SecureVault API

API REST desenvolvida com **Java e Spring Boot** focada em Segurança da Informação. O objetivo principal é gerenciar credenciais de usuários garantindo privacidade e proteção de dados sensíveis.

## 🚀 Tecnologias Utilizadas
* **Java 17 & Spring Boot 3**
* **Spring Security:** Proteção contra ataques e gerenciamento de acesso.
* **AES-256 Encryption:** Criptografia avançada para dados em repouso (Encryption at Rest).
* **H2 Database:** Banco de dados em memória para testes rápidos.
* **Swagger UI (OpenAPI):** Documentação interativa e automatizada.
* **Lombok:** Redução de boilerplate code.

---

## 📸 Funcionalidades e Evidências

### 1. Documentação Interativa (Swagger UI)
A API possui documentação completa gerada automaticamente, facilitando o uso por outros desenvolvedores (Developer Experience).

<img width="1328" height="572" alt="SWAGGER 2" src="https://github.com/user-attachments/assets/08881481-8765-4171-bd03-6d7271574fa5" />


### 2. Privacidade por Design (DTO Pattern)
Implementação do padrão **DTO (Data Transfer Object)** para filtrar dados na resposta. Note abaixo que a API retorna o usuário e o serviço, mas **nunca expõe a senha**, nem mesmo a criptografada.

<img width="1273" height="475" alt="GET Credentials - RESPOSTA 200 OK" src="https://github.com/user-attachments/assets/4c6c9d77-e6e5-4153-9576-294911ffca7f" />


### 3. Segurança no Banco de Dados (Criptografia)
As senhas não são salvas em texto plano. Utilizamos um algoritmo de **Criptografia Simétrica (AES)** antes da persistência. Se o banco for invadido, os dados permanecem ilegíveis.

<img width="1233" height="486" alt="Criptografia AES-256" src="https://github.com/user-attachments/assets/eddf30b8-dbdc-44f9-89df-d0047d3995e7" />


---

## 🛠️ Como Rodar este Projeto
1. Clone o repositório.
2. Abra no IntelliJ IDEA ou Eclipse.
3. Execute a classe `SecurevaultApplication.java`.
4. Acesse o Swagger em: `http://localhost:8080/swagger-ui.html`

---
*Desenvolvido por Cristina Sousa* 💻
