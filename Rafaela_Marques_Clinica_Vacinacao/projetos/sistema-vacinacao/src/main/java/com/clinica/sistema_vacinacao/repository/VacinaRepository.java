package com.clinica.sistema_vacinacao.repository;

import com.clinica.sistema_vacinacao.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
