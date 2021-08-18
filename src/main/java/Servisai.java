import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Servisai {
    List<StudentoAtsakymas> studentuAtsakymai = new ArrayList<>();
    List<Rezultatai> rezultatai = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    Configuration configuration = new Configuration();

    public void vertinameEgzamina(File egzaminoDirektorija, File egzaminoTeisingiAtsakymai, String egzaminas) {
        File egzaminoVertinimas = null;
        egzaminoVertinimas = sukuriameEgzaminoVertinimoFaila(egzaminas);
        sudedameVisusAtsakymusISarasa(egzaminoDirektorija);
        Rezultatai rezultatai = ivertinameAtsakymus(egzaminoTeisingiAtsakymai);
        surasomeIRezultatuFaila(egzaminoVertinimas, rezultatai);
        System.out.println(egzaminoVertinimas.getName() + " failas sukurtas");
    }

    public void surasomeIRezultatuFaila(File egzaminoVertinimas, Rezultatai rezultatai) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(egzaminoVertinimas, rezultatai);
        } catch (IOException e) {
            System.out.println("Nerastas failas ar direktorija" + e);
        }
    }

    public Rezultatai ivertinameAtsakymus(File egzaminoTeisingiAtsakymai) {
        TeisingiAtsakymai teisingiAtsakymai = null;
        try {
            teisingiAtsakymai = mapper.readValue(egzaminoTeisingiAtsakymai, TeisingiAtsakymai.class);
        } catch (IOException e) {
            System.out.println("Nerastas failas ar direktorija" + e);
        }
        List<StudentoRezultatas> studentoRezultatai = new ArrayList<>();
        Integer teisinguAtsakymuKiekis = 0;
        Integer atsakymuKiekis = 0;
        Rezultatai rezultatai = new Rezultatai(new Egzaminas(), studentoRezultatai);
        rezultatai.getEgzaminas().setId(teisingiAtsakymai.getEgzaminas().getId());
        rezultatai.getEgzaminas().setPavadinimas(teisingiAtsakymai.getEgzaminas().getPavadinimas());
        for (StudentoAtsakymas s : studentuAtsakymai) {
            StudentoRezultatas studentoRezultatas = new StudentoRezultatas();
            studentoRezultatas.setId(s.getStudentas().getId());
            studentoRezultatas.setVardas(s.getStudentas().getVardas());
            studentoRezultatas.setPavarde(s.getStudentas().getPavarde());
            for (Atsakymas a : s.getAtsakymai()) {
                atsakymuKiekis++;
                for (Atsakymas t : teisingiAtsakymai.getAtsakymai()) {
                    if (a.getKlausimas().equals(t.getKlausimas()) && a.getAtsakymas().equals(t.getAtsakymas())) {
                        teisinguAtsakymuKiekis++;
                    }
                }
            }
            studentoRezultatas.setIvertinimas(Math.round(teisinguAtsakymuKiekis.floatValue() / atsakymuKiekis.floatValue() * 10));
            atsakymuKiekis = 0;
            teisinguAtsakymuKiekis = 0;
            studentoRezultatai.add(studentoRezultatas);
        }
        rezultatai.setStudentoRezultatas(studentoRezultatai);
        return rezultatai;
    }

    public File sukuriameEgzaminoVertinimoFaila(String egzaminas) {
        File egzaminoVertinimoFailas = new File(configuration.vertinimuDirektorija + egzaminas + "Vertinimas.json");
        if (!egzaminoVertinimoFailas.exists()) {
            try {
                egzaminoVertinimoFailas.createNewFile();
            } catch (IOException e) {
                System.out.println("Nerastas failas ar direktorija" + e);
            }
        }
        return egzaminoVertinimoFailas;
    }

    public List<StudentoAtsakymas> sudedameVisusAtsakymusISarasa(File egzaminoDirektorija) {
        Stream<Path> paths = Stream.of();
        try {
            paths = Files.walk(Paths.get(egzaminoDirektorija.toURI()));
        } catch (IOException e) {
            System.out.println("Nerastas failas ar direktorija" + e);
        }
        paths
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    try {
                        studentuAtsakymai.add(mapper.readValue(path.toFile(), StudentoAtsakymas.class));
                    } catch (IOException e) {
                        System.out.println("negalimas nuskaitymas nes bloga nuoroda" + e);;
                    }
                });
        return studentuAtsakymai;
    }
}






