package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.agendamento.IValidadorAgendamentoDeConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.IValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<IValidadorAgendamentoDeConsulta> validadoresAgendamento;

    @Autowired
    private List<IValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        if (!pacienteRepository.existsById(dadosAgendamentoConsulta.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!!");
        }
        if (dadosAgendamentoConsulta.idMedico() != null && !medicoRepository.existsById(dadosAgendamentoConsulta.idMedico())) {
            throw new ValidacaoException("Id do medico informado não existe!!");
        }

        validadoresAgendamento.forEach(v -> v.validar(dadosAgendamentoConsulta));

        var paciente = pacienteRepository.getReferenceById(dadosAgendamentoConsulta.idPaciente());
        var medico = escolherMedico(dadosAgendamentoConsulta);
        if (medico == null) {
            throw new ValidacaoException("Não existe médico disponivel nesta data.");
        }
        var consulta = new Consulta(null, medico, paciente, dadosAgendamentoConsulta.data(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        if (dadosAgendamentoConsulta.idMedico() != null) {
            return medicoRepository.getReferenceById(dadosAgendamentoConsulta.idMedico());
        }

        if (dadosAgendamentoConsulta.especialidade() == null) {
            throw new ValidacaoException("Especialiade é obrigatoria quando o médico não for informado");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dadosAgendamentoConsulta.especialidade(), dadosAgendamentoConsulta.data());
    }

    public void cacelar(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        if (!consultaRepository.existsById(dadosCancelamentoConsulta.idConsulta())){
            throw new ValidacaoException("Id da consulta não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dadosCancelamentoConsulta));

        var consulta = consultaRepository.getReferenceById(dadosCancelamentoConsulta.idConsulta());
        consulta.cancelar(dadosCancelamentoConsulta.motivoCancelamento());

    }
}
