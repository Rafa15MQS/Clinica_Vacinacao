-- Atividade de Recuperacao: 116. Sistema de Controle de Clinica de Vacinacao
-- Executado exclusivamente sobre o banco desta atividade.

DROP DATABASE IF EXISTS clinica_vacinacao;

CREATE DATABASE clinica_vacinacao
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE clinica_vacinacao;

CREATE TABLE Paciente (
    idPaciente INT NOT NULL AUTO_INCREMENT,
    nomePaciente VARCHAR(150) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    telefone VARCHAR(30) NOT NULL,
    dataNascimento DATE NOT NULL,
    PRIMARY KEY (idPaciente),
    UNIQUE (cpf)
) ENGINE=InnoDB;

CREATE TABLE Vacina (
    idVacina INT NOT NULL AUTO_INCREMENT,
    nomeVacina VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100) NOT NULL,
    quantidadeDoses INT NOT NULL,
    validadeVacina DATE NOT NULL,
    PRIMARY KEY (idVacina)
) ENGINE=InnoDB;

CREATE TABLE Agendamento (
    idAgendamento INT NOT NULL AUTO_INCREMENT,
    idPaciente INT NOT NULL,
    idVacina INT NOT NULL,
    dataAgendamento DATE NOT NULL,
    horarioAgendamento TIME NOT NULL,
    PRIMARY KEY (idAgendamento),
    CONSTRAINT fk_agendamento_paciente
        FOREIGN KEY (idPaciente) REFERENCES Paciente (idPaciente)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_agendamento_vacina
        FOREIGN KEY (idVacina) REFERENCES Vacina (idVacina)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

ALTER TABLE Vacina
    ADD COLUMN lote VARCHAR(50) NOT NULL;

INSERT INTO Paciente (nomePaciente, cpf, telefone, dataNascimento) VALUES
('Ana Paula Souza', '111.222.333-44', '(11) 98888-1111', '1995-04-12'),
('Carlos Eduardo Lima', '222.333.444-55', '(11) 97777-2222', '1988-09-23'),
('Mariana Costa Silva', '333.444.555-66', '(11) 96666-3333', '2001-11-05');

INSERT INTO Vacina (nomeVacina, fabricante, quantidadeDoses, validadeVacina, lote) VALUES
('Influenza Tetravalente', 'Butantan', 1, '2027-06-30', 'LOTE-BT01'),
('Hepatite B', 'Fiocruz', 3, '2027-10-15', 'LOTE-FC09'),
('Febre Amarela', 'Bio-Manguinhos', 1, '2028-02-20', 'LOTE-BM14');

INSERT INTO Agendamento (idPaciente, idVacina, dataAgendamento, horarioAgendamento) VALUES
(1, 1, '2026-11-25', '09:00:00'),
(2, 2, '2026-11-26', '10:30:00'),
(3, 3, '2026-11-27', '14:00:00');

UPDATE Paciente
SET telefone = '(11) 99999-0000'
WHERE idPaciente = 1;

UPDATE Vacina
SET quantidadeDoses = 2
WHERE idVacina = 2;

UPDATE Agendamento
SET horarioAgendamento = '09:30:00'
WHERE idAgendamento = 1;

DELETE FROM Agendamento WHERE idAgendamento = 3;
DELETE FROM Paciente WHERE idPaciente = 3;
DELETE FROM Vacina WHERE idVacina = 3;

SELECT nomePaciente, cpf, telefone
FROM Paciente;

SELECT nomePaciente, dataNascimento
FROM Paciente
ORDER BY nomePaciente ASC;

SELECT nomeVacina, fabricante, lote
FROM Vacina;

SELECT nomeVacina, quantidadeDoses, validadeVacina
FROM Vacina
WHERE quantidadeDoses >= 1
ORDER BY validadeVacina ASC;

SELECT idAgendamento, idPaciente, idVacina, dataAgendamento, horarioAgendamento
FROM Agendamento;

SELECT idAgendamento, idPaciente, idVacina, dataAgendamento, horarioAgendamento
FROM Agendamento
WHERE dataAgendamento >= '2026-11-25'
ORDER BY dataAgendamento ASC;
