package noemip.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {

    @Id
    private String codiceISBN;
    private String titolo;
    private LocalDate annoPubblicazione;
    private int numeroPagine;

    @ManyToOne
    @JoinColumn(name = "prestito_id")
    private Prestito prestito;


    //COSTRUTTORI
    public Prodotto() {
    }

    public Prodotto(String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.codiceISBN = UUID.randomUUID().toString();
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //GETTER E SETTER

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
