## 💻 Sobre o projeto

Voll.med é uma clínica médica fictícia que precisa de um aplicativo para gestão de consultas. O aplicativo deve possuir funcionalidades que permitam o cadastro de médicos e de pacientes, e também o agendamento e cancelamento de consultas.

Enquanto um time de desenvolvimento será responsável pelo aplicativo mobile, o nosso será responsável pelo desenvolvimento da API Rest desse projeto.

---

## ⚡ Compilando e inicializando

Gerar os fontes como todo projeto _Maven_
```bash
mvn clean install
```
Para validar se a aplicação inicializou com sucesso é necessário chamar os endpoints criados;
```bash
http://localhost:8080/pacientes
http://localhost:8080/medicos
```

Criei uma collection, para testar no Postman: <a href="https://github.com/pedrorafante/medVoll/blob/main/src/main/resources/collection/VollMed.postman_collection.json"> Collection </a>

Sempre antes de chamar as APIs chamar a api de "Efetuar login", para gerar o token, token tem válidade de 2 horas.

---

## ⚙️ Funcionalidades

- [x] CRUD de médicos;
- [x] CRUD de pacientes;
- [ ] Agendamento de consultas(em breve);
- [ ] Cancelamento de consultas(em breve);
- [ ] Documentação Swagger(em breve);
- [x] Segurança JWT;
- [ ] Testes unitários(em breve);

---

## 🎨 Layout

O layout da aplicação mobile está disponível neste link: <a href="https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med">Figma</a>

---

## 📄 Documentação

A documentação das funcionalidades da aplicação pode ser acessada neste link: <a href="https://trello.com/b/O0lGCsKb/api-voll-med">Trello</a>

Essa documentação foi criada pelo criador do curso, para que eu conseguisse assimilar, e simular a implementação de feactures, utilizando Kanban, branch para cada feacture, criei um projeto aqui no githut e para cada implementação faço um Issues, o projeto pode ser acessado neste link: <a href="https://github.com/users/pedrorafante/projects/1"> Projeto Kanban Github</a>

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Lombok](https://projectlombok.org)**
- **[Postman](https://www.postman.com)**

---

## 📝 Licença

Projeto desenvolvido por [Alura](https://www.alura.com.br) e utilizado nos cursos de Spring Boot.

Instrutor: [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira) 

---
