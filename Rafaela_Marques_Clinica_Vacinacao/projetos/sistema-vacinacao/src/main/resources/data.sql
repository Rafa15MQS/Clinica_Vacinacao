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
