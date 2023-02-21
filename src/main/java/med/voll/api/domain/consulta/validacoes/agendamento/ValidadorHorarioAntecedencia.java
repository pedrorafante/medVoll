package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements IValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dataConsulta = dadosAgendamentoConsulta.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}
