package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
    }

    public void atualizaInformacao(DadosEndereco dadosAtualizacaoEndereco) {
        if (dadosAtualizacaoEndereco.logradouro() != null) {
            this.logradouro = dadosAtualizacaoEndereco.logradouro();
        }
        if (dadosAtualizacaoEndereco.bairro() != null) {
            this.bairro = dadosAtualizacaoEndereco.bairro();
        }
        if (dadosAtualizacaoEndereco.cep() != null) {
            this.cep = dadosAtualizacaoEndereco.cep();
        }
        if (dadosAtualizacaoEndereco.numero() != null) {
            this.numero = dadosAtualizacaoEndereco.numero();
        }
        if (dadosAtualizacaoEndereco.complemento() != null) {
            this.complemento = dadosAtualizacaoEndereco.complemento();
        }
        if (dadosAtualizacaoEndereco.cidade() != null) {
            this.cidade = dadosAtualizacaoEndereco.cidade();
        }
        if (dadosAtualizacaoEndereco.uf() != null) {
            this.uf = dadosAtualizacaoEndereco.uf();
        }
    }
}
