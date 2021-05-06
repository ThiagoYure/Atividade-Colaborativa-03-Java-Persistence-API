package ifpb.edu.br.domain;

import ifpb.edu.br.infra.converters.CpfConverterJPA;
import ifpb.edu.br.infra.converters.LocaldateConverterJPA;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Integrante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Convert(converter = LocaldateConverterJPA.class)
    private LocalDate dataDeNascimento;
    @Embedded
    private CPF cpf = new CPF("");

    public Integrante() {
    }

    public Integrante(int id, String nome, LocalDate dataDeNascimento, CPF cpf) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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
        if (!(o instanceof Integrante)) return false;
        Integrante that = (Integrante) o;
        return getId() == that.getId() && Objects.equals(getNome(), that.getNome()) && Objects.equals(getDataDeNascimento(), that.getDataDeNascimento()) && Objects.equals(getCpf(), that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDataDeNascimento(), getCpf());
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", cpf=" + cpf +
                '}';
    }
}
