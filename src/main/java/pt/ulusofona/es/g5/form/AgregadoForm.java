package pt.ulusofona.es.g5.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by nunonelas on 10/01/17.
 */
public class AgregadoForm {

    private Long id;

    private String agregado1;

    @NotEmpty(message = "- Tem que inserir o agregado a adicionar.")
    private String agregado2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgregado1() {
        return agregado1;
    }

    public void setAgregado1(String agregado1) {
        this.agregado1 = agregado1;
    }

    public String getAgregado2() {
        return agregado2;
    }

    public void setAgregado2(String agregado2) {
        this.agregado2 = agregado2;
    }
}
