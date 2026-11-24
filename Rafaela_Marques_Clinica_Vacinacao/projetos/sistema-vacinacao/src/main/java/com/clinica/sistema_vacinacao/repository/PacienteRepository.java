package com.clinica.sistema_vacinacao.repository;

import com.clinica.sistema_vacinacao.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
