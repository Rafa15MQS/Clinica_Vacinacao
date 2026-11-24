package com.clinica.sistema_vacinacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Vacina")
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacina;

    @Column(nullable = false, length = 100)
    private String nomeVacina;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false)
    private Integer quantidadeDoses;

    @Column(nullable = false)
    private LocalDate validadeVacina;

    @Column(nullable = false, length = 50)
    private String lote;

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(Integer quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public LocalDate getValidadeVacina() {
        return validadeVacina;
    }

    public void setValidadeVacina(LocalDate validadeVacina) {
        this.validadeVacina = validadeVacina;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
