public enum EgzaminuTipai {

    OPP("Objektinio programavimo pagrindai"),
    ME("Matematikos egzaminas");


    String egzaminoPavadinimas;

    EgzaminuTipai(String egzaminoPavadinimas) {
        this.egzaminoPavadinimas = egzaminoPavadinimas;
    }

    public String getEgzaminoPavadinimas() {
        return egzaminoPavadinimas;
    }
}
