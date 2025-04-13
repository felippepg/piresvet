# PiresVet
🇧🇷

PiresVet é um sistema de gerenciamento para cadastro de pets, veterinários, donos de pets e agendamento de consultas. Este projeto é um estudo sobre **arquitetura limpa** com foco na separação das camadas de responsabilidade.

---

## 🚀 Tecnologias Utilizadas

- **Java 20**
- **Spring Boot 3.4.0**
- **Flyway** (para migrações de banco de dados)
- **H2** (banco de dados em memória, com a intenção de migração para MySQL no futuro)
- **Maven** (gerenciador de dependências e build)

---

## 🛠 Estrutura do Projeto

O projeto está dividido em módulos para manter uma arquitetura limpa e modularizada:

- **core**: Contém a camada de domínio (entidades e lógica de negócio).
- **application**: Contém as interfaces de use cases e gateways.
- **infrastructure**: Contém a implementação do Spring Boot, configuração do banco de dados, controladores e serviços.

---

## 🔧 Dependências

- **Spring Boot 3.4.0**: Framework para construção de aplicações Java.
- **Flyway 10.20.1**: Ferramenta para gerenciamento de migrações de banco de dados.
- **H2 Database**: Banco de dados em memória, utilizado para simplificação durante o desenvolvimento (a migração futura para MySQL está planejada).

---

## 🚀 Como Executar o Projeto

Este projeto utiliza o **Maven** para gerenciamento de dependências e build.

### Como instalar o Maven:

1. **Verifique se o Maven está instalado**: Execute o comando abaixo no terminal:


bash
mvn -v


Se o Maven não estiver instalado, você pode seguir a documentação oficial para instalá-lo: [Documentação do Maven](https://maven.apache.org/install.html).

### Para rodar o projeto:

1. Clone o repositório e navegue até a pasta do projeto.
2. Execute o comando abaixo para limpar, compilar e resolver as dependências do projeto:


bash
mvn clean install


3. Para rodar a aplicação:


bash
mvn spring-boot:run


O Maven automaticamente baixará as dependências necessárias conforme definido no pom.xml.

---

## 🔄 Como Funciona o Flyway

O Flyway é configurado para gerenciar migrações do banco de dados. As migrações de banco são executadas automaticamente durante o processo de build ou ao rodar a aplicação, caso as configurações de banco de dados estejam corretamente definidas no arquivo application.properties ou application.yml.

**Observação**: Atualmente, o banco de dados utilizado é o H2, mas a intenção é migrar para o MySQL futuramente.


---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

**Desenvolvido por**: Felippe Gonçalves 🇧🇷

---

# PiresVet
🇺🇸

PiresVet is a management system for registering pets, veterinarians, pet owners, and scheduling appointments. This project is a study on **clean architecture** focusing on separating responsibility layers.

---

## 🚀 Technologies Used

- **Java 20**
- **Spring Boot 3.4.0**
- **Flyway** (for database migrations)
- **H2** (in-memory database, with plans to migrate to MySQL in the future)
- **Maven** (dependency and build manager)

---

## 🛠 Project Structure

The project is divided into modules to maintain a clean and modular architecture:

- **core**: Contains the domain layer (entities and business logic).
- **application**: Contains use case and gateway interfaces.
- **infrastructure**: Contains the Spring Boot implementation, database configuration, controllers, and services.

---

## 🔧 Dependencies

- **Spring Boot 3.4.0**: Framework for building Java applications.
- **Flyway 10.20.1**: Database migration management tool.
- **H2 Database**: In-memory database, used for simplification during development (future migration to MySQL is planned).

---

## 🚀 How to Run the Project

This project uses **Maven** for dependency management and build.

### How to Install Maven:

1. **Check if Maven is installed**: Run the command below in your terminal:


bash
mvn -v


If Maven is not installed, you can follow the official documentation to install it: [Maven Installation Documentation](https://maven.apache.org/install.html).

### To run the project:

1. Clone the repository and navigate to the project folder.
2. Run the command below to clean, compile, and resolve the project dependencies:


bash
mvn clean install


3. To run the application:


bash
mvn spring-boot:run


Maven will automatically download the required dependencies as defined in the pom.xml.

---

## 🔄 How Flyway Works

Flyway is configured to manage database migrations. Database migrations are automatically executed during the build process or when running the application, provided the database configurations are correctly set in the application.properties or application.yml file.

**Note**: Currently, the database used is H2, but there are plans to migrate to MySQL in the future.


---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

**Developed by**: Felippe Gonçalves 🇺🇸
