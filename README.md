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

# Endpoints
                    
## | POST   -->  /api/localizacao         -->     Registra nova localização  

### Request

Na requisição POST utilizamos os paremetros por meio do body, passando um objeto json,  conforme o exemplo abaixo:

```json
{
  "sensorId": "PET-002",
  "latitude": -22.971964,
  "longitude": -22.971964,,
  "dataHora": "2025-07-21T11:30:00"
}
```

|Campo	   |     Tipo	       |          Descrição	                                           |          Exemplo     |
|----------|-----------------|---------------------------------------------------------------|-----------------     |
|sensorId  |	 String        |	Identificador único do sensor ou dispositivo de rastreamento | "sensor-abc-123"     |
|latitude  | double          |	Coordenada geográfica de latitude                            |       -22.971964     |
|longitude |  double         |	Coordenada geográfica de longitude                           |       -22.971964     |
|dataHora	 |  LocalDateTime  |	Data e hora em que a localização foi capturada               | "2025-07-21T11:30:00"|

### Response 

O response devolve o objeto cadastrado.

```json
    {
        "id": 1,
        "sensorId": "PET-003",
        "latitude": -30.034647,
        "longitude": -51.217658,
        "dataHora": "2025-07-21T13:45:00",
        "pais": "Brazil",
        "estado": "Rio Grande Do Sul",
        "cidade": "Porto Alegre",
        "bairro": "Farroupilha",
        "endereco": "Largo Professor Francisco de Paula Brochado Rocha, Porto Alegre, RS, Brazil"
    }
```

## | GET    -->  /api/localizacao         -->     Lista todas as localizações 

### Request

Na requisição GET utilizamos os paremetros por meio do body, passando um objeto json,  conforme o exemplo abaixo:

```json
{
  "sensorId": "PET-002",
  "latitude": -22.971964,
  "longitude": -22.971964,,
  "dataHora": "2025-07-21T11:30:00"
}
```

|Campo	   |     Tipo	       |          Descrição	                                           |          Exemplo     |
|----------|-----------------|---------------------------------------------------------------|-----------------     |
|sensorId  |	 String        |	Identificador único do sensor ou dispositivo de rastreamento | "sensor-abc-123"     |
|latitude  | double          |	Coordenada geográfica de latitude                            |       -22.971964     |
|longitude |  double         |	Coordenada geográfica de longitude                           |       -22.971964     |
|dataHora	 |  LocalDateTime  |	Data e hora em que a localização foi capturada               | "2025-07-21T11:30:00"|

### Response 

O response devolve uma lista com os objetos cadastrados no endpoint de POST

```json
[
    {
        "id": 1,
        "sensorId": "PET-003",
        "latitude": -30.034647,
        "longitude": -51.217658,
        "dataHora": "2025-07-21T13:45:00",
        "pais": "Brazil",
        "estado": "Rio Grande Do Sul",
        "cidade": "Porto Alegre",
        "bairro": "Farroupilha",
        "endereco": "Largo Professor Francisco de Paula Brochado Rocha, Porto Alegre, RS, Brazil"
    },
    {
        "id": 2,
        "sensorId": "PET-002",
        "latitude": -22.971964,
        "longitude": -43.182553,
        "dataHora": "2025-07-21T11:30:00",
        "pais": "Brazil",
        "estado": "Rio De Janeiro",
        "cidade": "Rio de Janeiro",
        "bairro": "Copacabana",
        "endereco": "Avenida Atlantica 0, Rio de Janeiro, Brazil"
    },
    {
        "id": 3,
        "sensorId": "PET-001",
        "latitude": -23.55052,
        "longitude": -46.633308,
        "dataHora": "2025-07-21T10:00:00",
        "pais": "Brazil",
        "estado": "Sao Paulo",
        "cidade": "São Paulo",
        "bairro": "Se",
        "endereco": "Sé, São Paulo, Brazil"
    }
]
```

## | GET    -->  /api/localizacao/{id}    -->     Busca uma localização por ID

### Request

Na requisição GET por ID, é passado o valor de ID diretamente na URL, conforme o exemplo abaixo:

**{{baseURL}}/api/localizacao/1**

### Response 

O response devolve um Objeto com a requisição do Id que foi passado.

```json
    {
        "id": 1,
        "sensorId": "PET-003",
        "latitude": -30.034647,
        "longitude": -51.217658,
        "dataHora": "2025-07-21T13:45:00",
        "pais": "Brazil",
        "estado": "Rio Grande Do Sul",
        "cidade": "Porto Alegre",
        "bairro": "Farroupilha",
        "endereco": "Largo Professor Francisco de Paula Brochado Rocha, Porto Alegre, RS, Brazil"
    }
```

## | DELETE -->  /api/localizacao/{id}    -->     Remove uma localização por ID     

### Request

Na requisição DELETE por ID, é passado o valor de ID diretamente na URL, conforme o exemplo abaixo:

**{{baseURL}}/api/localizacao/1**

### Response 

O response devolve o Status code 204 e retorna 1 indicando sucesso da deleção.
                                                                                    
---

Teste com Postman

- Uma collection Postman está disponível nos arquivos do projeto.
- Importar no Postman > Import > Upload File


