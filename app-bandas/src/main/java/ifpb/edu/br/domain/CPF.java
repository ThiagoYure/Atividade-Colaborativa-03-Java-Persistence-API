package ifpb.edu.br.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CPF implements Serializable {
    private static final int TAMANHO = 11;
    @Column(name = "cpf", unique= true)
    private String numero;

    public CPF() {
    }

    public CPF(String numero) {
        this.numero = numero;
    }

    public boolean isValido() {
        return this.numero.length() == TAMANHO;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static int getTAMANHO() {
        return TAMANHO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(getNumero(), cpf.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "CPF{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
