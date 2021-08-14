import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentoRezultatas extends Studentas{

    @JsonProperty("ivertinimas")
    Integer ivertinimas;

    public Integer getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(Integer ivertinimas) {
        this.ivertinimas = ivertinimas;
    }
}
