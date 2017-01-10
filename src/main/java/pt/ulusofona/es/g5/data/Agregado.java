package pt.ulusofona.es.g5.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by nunonelas on 10/01/17.
 */
@Entity
public class Agregado implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String agregado1;

    @Column(nullable = false)
    private String agregado2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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