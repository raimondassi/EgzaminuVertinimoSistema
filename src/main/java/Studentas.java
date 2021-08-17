import com.fasterxml.jackson.annotation.JsonProperty;

public class Studentas {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("vardas")
    private String vardas;

    @JsonProperty("pavarde")
    private String pavarde;

    public Studentas() {
    }

    public Integer getId() {
        return id;
    }

    public Studentas(Integer id, String vardas, String pavarde) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                '}';
    }
}
