package com.clinica.sistema_vacinacao.repository;

import com.clinica.sistema_vacinacao.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
