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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria1 = (Categoria) o;

        if (id != categoria1.id) return false;
        return categoria.equals(categoria1.categoria);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + categoria.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}