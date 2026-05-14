# URL Shortener API 🚀

API REST desenvolvida em Java + Spring Boot para encurtamento de URLs.

O sistema recebe uma URL original, gera uma URL curta única e permite redirecionamento para a URL original através do código encurtado.

---

# 📚 Sobre o projeto

Este projeto foi desenvolvido com foco em:

- arquitetura backend profissional;
- boas práticas com Spring Boot;
- separação de responsabilidades;
- APIs REST;
- persistência com JPA/Hibernate;
- geração de URLs encurtadas;
- validação;
- escalabilidade;
- organização de código.

---

# 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```txt
Controller
↓
Service
↓
Repository
↓
Database
```

---

# 📂 Estrutura do projeto

```txt
src/main/java/com/desafio/url_shortener

├── controller
├── dto
├── entity
├── repository
├── service
└── UrlShortenerApplication
```

---

# ⚙️ Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven

---

# 🧠 Conceitos aplicados

- REST API
- DTO Pattern
- Builder Pattern
- Service Layer
- Repository Pattern
- Validação com Bean Validation
- JPA/Hibernate
- Injeção de Dependência
- Arquitetura em Camadas

---

# 🗄️ Banco de Dados

Banco utilizado:

```txt
MySQL
```

Criação do banco:

```sql
CREATE DATABASE urlshortener;
```

---

# ⚙️ Configuração do application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/urlshortener
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# 🚀 Como executar o projeto

## 1. Clone o repositório

```bash
git clone URL_DO_REPOSITORIO
```

---

## 2. Entre na pasta do projeto

```bash
cd url-shortener
```

---

## 3. Execute a aplicação

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

---

# 📌 Endpoint principal

## Encurtar URL

### Request

```http
POST /api/v1/shorten-url
```

### Body

```json
{
  "url": "https://backendbrasil.com.br"
}
```

---

### Response

```json
{
  "url": "http://localhost:8080/ABC12"
}
```

---

# 🔗 Redirect da URL

Ao acessar:

```txt
http://localhost:8080/ABC12
```

A aplicação:

- busca a URL no banco;
- valida expiração;
- realiza redirecionamento HTTP 302;
- envia o usuário para a URL original.

---

# 📦 Modelagem da entidade

A entidade principal da aplicação é:

```java
ShortUrl
```

Campos:

- id
- originalUrl
- shortCode
- createdAt
- expiresAt

---

# 🔐 Regras do sistema

- URLs encurtadas possuem entre 5 e 10 caracteres;
- apenas letras e números são utilizados;
- o código gerado é único;
- URLs possuem data de expiração;
- validação automática de entrada;
- arquitetura desacoplada utilizando DTOs.

---

# 🧱 Padrões utilizados

## DTO Pattern

Separação entre:
- entrada da API;
- saída da API;
- entidade do banco.

---

## Builder Pattern

Utilizado para criação fluida e legível de objetos.

Exemplo:

```java
ShortUrl.builder()
```

---

# 📖 Aprendizados aplicados

Durante o desenvolvimento foram praticados conceitos importantes de backend Java:

- organização em camadas;
- arquitetura REST;
- criação de APIs com Spring Boot;
- geração de identificadores únicos;
- persistência com JPA;
- uso de Lombok;
- validações;
- boas práticas de backend.

---

# 🚧 Melhorias futuras

- Exception Handler global;
- Swagger/OpenAPI;
- Docker;
- Redis Cache;
- métricas de acesso;
- expiração automática;
- testes unitários;
- autenticação JWT;
- rate limit.

---

# 👨‍💻 Autor

Desenvolvido por Robson Calheira 🚀

Backend Developer | Java | Spring Boot | APIs REST | MySQL
