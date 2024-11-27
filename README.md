# **ControleEmprestimo**

Sistema de gerenciamento de empréstimo de ferramentas

## **Integrantes**

- <a href="https://github.com/C0mrad078" title="integrante">**Jhonatan Matos Schmitt**</a></td> (nome presente nos commits: C0mrad078 e Jhonatan) - RA: 162210582
- <a href="https://github.com/kamillyengenharia" title="integrante">**Kamily Pereira de Castro**</a></td> - RA: 162211995
- <a href="https://github.com/EduardoDib234" title="integrante">**Eduardo Henrique Dib Barbosa Anton**</a></td> - RA: 1624239244

## **Professores**

- <a href="https://github.com/osmarbraz" title="Professor">Osmar de Oliveira Braz Junior</a></td>
- <a href="https://github.com/chrispimjose" title="Professor">José Padilha Chrispim Neto</a></td>

---

## **Descrição do Projeto**

O projeto **ControleEmprestimo** é um sistema simples e funcional de gerenciamento de empréstimo de ferramentas, solicitado pelo tio-avô, com o objetivo de controlar quais ferramentas foram emprestadas, para quem e quando elas são devolvidas. O sistema será desenvolvido em **Java** com **MySQL** e rodará localmente no computador do usuário.

Esse sistema busca simplificar o registro e controle de ferramentas, oferecendo uma interface intuitiva para gerenciar os empréstimos com praticidade e eficiência.

## **Funcionalidades Principais**

- **Cadastro de Ferramentas**
  - Registra informações detalhadas de cada ferramenta, como:
    - **Nome**
    - **Marca**
    - **Custo de Aquisição**
    - **Status** (Disponivel, Indisponivel e Reparo)

- **Cadastro de Amigos**
  - Armazena informações de amigos que podem solicitar ferramentas, incluindo:
    - **Nome**
    - **Telefone**
    - **Score**

- **Empréstimo de Ferramentas**
  - Permite o registro de empréstimos com:
    - **ID do emprestimo**
    - **ID do Amigo**
    - **ID da Ferramenta**
    - **Data de Empréstimo**
    - **Data de Devolução**
    - **Status** (Em Aberto, Inativo e atrasado)

- **Relatórios**
  - **Ferramentas e Custos**: Exibe todas as ferramentas cadastradas separando elas pelo status e o valor total gasto.
  - **Empréstimos Ativos**: Mostra uma lista de ferramentas atualmente emprestadas que ainda não foram devolvidas.
  - **Histórico de Empréstimos**: Relatório de todos os empréstimos realizados, com informações sobre:
    - Amigos que já emprestaram ferramentas
    - Quem possui itens não devolvidos
    - Rank de quem realizou mais empréstimos

- **Avisos sobre Empréstimos Pendentes**
  - Ao registrar um novo empréstimo, o sistema alerta se o amigo ainda possui alguma ferramenta não devolvida, garantindo controle sobre itens ainda em circulação.

---

## **Estrutura do Projeto**

- **Amigo.java**: Classe que representa os amigos no sistema, com nome e telefone.
- **Ferramentas.java**: Classe que contém informações sobre as ferramentas cadastradas.
- **Emprestimo.java**: Classe que gerencia as operações de empréstimo e devolução.
- **ControleEmprestimo.java**: Classe principal que integra o sistema e controla as operações gerais e relatórios.

---

## **Tecnologias Utilizadas**

- **Linguagem de Programação**: Java
- **Ambiente**: Netbeans (desktop)
- **Banco de dados**: Mysql

---
## **Requisitos Funcionais**

RF001 Login de acesso no programa;
RF002 Cadastro e edição de ferramentas;
RF003 Cadastro e edição de amigos;
RF004 Cadastro e edição de empréstimos;
RF005 Listar as ferramentas e o valor gasto de aquisição;
RF006 Listar as ferramentas emprestadas;
RF007 Listar as ferramentas disponíveis para empréstimos;
RF008 Listar os amigos com empréstimos em dia;
RF009 Listar os amigos com empréstimos atrasados;
RF010 Listar os amigos com empréstimos com score baixo, médio e alto;
RF011 Listar os empréstimos em dia;
RF012 Listar os empréstimos atrasados;
RF013 Listar os amigos que nunca devolveram as ferramentas que pediram emprestadas;
RF014 Verificar pendência de ferramentas não devolvidas pelo amigo antes de conceder novo empréstimo;
RF015 Listar os amigos que mais pegaram empréstimos;
RF016 Listar tdos os empréstimos;
RF017 Listar os empréstimos  disponiveis, indisponiveis e ferramentas em manuntenção.


- **Requisitos não funcionais**:

RNF001 Desenvolver em linguagem Java usando o JDK 8;
RNF002 Usado como ambiente de desenvolvimento a IDE Nebeans 13;
RNF003 O sofware deve rodar em todos os computadores;
RNF004 O banco de dados deve estar instalado no mesmo computador onde o programa está rodando;
RNF005 É necessário um computador com ambiente gráfico para rodar o programa;
RNF006 O programa deve responder em tempo real todas as iterações do usuário;
RNF008 Os dados são armazenados no banco de dados seguro;
RNF009 Eventuais manutenções e ampliações do software não fazem parte do escopo inicial devendo serem solicitadas aos desenvolvedores em outros momentos.


## **Informaçoes de para iniciar o projeto**
OBS: Para rodar o projeto em seu computador voce deve utilizar o **Netbeans 13**, **Java 8 (jdk1.8.0_202)** e **MySQL Workbench 8.0 CE** 

**1-** Clone nosso repositorio para seu computador https://github.com/EduardoDib234/ControleEmprestimo

**2-** Crie uma database bd_controle_emprestimo e rode o script que esta dentro do arquivo **banco.sql** presente em nosso projeto.

**3-** Configure as credenciais de acesso ao bando de dados dentro do arquivo <a href="https://github.com/EduardoDib234/ControleEmprestimo/blob/main/src/main/java/dao/ConexaoDB.java" title="Professor">**ConexaoDB.java**.</a></td>.
    
    private static final String URL = "jdbc:mysql://localhost:3306/bd_controle_emprestimo"; - URL
    private static final String USER = "root" - USUARIO
    private static final String PASSWORD = "3.iiy:kX36eu"; - SENHA

**4-** Para acessar o software use as informaçoes de login fornecidas abaixo:

    Login: root  
    Senha: Root123




