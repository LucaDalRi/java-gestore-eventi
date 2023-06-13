import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainEvento {

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        System.out.println("Crea un nuovo evento");

        System.out.println("Inserisci il titolo evento");

        String titoloEvento = s1.nextLine();

        System.out.println("Inserisci la data: anno-giorno-mese");

        LocalDate dataEvento = LocalDate.parse(s1.nextLine());

        System.out.println("Inserisci i posti totali per l'evento");

        int postiEvento = s1.nextInt();

        System.out.println("Inserisci i posti già prenotati");

        int prenotatiEvento = s1.nextInt();

        Evento evento = new Evento(titoloEvento, dataEvento, postiEvento, prenotatiEvento);

        System.out.println("Vuoi prenotare dei posti? si / no");

        String sceltaUtentePrenotazione = s1.next();

        if (sceltaUtentePrenotazione.equals("si")) {

            System.out.println("Quanti posti vuoi prenotare?");

            int nrPrenotati = s1.nextInt();

            if ((evento.getPostiPrenotati() + nrPrenotati) < evento.getPostiTotali()) {

                evento.prenota(nrPrenotati);

                System.out.println("Posti prenotati totali: " + evento.getPostiPrenotati());
            } else {
                throw new RuntimeException("non puoi superare i posti massimi consentiti");
            }

        } else {
            System.out.println("Nessuna ulteriore prenotazione effettuata");

            System.out.println("Posti prenotati " + evento.getPostiPrenotati());

            System.out.println("Posti disponibili " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        }

        System.out.print("Vuoi disdire una o più prenotazioni? si / no");

        String sceltaUntenteDisdetta = s1.next();

        if (sceltaUntenteDisdetta.equals("si")) {

            System.out.println("Quante prenotazioni vuoi disdire?");

            int nrDisdette = s1.nextInt();

            if ((evento.getPostiPrenotati() - nrDisdette) > 0) {

                evento.disdici(nrDisdette);

                System.out.println("Hai disdetto " + nrDisdette + " posti");

                System.out.println("Prenotazioni ancora attive: " + (evento.getPostiPrenotati() - nrDisdette));

                System.out.println("Posti ancora disponibili: " + (evento.getPostiTotali() - (evento.getPostiPrenotati() - nrDisdette)));

            } else {
                throw new RuntimeException("Le disdette non possono essere più delle prenotazioni!");
            }

        } else {

            System.out.println("Nessuna ulteriore disdetta effettuata");

            System.out.println("Posti prenotati " + evento.getPostiPrenotati());

            System.out.println("Posti disponibili " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        }

        System.out.println("A che ora è il concerto? H:M");

        LocalTime ora = LocalTime.parse(s1.next());

        System.out.print("Inserisci il prezzo del concerto");

        BigDecimal prezzo = s1.nextBigDecimal();

        Concerto concerto = new Concerto(evento, ora, prezzo);

        System.out.println("Prezzo concerto: " + concerto.getPrezzo());

        System.out.println("Ora concerto: " + concerto.getOra());

    }
}
