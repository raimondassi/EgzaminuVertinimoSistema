import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ServisaiTest {

    private Servisai servisai;

    @Mock
    public StudentoAtsakymas studentoAtsakymas;
    public StudentoRezultatas studentoRezultatas;
    public TeisingiAtsakymai teisingiAtsakymai;
    public Configuration configuration;
    public Studentas studentas;
    public Egzaminas egzaminas;
    public Atsakymas atsakymas;
    public List<Atsakymas> atsakymai;
    private File egzaminuDirektorija;

    @BeforeEach
    public void setup() {
        servisai = new Servisai();
        configuration = new Configuration();
        List<Atsakymas> atsakymai = List.of(new Atsakymas(1, "a"), new Atsakymas(1, "b"));
        studentas = new Studentas(1234, "Kazys", "Kazlekas");
        egzaminas = new Egzaminas(123, "biologija", "testas");
        studentoAtsakymas = new StudentoAtsakymas(studentas, egzaminas, atsakymai);
        egzaminuDirektorija = new File(configuration.egzaminuDirektorija);
    }

    @Test
    public void testResultFileCreation() throws IOException {
        File file = servisai.sukuriameEgzaminoVertinimoFaila("matematika");
        assertEquals((configuration.vertinimuDirektorija + "matematika" + "Vertinimas.json"), file.toString());
        file.delete();
    }

    @Test
    public void testCorrectAnswers() {

    }

    @Test
    public void testArVisiAtsakymuFailaiSudetiISarasa() throws IOException {
        List<StudentoAtsakymas> sa = servisai.sudedameVisusAtsakymusISarasa(egzaminuDirektorija);
        Long studentuAtsakymuKiekis = sa.stream().count();
        Long failuKiekisDirektorijoje = (Files.walk(egzaminuDirektorija.toPath()))
                .filter(Files::isRegularFile)
                .count();
        assertEquals(failuKiekisDirektorijoje, studentuAtsakymuKiekis);
    }
}
