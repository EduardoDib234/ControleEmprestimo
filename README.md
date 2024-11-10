# **ControleEmprestimo**

Sistema de gerenciamento de empréstimo de ferramentas

## **Integrantes**

- **Jhonatan Matos Schmitt** (C0mrad078) - RA: 162210582
- **Kamily Pereira de Castro** - RA: 162211995
- **Eduardo Henrique Dib Barbosa Anton** - RA: 1624239244

## **Professores**

- Osmar de Oliveira Braz Junior
- José Padilha Chrispim Neto

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

- **Cadastro de Amigos**
  - Armazena informações de amigos que podem solicitar ferramentas, incluindo:
    - **Nome**
    - **Telefone**

- **Empréstimo de Ferramentas**
  - Permite o registro de empréstimos com:
    - **Amigo** (empréstimo para um ou mais amigos)
    - **Data de Empréstimo**
    - **Data de Devolução** (quando a ferramenta é devolvida)

- **Relatórios**
  - **Ferramentas e Custos**: Exibe todas as ferramentas cadastradas e o valor total gasto.
  - **Empréstimos Ativos**: Mostra uma lista de ferramentas atualmente emprestadas que ainda não foram devolvidas.
  - **Histórico de Empréstimos**: Relatório de todos os empréstimos realizados, com informações sobre:
    - Amigos que já emprestaram ferramentas
    - Quem possui itens não devolvidos
    - Quem realizou mais empréstimos

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

---
