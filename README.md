## Requisitos

Antes de executar o projeto, tenha instalado:

* Java 21
* MySQL 8 Server
* Maven
* Git

## Clonando o projeto

Clone o repositório:

```bash
git clone https://github.com/RaulBatagini/gamehub.git
```

Entre na pasta:

```bash
cd gamehub
```

## Configuração do banco de dados

O projeto utiliza MySQL.

No arquivo:

```text
src/main/resources/application.properties
```

configure os dados do seu MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost/gamehub?createDatabaseIfNotExist=true
spring.datasource.username=SEU_USUARIO_AQUI
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
```

## Executando o projeto

Após configurar o banco de dados, execute o projeto pela IDE ou utilizando o Maven:

```bash
mvn spring-boot:run
```

Depois acesse no navegador:

```text
http://localhost:8080/desenvolvedoras/formulario
http://localhost:8080/desenvolvedoras/listagem
http://localhost:8080/jogos/formulario
http://localhost:8080/jogos/listagem
```

## Estrutura do projeto

```text
src/
└── main/
    ├── java/
    │   └── ...
    │
    └── resources/
        ├── static/
        ├── templates/
        │   ├── desenvolvedoras/
        │   │   ├── formulario.html
        │   │   └── listagem.html
        │   │
        │   └── jogos/
        │       ├── formulario.html
        │       └── listagem.html
        │
        └── application.properties
```

##  Banco de dados

O projeto possui relacionamento entre:

```text
Desenvolvedora 1 ───────── N Jogo
```

Uma desenvolvedora pode possuir vários jogos, enquanto cada jogo pertence a uma desenvolvedora.

O relacionamento é implementado através de:

```java
@OneToMany
```

na entidade `Desenvolvedora` e:

```java
@ManyToOne
```

na entidade `Jogo`.

## Fluxo de desenvolvimento com Git

A branch `main` deve representar a versão principal do projeto.

Para desenvolver uma nova funcionalidade, crie uma branch:

```bash
git switch main
git pull
git switch -c feature/nome-da-funcionalidade
```

Faça suas alterações e depois:

```bash
git add .
git commit -m "feat: descrição da alteração"
git push -u origin feature/nome-da-funcionalidade
```

Depois, abra um Pull Request no GitHub para revisar e juntar a alteração na `main`.

### Exemplos de branches

```text
feature/cadastro-jogos
feature/cadastro-desenvolvedoras
feature/telas
feature/consulta-jogos
fix/correcao-formulario
```
