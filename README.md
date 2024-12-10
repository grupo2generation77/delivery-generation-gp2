# 🍔 API de Delivery de Comida

## 📝 Descrição  
Esta é uma **API REST** para um sistema de **delivery de comida**. O sistema gerencia:
- **Usuários**, que podem realizar pedidos.
- **Produtos** (itens disponíveis para compra).
- **Categorias**, que classificam os produtos.

Funcionalidades incluem operações **CRUD** para cada entidade e uma recomendação de produtos saudáveis.  
Esta API está pronta para ser consumida por outros sistemas ou aplicativos.

---

## 🛠️ Tecnologias Utilizadas  
- **Java 17**: Linguagem de programação principal.  
- **Spring Boot**: Framework para desenvolvimento rápido de aplicações.  
- **Spring Data JPA**: Para mapeamento objeto-relacional.  
- **MySQL**: Banco de dados relacional.  
- **Maven**: Gerenciador de dependências.  
- **Spring Web**: Para exposição de APIs REST.  
- **Insomnia**: Para testes e documentação das APIs.  

---

## 🔗 Relacionamento entre Entidades

```mermaid
erDiagram
    USUARIO {
        Long id
        String nome
        String email
        String foto
        String senha
    }
    PRODUTO {
        Long id
        String nome
        String descricao
        Long valor
    }
    CATEGORIA {
        Long id
        String nome
        String descricao
        Boolean saudavel
    }
    USUARIO ||--o{ PRODUTO : pedidos
    PRODUTO }o--|| CATEGORIA : pertence
```
---

## 📂 Estrutura do Projeto  

### 🧑‍💻 Entidades e Relacionamentos  

#### 1️⃣ **Usuário**
Representa os usuários do sistema, que podem realizar pedidos.  
**Atributos**:  
- `id (Long)`: Identificador único.  
- `nome (String)`: Nome do usuário.  
- `email (String)`: Endereço de e-mail do usuário.  
- `foto (String)`: URL da foto do usuário.  
- `senha (String)`: Senha para autenticação.  
- `pedidos (List<Produto>)`: Lista de produtos pedidos pelo usuário.  

**Relacionamento**:  
- Um usuário pode ter vários produtos no histórico de pedidos.  

#### 2️⃣ **Produto**
Representa os itens disponíveis para entrega.  
**Atributos**:  
- `id (Long)`: Identificador único.  
- `nome (String)`: Nome do produto.  
- `descricao (String)`: Descrição detalhada do produto.  
- `valor (Long)`: Preço do produto.  
- `categoria (Categoria)`: Categoria a que o produto pertence.  

**Relacionamento**:  
- Um produto pertence a uma categoria.  

#### 3️⃣ **Categoria**
Classifica os produtos, como "Bebidas", "Sobremesas" ou "Pratos Principais".  
**Atributos**:  
- `id (Long)`: Identificador único.  
- `nome (String)`: Nome da categoria.  
- `descricao (String)`: Descrição detalhada da categoria.  
- `saudavel (Boolean)`: Indica se a categoria é saudável ou não.  
- `produtos (List<Produto>)`: Lista de produtos na categoria.  

**Relacionamento**:  
- Uma categoria pode ter vários produtos.  

---

## 🌟 Funcionalidades  

### 🔑 CRUD de Usuários
- **Criar**: Cadastro de novos usuários.  
- **Ler**: Recuperar informações de usuários por ID ou listar todos.  
- **Atualizar**: Alterar dados de um usuário existente.  
- **Excluir**: Remover um usuário do sistema.  

### 🛒 CRUD de Produtos
- **Criar**: Adicionar novos produtos ao catálogo.  
- **Ler**: Recuperar informações de produtos por ID ou listar todos.  
- **Atualizar**: Alterar informações de um produto existente.  
- **Excluir**: Remover um produto do catálogo.  

### 🗂️ CRUD de Categorias
- **Criar**: Adicionar novas categorias ao sistema.  
- **Ler**: Recuperar informações de categorias por ID ou listar todas.  
- **Atualizar**: Alterar informações de uma categoria existente.  
- **Excluir**: Remover uma categoria do sistema.  

### 🥗 Recomendação de Produtos Saudáveis
- **Listar Produtos Saudáveis**: Endpoint que retorna todos os produtos pertencentes a categorias marcadas como "saudáveis".  

---

## 🔗 Estrutura dos Endpoints  

### **Usuário**
| Método HTTP | Endpoint          | Descrição                      |
|-------------|-------------------|--------------------------------|
| POST        | `/usuarios`       | Cadastrar novo usuário         |
| GET         | `/usuarios`       | Listar todos os usuários       |
| GET         | `/usuarios/{id}`  | Buscar usuário por ID          |
| PUT         | `/usuarios/{id}`  | Atualizar usuário por ID       |
| DELETE      | `/usuarios/{id}`  | Remover usuário por ID         |

### **Produto**
| Método HTTP | Endpoint          | Descrição                      |
|-------------|-------------------|--------------------------------|
| POST        | `/produtos`       | Adicionar novo produto         |
| GET         | `/produtos`       | Listar todos os produtos       |
| GET         | `/produtos/{id}`  | Buscar produto por ID          |
| PUT         | `/produtos/{id}`  | Atualizar produto por ID       |
| DELETE      | `/produtos/{id}`  | Remover produto por ID         |

### **Categoria**
| Método HTTP | Endpoint          | Descrição                      |
|-------------|-------------------|--------------------------------|
| POST        | `/categorias`     | Adicionar nova categoria       |
| GET         | `/categorias`     | Listar todas as categorias     |
| GET         | `/categorias/{id}`| Buscar categoria por ID        |
| PUT         | `/categorias/{id}`| Atualizar categoria por ID     |
| DELETE      | `/categorias/{id}`| Remover categoria por ID       |

### **Recomendação**
| Método HTTP | Endpoint                | Descrição                      |
|-------------|-------------------------|--------------------------------|
| GET         | `/produtos/saudaveis`   | Listar produtos saudáveis      |

---

## 🚀 Como Executar o Projeto  

1. **Clone o repositório**:  
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_PROJETO>
---

## 👨‍💻 Contribuidores

- [Lucas](https://github.com/Lucassai): Implementação dos endpoints de criação.
- [Matheus](https://github.com/MatheusSPQ): Implementação dos endpoints de atualização.
- [Ivan](https://github.com/IJNavi): Implementação dos endpoints de exclusão.
- [Nina](https://github.com/Ninaraquel): Implementação da recomendação de produtos saudáveis.
- [Jaqueline](https://github.com/Jaquelinevalle): Implementação da listagem de dados.
