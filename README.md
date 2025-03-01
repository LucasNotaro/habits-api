# Habits API

API RESTful para gerenciamento de hábitos, desenvolvida com Java 17 e Spring Boot 3.  
Projeto inspirado no desafio técnico da **Santander Dev Week 2023**, adaptado para o tema de hábitos saudáveis.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI (Springdoc)
- Lombok
- Maven

---

## 🧱 Estrutura do Projeto

- `controller`: Camada de entrada (endpoints)
- `service`: Lógica de negócio
- `service.impl`: Implementações de serviço
- `domain.model`: Entidades JPA
- `domain.repository`: Repositórios JPA
- `controller.dto`: DTOs (Data Transfer Objects)
- `service.exception`: Exceções personalizadas

---

## 🔗 Endpoints disponíveis

### `/usuarios`
- `GET /usuarios`
- `GET /usuarios/{id}`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### `/usuarios/{usuarioId}/habitos`
- `GET /usuarios/{usuarioId}/habitos`
- `GET /usuarios/{usuarioId}/habitos/{id}`
- `POST /usuarios/{usuarioId}/habitos`
- `PUT /usuarios/{usuarioId}/habitos/{id}`
- `DELETE /usuarios/{usuarioId}/habitos/{id}`

### `/categorias`
- `GET /categorias`
- `GET /categorias/{id}`
- `POST /categorias`
- `PUT /categorias/{id}`
- `DELETE /categorias/{id}`

---

## 📄 Documentação Swagger

Após rodar a aplicação, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🛠 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Importe no IntelliJ como projeto Maven

3. Execute a classe `HabitsApiApplication.java`

4. Acesse o Swagger para testar os endpoints.

