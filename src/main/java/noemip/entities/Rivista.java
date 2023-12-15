package noemip.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Rivista extends Prodotto{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    //COSTUTTORI

    public Rivista() {
    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    //GETTER E SETTER

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    //METODI

    @Override
    public String toString() {
        return "Rivista{" +
                "CodiceISBN: " + getCodiceISBN() +
                ", Titolo: " + getTitolo() +
                ", Anno Pubblicazione: " + getAnnoPubblicazione() +
                ", Numero pagine: " + getNumeroPagine() +
                ", Periodicita: " + periodicita +
                '}';
    }
}
