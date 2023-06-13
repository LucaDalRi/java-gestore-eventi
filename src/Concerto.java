import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(Evento evento, LocalTime ora, BigDecimal prezzo) {
        super(evento);
        this.ora = LocalTime.parse(formattaOra());
        this.prezzo = formattaPrezzo(prezzo);
    }

    public LocalTime getOra() {
        return ora;
    }

    private void setOra(LocalTime ora) {
        if (this.ora.isAfter(LocalTime.now())) {
            this.ora = ora;
        } else {
            throw new DateTimeException("L'orario inserito non può essere precedente a quello attuale");
        }
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    private void setPrezzo(BigDecimal prezzo) {
        if (prezzo.intValue() > 0) {
            this.prezzo = prezzo;
        } else {
            throw new RuntimeException("Prezzo non valido");
        }
    }


    private String formattaOra() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

        return this.ora.format(formatter);

    }

    private BigDecimal formattaPrezzo(BigDecimal prezzo) {

        String formattato = new DecimalFormat("#,###.00").format(prezzo);

        return new BigDecimal(formattato);
    }


    @Override
    public String toString() {
        return "Concerto{" + "data" + super.getData() +
                "ora=" + ora + "titolo" + super.getTitolo() +
                ", prezzo=" + prezzo +
                '}';
    }
}
