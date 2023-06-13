import java.time.LocalDate;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati) {
        this.titolo = titolo;
        this.data = setData(data);
        this.postiTotali = setPostiTotali(postiTotali);
        this.postiPrenotati = 0;
    }

    public LocalDate setData(LocalDate data) {

        LocalDate localDate = LocalDate.now();

        try {
            if (data.isAfter(localDate)) {
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
}
