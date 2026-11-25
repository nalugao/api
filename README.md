# API de Produtos

API REST para cadastro de produtos, feita com Spring Boot.

## Sobre este projeto

Esta é a **primeira API que eu fiz sozinha**. Escrevi o código, a estrutura e a lógica da aplicação por conta própria. A única ajuda que tive foi do [Claude](https://claude.com/claude-code) para organizar e fazer os commits.

## Tecnologias

- Java 21
- Spring Boot 4.2 (Web MVC, Data JPA, Validation, DevTools)
- MySQL
- Lombok
- Maven (via Maven Wrapper)

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/products` | Cadastra um produto |
| `GET` | `/products` | Lista todos os produtos |
| `GET` | `/products/{id}` | Busca um produto pelo id |
| `PUT` | `/products/{id}` | Atualiza um produto |
| `DELETE` | `/products/{id}` | Remove um produto |

Exemplo de corpo para `POST` e `PUT`:

```json
{
  "nome": "Caneta",
  "preco": 2.50,
  "quantidade": 10
}
```

Quando o produto não existe, a API responde `404 Not Found`.

## Como rodar

1. Tenha o Java 21 e um MySQL rodando em `localhost`, com um banco chamado `product_db` acessível pelo usuário `root`.
2. Crie um arquivo `.env` na raiz do projeto com a senha do banco:
   ```
   DB_PASSWORD=sua_senha
   ```
3. Rode a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

A API sobe em `http://localhost:8080`. A tabela `products` é criada automaticamente.
