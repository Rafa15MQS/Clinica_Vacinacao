package com.clinica.sistema_vacinacao.controller;

import com.clinica.sistema_vacinacao.model.Agendamento;
import com.clinica.sistema_vacinacao.model.Paciente;
import com.clinica.sistema_vacinacao.model.Vacina;
import com.clinica.sistema_vacinacao.repository.AgendamentoRepository;
import com.clinica.sistema_vacinacao.repository.PacienteRepository;
import com.clinica.sistema_vacinacao.repository.VacinaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ClinicaController {
    private final PacienteRepository pacienteRepository;
    private final VacinaRepository vacinaRepository;
    private final AgendamentoRepository agendamentoRepository;

    public ClinicaController(PacienteRepository pacienteRepository,
                             VacinaRepository vacinaRepository,
                             AgendamentoRepository agendamentoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.vacinaRepository = vacinaRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        model.addAttribute("vacinas", vacinaRepository.findAll());
        model.addAttribute("agendamentos", agendamentoRepository.findAll());
        return "index";
    }

    @PostMapping("/pacientes")
    public String cadastrarPaciente(@RequestParam String nomePaciente,
                                    @RequestParam String cpf,
                                    @RequestParam String telefone,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento) {
        Paciente paciente = new Paciente();
        paciente.setNomePaciente(nomePaciente);
        paciente.setCpf(cpf);
        paciente.setTelefone(telefone);
        paciente.setDataNascimento(dataNascimento);
        pacienteRepository.save(paciente);
        return "redirect:/";
    }

    @PostMapping("/vacinas")
    public String cadastrarVacina(@RequestParam String nomeVacina,
                                  @RequestParam String fabricante,
                                  @RequestParam Integer quantidadeDoses,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validadeVacina,
                                  @RequestParam String lote) {
        Vacina vacina = new Vacina();
        vacina.setNomeVacina(nomeVacina);
        vacina.setFabricante(fabricante);
        vacina.setQuantidadeDoses(quantidadeDoses);
        vacina.setValidadeVacina(validadeVacina);
        vacina.setLote(lote);
        vacinaRepository.save(vacina);
        return "redirect:/";
    }

    @PostMapping("/agendamentos")
    public String cadastrarAgendamento(@RequestParam Long idPaciente,
                                       @RequestParam Long idVacina,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataAgendamento,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime horarioAgendamento) {
        Agendamento agendamento = new Agendamento();
        agendamento.setPaciente(pacienteRepository.findById(idPaciente).orElseThrow());
        agendamento.setVacina(vacinaRepository.findById(idVacina).orElseThrow());
        agendamento.setDataAgendamento(dataAgendamento);
        agendamento.setHorarioAgendamento(horarioAgendamento);
        agendamentoRepository.save(agendamento);
        return "redirect:/";
    }

    @PostMapping("/agendamentos/excluir")
    public String excluirAgendamento(@RequestParam Long idAgendamento) {
        agendamentoRepository.deleteById(idAgendamento);
        return "redirect:/";
    }
}
