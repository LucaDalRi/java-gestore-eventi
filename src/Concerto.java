import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(Evento evento, LocalTime ora, BigDecimal prezzo) {
        super(evento);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    private void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    private void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
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
