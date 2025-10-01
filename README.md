PetAPI - Localização de Pets Perdidos

API REST construída para auxiliar na localização de pets durante o acionamento de sinistros de seguro, com base na posição geográfica enviada por sensores de coleira.

---

Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **PositionStack API** (geocodificação reversa)
- **Postman** (testes de integração)
- **JUnit + Mockito** (testes unitários)
- **Lombok** (limpeza de código)
- **SLF4J/Logback** (logs)

---

Estrutura do Projeto

com.petapi

.controller   ------  Controladores REST

.service    --------  Regras de negócio

.model      --------  Entidades e DTOs

.repository  -------  Interfaces de acesso a dados

.client     -------   Integração externa (PositionStack)

.ApiLocalizacaoPetApplication.java


---

Funcionalidades

- Receber dados de sensores com ID, latitude, longitude e data/hora
- Consultar o endereço completo da localização via PositionStack
- Persistir os dados enriquecidos com endereço
- Listar todas as localizações
- Buscar localização por ID
- Remover localização por ID

---

Testes

- Testes unitários com cobertura para camada de serviço
- Testes de integração com o banco H2 e Postman
- Cobertura de testes validada com Jacoco

---

 Observabilidade

- Logs estruturados com SLF4J
- Pode ser facilmente adaptado para usar Prometheus, Micrometer, etc.

---

Padrões de Projeto e Princípios Aplicados

- **SOLID**
- **DTO (Data Transfer Object)**
- **Service Layer Pattern**
- **Repository Pattern**
- **Separation of Concerns**
- **Clean Architecture (divisão clara entre camadas)**

---

Premissas e Decisões

- O projeto assume que o sensor sempre envia dados válidos (não foi implementada validação por latitude/longitude).
- A API externa usada é a PositionStack (gratuita com chave de API).
- A chave da API é armazenada em `application.properties` (ideal: variável de ambiente em produção).
- A base de dados utilizada é a H2 (em memória) para facilitar testes locais.

---

Como Executar Localmente

Pré-requisitos:

- Java 17
- Maven
- IDE ( STS )

Passos:

```bash
git clone https://github.com/seu-usuario/api-localizacao-pet.git
cd api-localizacao-pet
mvn spring-boot:run
```

> A aplicação estará disponível em: `http://localhost:8080`

---

Endpoints REST

| Método | Endpoint                   | Descrição                         |
|--------|----------------------------|-----------------------------------|
| POST   | `/api/localizacao`         | Registra nova localização         |
| GET    | `/api/localizacao`         | Lista todas as localizações       |
| GET    | `/api/localizacao/{id}`    | Busca localização por ID          |
| DELETE | `/api/localizacao/{id}`    | Remove localização por ID         |

---

Teste com Postman

- Uma collection Postman está disponível nos arquivos do projeto.
- Importar no Postman > Import > Upload File


