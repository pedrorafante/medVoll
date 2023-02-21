package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface IValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dadosCancelamentoConsulta);
}
