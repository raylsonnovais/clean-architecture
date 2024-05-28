
# Wishlist Service

## Descrição
Este é um serviço HTTP desenvolvido para gerenciar a Wishlist do cliente em um e-commerce. A Wishlist permite que os clientes selecionem e armazenem produtos de sua preferência para compra posterior. Com este serviço, os clientes podem adicionar, remover, consultar todos os produtos em sua Wishlist e verificar se um produto específico está presente na Wishlist.

## Funcionalidades
- Adicionar um produto à Wishlist do cliente
- Remover um produto da Wishlist do cliente
- Consultar todos os produtos da Wishlist do cliente
- Verificar se um determinado produto está na Wishlist do cliente

## Como utilizar

### Pré-requisitos
- JDK 11 ou superior
- Gradle
- Docker (opcional)

### Executando localmente
1. Clone o repositório: `git clone https://github.com/seu-usuario/wishlist-service.git`
2. Navegue até o diretório do projeto: `cd wishlist-service`
3. Execute o comando para construir o projeto: `gradle build`
4. Execute o comando para rodar os testes: `gradle test`
5. Execute o comando para iniciar o serviço: `gradle bootRun`
6. Acesse a documentação Swagger em [http://localhost:8090/api/swagger-ui/index.html#/Wishlist/isProductInWishList](http://localhost:8090/api/swagger-ui/index.html#/Wishlist/isProductInWishList)

### Utilizando Docker Compose (opcional)
Se preferir, você pode executar o serviço usando Docker Compose.
1. Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.
2. No diretório raiz do projeto, execute o seguinte comando: `docker-compose up --build`
3. Acesse a documentação Swagger em [http://localhost:8090/api/swagger-ui/index.html#/Wishlist/isProductInWishList](http://localhost:8090/api/swagger-ui/index.html#/Wishlist/isProductInWishList)

## Endpoints

### Adicionar Wishlist
- **URL:** `/api/wishlist/`
- **Método HTTP:** POST
- **Corpo da requisição:**
    ```json
    {
        "customerId": "string",
        "productIds": [
            "string"
        ]
    }
    ```

### Adicioinar um produto da Wishlist do cliente
- **URL:** `/api/wishlist/add`
- **Método HTTP:** POST
- **Corpo da requisição:**
    ```json
    {
        "productId": "string",
        "customerId": "string"
    }
    ```


### Remover um produto da Wishlist do cliente
- **URL:** `/api/wishlist/remove`
- **Método HTTP:** POST
- **Corpo da requisição:**
    ```json
    {
        "productId": "string",
        "customerId": "string"
    }
    ```

### Consultar todos os produtos da Wishlist do cliente
- **URL:** `/api/wishlist/allProducts/{customerId}`
- **Método HTTP:** GET
- **Parâmetros da URL:**
    - `customerId`: ID do cliente

### Verificar se um determinado produto está na Wishlist do cliente
- **URL:** `/api/wishlist/isProductInWishList`
- **Método HTTP:** GET
- **Parâmetros da URL:**
    - `productId`: ID do produto
    - `customerId`: ID do cliente

## Tecnologias utilizadas
- Java
- Spring Boot
- Gradle
- Docker
- Swagger

Este serviço foi desenvolvido como parte de um desafio técnico e está sujeito a melhorias e ajustes. Para qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato com a equipe de desenvolvimento.

--- 

Espero que isso ajude! Se precisar de mais alguma coisa, é só dizer.
