# **ControleEmprestimo**

Sistema de gerenciamento de empréstimo de ferramentas

## **Integrantes**

- <a href="https://github.com/C0mrad078" title="integrante">**Jhonatan Matos Schmitt**</a></td> (nome presente nos commits: C0mrad078 e Jhonatan) - RA: 162210582
- <a href="https://github.com/kamillyengenharia" title="integrante">**Kamily Pereira de Castro**</a></td> - RA: 162211995
- <a href="https://github.com/EduardoDib234" title="integrante">**Eduardo Henrique Dib Barbosa Anton**</a></td> - RA: 1624239244

## **Professores**

- <a href="https://github.com/osmarbraz" title="Professor">Osmar de Oliveira Braz Junior</a></td>
- <a href="https://github.com/josepedro1903" title="Professor">José Padilha Chrispim Neto</a></td>

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
## **Requisitos**


- **Requisitos funicionais**:
  
  
- **Cadastro de Ferramentas**:

O software deve permitir o cadastro de ferramentas com as seguintes informações:
Nome da ferramenta.
Marca da ferramenta.
Custo de aquisição da ferramenta.
Status da ferramenta.

- **Cadastro de Amigos**:

O sistema deve permitir o cadastro de amigos com as seguintes informações:

Nome do amigo.
Telefone do amigo.
Score do amigo.

- **Registro de Empréstimos**:

O software deve permitir o registro de um empréstimo, com as seguintes informações:

Ferramentas emprestadas (pode ser uma ou mais).
Amigo que está recebendo a ferramenta.
Data do empréstimo.
Data de devolução prevista.
Status do emprestimo.
O sistema deve verificar, no momento do empréstimo, se o amigo já tem ferramentas não devolvidas. Caso tenha, o sistema deve avisar o usuário.

- **Relatórios**:

Relatório de Ferramentas: O software deve gerar um relatório com todas as ferramentas cadastradas, incluindo o nome, a marca e o custo de aquisição. Além disso, o relatório deve mostrar o total gasto com todas as ferramentas cadastradas.

Relatório de Empréstimos Ativos: O software deve gerar um relatório mostrando todos os empréstimos que ainda não foram devolvidos, incluindo as ferramentas emprestadas, os amigos que pegaram as ferramentas e as datas de empréstimo.

Relatório de Empréstimos Realizados: O software deve gerar um relatório com todos os empréstimos realizados (ativos e concluídos), incluindo as ferramentas, os amigos, e as datas de empréstimo e devolução.

Ranking de Empréstimos: O sistema deve identificar o amigo que mais fez empréstimos e mostrar esse ranking.

Identificação de Amigo que Não Devolveu: O sistema deve ser capaz de identificar se algum amigo tem ferramentas não devolvidas, com um alerta que mostre quem são esses amigos.

- **Verificação de Pendências**:

Quando um novo empréstimo for registrado, o sistema deve verificar se o amigo já tem algum item que não foi devolvido, e alertar o usuário caso exista algum empréstimo pendente.


  - **Requisitos não funcionais**:

- **Armazenamento Local**:

O software deve rodar localmente, ou seja, todas as informações devem ser armazenadas no computador do usuário, sem necessidade de conexão com a internet ou de um banco de dados remoto.
O armazenamento pode ser feito em um banco de dados local, como SQLite ou arquivos de dados (como JSON ou XML).

- **Facilidade de Uso**:

A interface do usuário (UI) deve ser intuitiva e fácil de usar, mesmo para usuários com pouco conhecimento técnico. As funcionalidades devem ser acessíveis através de uma navegação simples.

- **Desempenho**:

O software deve ser responsivo e ter um bom desempenho, mesmo com um grande número de registros, garantindo que a navegação entre telas e relatórios seja rápida e sem atrasos.

- **Segurança**:

O software deve garantir que as informações cadastradas (como dados de amigos e ferramentas) sejam mantidas de forma segura, com opções de backup manual ou automático.

- **Portabilidade**:

O software deve ser compatível com os sistemas operacionais mais comuns, como Windows, macOS e Linux.

- **Backup e Recuperação de Dados**:

O sistema deve ter a capacidade de fazer backups automáticos ou manuais dos dados cadastrados, e permitir a recuperação em caso de falha ou corrupção dos dados.

- **Instalação Simples**:

O software deve ser fácil de instalar, com um processo simples e sem necessidade de configurações complexas. Idealmente, um instalador simples para Windows, macOS ou Linux.

- **Manutenção e Atualizações**:

O software deve permitir atualizações simples e rápidas, com correção de erros e melhorias na interface ou funcionalidades.

- **Escalabilidade**:

O sistema deve ser capaz de lidar com um aumento gradual no número de ferramentas, amigos e empréstimos registrados, sem comprometer o desempenho.

- **Relatórios de Impressão**:

O sistema deve permitir que os relatórios gerados possam ser exportados e impressos, seja em formato PDF ou outro formato acessível, para facilitar a visualização e o uso físico.


## **Informaçoes de para iniciar o projeto**
OBS: Para rodar o projeto em seu computador voce deve utilizar o **Netbeans 13**, **Java 8 (jdk1.8.0_202)** e **MySQL Workbench 8.0 CE** 

**1-** Clone nosso repositorio para seu computador  https://github.com/EduardoDib234/ControleEmprestimo

**2-** Crie uma database bd_controle_emprestimo e rode o script que esta dentro do arquivo **banco.sql** presente em nosso projeto.

**3-** Configure as credenciais de acesso ao bando de dados dentro do arquivo **ConexaoDB.java**.
    
    private static final String URL = "jdbc:mysql://localhost:3306/bd_controle_emprestimo"; - URL
    private static final String USER = "root" - USUARIO
    private static final String PASSWORD = "3.iiy:kX36eu"; - SENHA

**4-** Para acessar o software use as informaçoes de login fornecidas abaixo:

    Login: root  
    Senha: Root123




