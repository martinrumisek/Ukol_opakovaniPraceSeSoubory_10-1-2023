import java.io.IOException;

public class Zakaznik {
    private String jmeno;
    private int pocetProdeju;

    public Zakaznik(String jmeno, int pocetProdeju) {
        this.jmeno = jmeno;
        this.pocetProdeju = pocetProdeju;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getPocetProdeju() {
        return pocetProdeju;
    }

    public void setPocetProdeju(int pocetProdeju) {
        this.pocetProdeju = pocetProdeju;
    }

    public void zvysPocetProdeju(int pocet){
        try{
            if (pocet <= 0){
                throw new IOException();
            }else {
                pocetProdeju =+ pocet;
            }
        }catch (IOException e){
            System.err.println("Nemužete počet prodejů zvýšit o záporné číslo");
        }
    }
}
