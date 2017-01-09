package pt.ulusofona.es.g5.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by nunonelas on 08/01/17.
 */
public class CategoriaForm {

    private Long id;

    @NotEmpty(message = "- Tem que inserir a categoria a adicionar.")
    private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
