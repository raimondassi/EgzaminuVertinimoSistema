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
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ServisaiTest {


    private Servisai servisai;
   public List<Atsakymas> atsakymai;

    @Mock
    public StudentoAtsakymas studentoAtsakymas;
    public StudentoRezultatas studentoRezultatas;
    public TeisingiAtsakymai teisingiAtsakymai;
    public Configuration configuration;
    public Studentas studentas;
    public Egzaminas egzaminas;
    public Atsakymas atsakymas;



    @BeforeAll
    public  void pasikuriameAtsakymuFaila(){
      //  atsakymai=List.of()
 studentas=new Studentas(1234, "Kazys", "Kazlekas");
 egzaminas=new Egzaminas(123, "biologija", "testas");

//studentoAtsakymas=new StudentoAtsakymas(Studentas studentas, Egzaminas egzaminas, List<Atsakymas> atsakymai)


    }




    @BeforeEach
    public void setup(){
        servisai=new Servisai();
        configuration=new Configuration();
    }


    @Test
    public void testResultFileCreation() throws IOException {
      File file=  servisai.sukuriameEgzaminoVertinimoFaila("matematika");
      assertEquals((configuration.vertinimuDirektorija + "matematika" + "Vertinimas.json"), file.toString());
      file.delete();
    }



}