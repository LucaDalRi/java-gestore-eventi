import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati) {
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = setPostiTotali(postiTotali);
        this.postiPrenotati = 0;
    }

    public LocalDate setData(LocalDate data) {

        try {
            if (data.isAfter(formattatoreData(LocalDate.now()))) {
                this.data = data;
            }
        } catch (Exception e) {
            throw new RuntimeException("Data errata!");
        }
        return data;
    }

    private int setPostiTotali(int postiTotali) {
        try {
            if (postiTotali > 0) {
                this.postiTotali = postiTotali;
            }
        } catch (Exception e) {
            throw new RuntimeException("Dato errato!");
        }
        return postiTotali;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }


    // METODI

    private LocalDate formattatoreData(LocalDate data) {

        String localDate = String.valueOf(LocalDate.now());

        DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(localDate, formattatore);
    }

    public void prenota(int n) {

        if (this.postiPrenotati < this.postiTotali && data.isAfter(LocalDate.now())) {
            this.postiPrenotati += n;
        }
    }

    public void disdici(int n) {

        if (this.data.isBefore(LocalDate.now()) && this.postiPrenotati > 0) {
            this.postiPrenotati -= n;
        }
    }


    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data +
                '}';
    }
}
