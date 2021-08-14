import com.fasterxml.jackson.annotation.JsonProperty;

public class Egzaminas {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("pavadinimas")
    private String pavadinimas;

    @JsonProperty("tipas")
    private String tipas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    @Override
    public String toString() {
        return "Egzaminas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", tipas='" + tipas + '\'' +
                '}';
    }
}

