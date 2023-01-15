import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceZakaznku {
    private List<Zakaznik> zakaznikList = new ArrayList<>();
    public void vypisZeSouboru(String nazevSouboru, String oddelovac) throws MyException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(nazevSouboru)))) {
            while(scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] polozka = radek.split(oddelovac);
                String jmeno = polozka[0];
                int pocetProdeju = Integer.parseInt(polozka[1]);
                Zakaznik zakaznik = new Zakaznik(jmeno, pocetProdeju);
                zakaznikList.add(zakaznik);
            }
        } catch (FileNotFoundException e) {
            throw new MyException("Nastala chyba: ");
        }
    }
    public void zmenSoubor(String nazevSouboru, String oddelovac) throws MyException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nazevSouboru)))) {
            String radek;
            for (Zakaznik zakaznik : zakaznikList){
                radek = zakaznik.getJmeno() + oddelovac + zakaznik.getPocetProdeju();
                writer.println(radek);
            }
        } catch (IOException e) {
            throw new MyException("Nastala chyba: ");
        }
    }
    public List<Zakaznik> getList(){return new ArrayList<>(zakaznikList);}
    public void pridej(Zakaznik novyZakaznik){zakaznikList.add(novyZakaznik);}
    public void odeber(int index){zakaznikList.remove(index);}
}
