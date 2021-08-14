import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentoAtsakymas {

    @JsonProperty("studentas")
    Studentas studentas;

    @JsonProperty("egzaminas")
    Egzaminas egzaminas;

    @JsonProperty("atsakymai")
    List<Atsakymas> atsakymai;

    public StudentoAtsakymas() {
    }

    public StudentoAtsakymas(Studentas studentas, Egzaminas egzaminas, List<Atsakymas> atsakymai) {
        this.studentas = studentas;
        this.egzaminas = egzaminas;
        this.atsakymai = atsakymai;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public List<Atsakymas> getAtsakymai() {
        return atsakymai;
    }

    public void setAtsakymai(List<Atsakymas> atsakymai) {
        this.atsakymai = atsakymai;
    }

    @Override
    public String toString() {
        return "StudentoAtsakymas{" +
                "studentas=" + studentas +
                ", egzaminas=" + egzaminas +
                ", atsakymai=" + atsakymai +
                '}';
    }
}
