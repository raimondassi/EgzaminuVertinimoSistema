

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    Configuration configuration = new Configuration();
    Servisai servisai = new Servisai();

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        if (args.length == 2) {
            String egzaminas = args[0];
            String atsakymuFailoPavadinimas = args[1];
            main.egzaminoVertinimas(egzaminas, atsakymuFailoPavadinimas);

        }
    }

    private void egzaminoVertinimas(String egzaminas, String atsakymuFailoPavadinimas) throws IOException {

        File egzaminoDirektorija = new File(configuration.egzaminuDirektorija + egzaminas + "/");
        File egzaminoTeiksingiAtsakymai = new File(configuration.atsakymuDirektorija + atsakymuFailoPavadinimas);
        if (egzaminoTeiksingiAtsakymai.exists() && egzaminoDirektorija.exists()) {
            servisai.vertinameEgzamina(egzaminoDirektorija, egzaminoTeiksingiAtsakymai, egzaminas);
        } else {
            System.out.println("Tokio egzamino nera arba, toks vertinimu failas neegzistuoja");
        }
    }


}
