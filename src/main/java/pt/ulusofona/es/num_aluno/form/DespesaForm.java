package pt.ulusofona.es.num_aluno.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nunonelas on 30/11/16.
 */
public class DespesaForm {

    private Long id;

    @NotEmpty(message = "Tem que inserir a categoria de despesa.")
    private String categoria;

    @NotEmpty(message = "Tem que inserir a data de despesa.")
    private String data;

    @NotEmpty(message = "Tem que inserir a descrição da despesa.")
    @Size(max=160, message = "A despesa só pode conter até 160 caracteres.")
    private String descricao;

    @NotNull(message = "Tem que inserir o valor da despesa.")
    private Float valor;

    private String localizacao;

    public String getCategoria() {
        return categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}

