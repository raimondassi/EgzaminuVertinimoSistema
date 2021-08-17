import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentoRezultatas extends Studentas{

    @JsonProperty("ivertinimas")
    Integer ivertinimas;

    public StudentoRezultatas() {
    }

    public StudentoRezultatas(Integer ivertinimas, Integer id, String vardas, String pavarde) {
        super(id, vardas, pavarde);
        this.ivertinimas = ivertinimas;

    }



    public Integer getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(Integer ivertinimas) {
        this.ivertinimas = ivertinimas;
    }
}
