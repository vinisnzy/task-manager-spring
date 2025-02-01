# Task Manager - Gerenciador de Tarefas

## 📌 Descrição
Este é um projeto simples de gerenciamento de tarefas desenvolvido com **Spring Boot** e **Thymeleaf**. Ele permite adicionar, editar, listar e excluir tarefas de forma intuitiva.

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Thymeleaf**
- **Banco de Dados H2** (persistente em arquivo)
- **Flyway** (migração de banco de dados)
- **Maven**

## 📂 Estrutura do Projeto
```
TaskManager/
│-- src/main/java/com/vinisnzy/task_manager/
│   ├── controllers/ (Controladores Spring)
│   ├── models/ (Entidades JPA)
│   ├── repositories/ (Interfaces JpaRepository)
│   ├── services/ (Lógica de negócio, opcional)
│-- src/main/resources/
│   ├── templates/ (Arquivos HTML com Thymeleaf)
│   ├── db/migration/ (Scripts SQL do Flyway)
│   ├── application.properties
│-- pom.xml (Dependências do Maven)
```

## 🛠 Como Executar o Projeto
1.  **Clone o repositório**
   ```sh
   git clone https://github.com/vinisnzy/task-manager-spring.git
   cd task-manager
   ```
2.  **Compile o projeto**
   ```sh
   mvn clean install
   ```
3.  **Execute a aplicação**
   ```sh
   mvn spring-boot:run
   ```
4.  **Acesse no navegador**
   ```
   http://localhost:8080/tasks
   ```

## ✨ Funcionalidades
✅ Adicionar uma nova tarefa  
✅ Listar todas as tarefas 
✅ Editar uma tarefa  
✅ Excluir uma tarefa  

## 🛠 Melhorias Futuras
- [ ] Implementar autenticação e controle de usuários
- [ ] Adicionar API REST para integração com frontend

## 📜 Licença
Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

