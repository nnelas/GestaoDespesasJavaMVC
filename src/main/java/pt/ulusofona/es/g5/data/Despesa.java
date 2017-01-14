package pt.ulusofona.es.g5.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by nunonelas on 30/11/16.
 */
@Entity
public class Despesa implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String utilizador;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Float valor;

    @Column
    private String localizacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getCategoria() {
        return categoria;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Despesa despesa = (Despesa) o;

        if (id != despesa.id) return false;
        if (!utilizador.equals(despesa.utilizador)) return false;
        if (!categoria.equals(despesa.categoria)) return false;
        if (!data.equals(despesa.data)) return false;
        if (!descricao.equals(despesa.descricao)) return false;
        if (!valor.equals(despesa.valor)) return false;
        return localizacao != null ? localizacao.equals(despesa.localizacao) : despesa.localizacao == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + utilizador.hashCode();
        result = 31 * result + categoria.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + valor.hashCode();
        result = 31 * result + (localizacao != null ? localizacao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", utilizador='" + utilizador + '\'' +
                ", categoria='" + categoria + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
