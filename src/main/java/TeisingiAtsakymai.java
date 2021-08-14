import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeisingiAtsakymai {

    @JsonProperty("egzaminas")
    Egzaminas egzaminas;

    @JsonProperty("atsakymai")
    List<Atsakymas> atsakymai;

    public TeisingiAtsakymai(Egzaminas egzaminas, List<Atsakymas> atsakymai) {
        this.egzaminas = egzaminas;
        this.atsakymai = atsakymai;
    }

    public TeisingiAtsakymai() {

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
}

