package noemip.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name= "utente_tessera")
    private Utente utente;
    @OneToOne
    @JoinColumn(name= "prodotto_id")
    private Prodotto prodotto;

    private LocalDate inizioPrestito;
    private LocalDate restituzionePrevista;
    private LocalDate restituzioneEffettiva;

    //COSTRUTTORI

    public Prestito() {
    }

    public Prestito(Utente utente, Prodotto prodotto, LocalDate inizioPrestito, LocalDate restituzioneEffettiva) {
        this.utente = utente;
        this.prodotto = prodotto;
        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista = inizioPrestito.plusDays(30);
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    //GETTER E SETTER

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Prodotto getListaProdotti() {
        return prodotto;
    }

    public void setListaProdotti(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public long getId() {
        return id;
    }

    //METODI

    @Override
    public String toString() {
        return "Prestito{" +
                "Id Prestito: " + id +
                ", Utente: " + utente +
                ", Prodotto: " + prodotto +
                ", Data inizio prestito=" + inizioPrestito +
                ", Data restituzione prevista: " + restituzionePrevista +
                ", Data restituzione effettiva: " + restituzioneEffettiva +
                '}';
    }
}
