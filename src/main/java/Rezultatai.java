import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Rezultatai {

    @JsonProperty("egzaminas")
    Egzaminas egzaminas;

    @JsonProperty("studentoRezultatai")
    List<StudentoRezultatas> studentoRezultatas;

    public Rezultatai(Egzaminas egzaminas, List<StudentoRezultatas> studentoRezultatas) {
        this.egzaminas = egzaminas;
        this.studentoRezultatas = studentoRezultatas;
    }

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public List<StudentoRezultatas> getStudentoRezultatas() {
        return studentoRezultatas;
    }

    public void setStudentoRezultatas(List<StudentoRezultatas> studentoRezultatas) {
        this.studentoRezultatas = studentoRezultatas;
    }
}
