package pt.ulusofona.es.g5.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by nunonelas on 08/01/17.
 */
@Entity
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}