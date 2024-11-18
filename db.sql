CREATE DATABASE IF NOT EXISTS bd_controle_emprestimo;

USE bd_controle_emprestimo;

DROP TABLE IF EXISTS ferramentas_emprestadas;
DROP TABLE IF EXISTS emprestimos;
DROP TABLE IF EXISTS amigos;
DROP TABLE IF EXISTS ferramentas;

CREATE TABLE IF NOT EXISTS ferramentas (
    id_ferramenta INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    marca VARCHAR(255),
    custo DECIMAL(10, 2),
    status VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS amigos (
    id_amigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(20),
    score VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS emprestimos (
    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    id_amigo INT,
    id_ferramenta INT,
    data_emprestimo DATE,
    data_devolucao DATE,
    status INT NOT NULL,
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id_ferramenta),
    FOREIGN KEY (id_amigo) REFERENCES amigos(id_amigo)
);

CREATE TABLE IF NOT EXISTS ferramentas_emprestadas (
    id_emprestimo INT NOT NULL,
    id_ferramenta INT NOT NULL,
    FOREIGN KEY (id_emprestimo) REFERENCES emprestimos(id_emprestimo),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id_ferramenta)
);