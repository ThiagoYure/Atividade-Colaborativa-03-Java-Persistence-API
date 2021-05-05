package ifpb.edu.br.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Banda implements Serializable {

    private int id;
    private String localDeOrigem;
    private String nomeFantasia;
    private List<Integrante> integrantes;
    private Gerente gerente;

    public Banda() {
    }

    public Banda(int id, String localDeOrigem, String nomeFantasia, List<Integrante> integrantes, Gerente gerente) {
        this.id = id;
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
        this.integrantes = integrantes;
        this.gerente = gerente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banda)) return false;
        Banda banda = (Banda) o;
        return getId() == banda.getId() && Objects.equals(getLocalDeOrigem(), banda.getLocalDeOrigem()) && Objects.equals(getNomeFantasia(), banda.getNomeFantasia()) && Objects.equals(getIntegrantes(), banda.getIntegrantes()) && Objects.equals(getGerente(), banda.getGerente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocalDeOrigem(), getNomeFantasia(), getIntegrantes(), getGerente());
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", localDeOrigem='" + localDeOrigem + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", integrantes=" + integrantes +
                ", gerente=" + gerente +
                '}';
    }
}
