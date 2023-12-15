package noemip.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Libro extends Prodotto{
    private String autore;
    private String genere;

    //COSTRUTTORE

    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //GETTER E SETTER

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    //METODI

    @Override
    public String toString() {
        return "Libro{" +
                "CodiceISBN: " + getCodiceISBN() +
                ", Titolo: " + getTitolo() +
                ", Anno pubblicazione: " + getAnnoPubblicazione() +
                ", Numero pagine: " + getNumeroPagine() +
                ", Autore: " + autore +
                ", Genere: " + genere +
                '}';
    }
}
