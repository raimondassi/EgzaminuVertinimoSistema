import com.fasterxml.jackson.annotation.JsonProperty;

public class Atsakymas {

    @JsonProperty("klausimas")
    Integer klausimas;

    @JsonProperty("atsakymas")
    String atsakymas;

    public Atsakymas() {
    }

    public Atsakymas(Integer klausimas, String atsakymas) {
        this.klausimas = klausimas;
        this.atsakymas = atsakymas;
    }

    public Integer getKlausimas() {
        return klausimas;
    }

    public void setKlausimas(Integer klausimas) {
        this.klausimas = klausimas;
    }

    public String getAtsakymas() {
        return atsakymas;
    }

    public void setAtsakymas(String atsakymas) {
        this.atsakymas = atsakymas;
    }

    @Override
    public String toString() {
        return "Atsakymas{" +
                "klausimas=" + klausimas +
                ", atsakymas=" + atsakymas +
                '}';
    }
}
