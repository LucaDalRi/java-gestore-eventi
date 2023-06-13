import java.time.LocalDate;
import java.util.Scanner;

public class Main {

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

        String sceltaUtente = s1.next();

        if (sceltaUtente.equals("si")) {

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
    }
}
