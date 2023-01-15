public class Main {
    public static void main(String[] args) {
        EvidenceZakaznku ev = new EvidenceZakaznku();
        try {
            ev.vypisZeSouboru("text.txt", ":");
        } catch (MyException e) {
            System.err.println("Musíte zvolit správný soubor. " + e.getLocalizedMessage());
        }
        for (Zakaznik zakaznik: ev.getList()){
            System.out.println(zakaznik.getJmeno() + " " + zakaznik.getPocetProdeju() );

        }
        ev.pridej(new Zakaznik("Karel Josef", 20));
        ev.pridej(new Zakaznik("Tomáš Dědek", 39));
        ev.odeber(1);
        try {
            ev.zmenSoubor("text.txt", ":");
        } catch (MyException e) {
            System.err.println("Musíte zvolit správný soubor. " + e.getLocalizedMessage());
        }
    }
}