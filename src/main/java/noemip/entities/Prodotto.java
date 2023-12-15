package noemip.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name= "findByYear", query="SELECT p FROM Prodotto p WHERE p.annoPubblicazione = :annoPubblicazione ")
@NamedQuery(name= "findByAuthor", query= "SELECT p FROM Prodotto p WHERE p.autore = :autore")
@NamedQuery(name= "findByTitle", query= "SELECT p FROM Prodotto p WHERE LOWER(p.titolo) LIKE LOWER(CONCAT(:partialtitle, '%'))")
public abstract class Prodotto {

    @Id
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    @ManyToOne
    @JoinColumn(name = "prestito_id")
    private Prestito prestito;


    //COSTRUTTORI
    public Prodotto() {
    }

    public Prodotto(String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = UUID.randomUUID().toString();
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //GETTER E SETTER

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }


}
