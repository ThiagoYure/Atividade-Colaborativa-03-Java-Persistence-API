package ifpb.edu.br.domain;

import ifpb.edu.br.infra.converters.CpfConverterJPA;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Gerente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    //@OneToOne(mappedBy = "gerente")
    private Banda banda;
    @Column
    private String email;
    @Convert(converter = CpfConverterJPA.class)
    private CPF cpf = new CPF("");

    public Gerente() {
    }

    public Gerente(int id, String nome, Banda banda, String email, CPF cpf) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.email = email;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gerente)) return false;
        Gerente gerente = (Gerente) o;
        return getId() == gerente.getId() && Objects.equals(getNome(), gerente.getNome()) && Objects.equals(getBanda(), gerente.getBanda()) && Objects.equals(getEmail(), gerente.getEmail()) && Objects.equals(getCpf(), gerente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getBanda(), getEmail(), getCpf());
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", banda=" + banda +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
