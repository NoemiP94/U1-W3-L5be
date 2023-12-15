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
    @JoinColumn(name= "utente_id")
    private Utente utente;
    @OneToMany(mappedBy= "prestito")
    private List<Prodotto> listaProdotti;

    private LocalDate inizioPrestito;
    private LocalDate restituzionePrevista;
    private LocalDate restituzioneEffettiva;

    //COSTRUTTORI

    public Prestito() {
    }

    public Prestito(Utente utente, List<Prodotto> listaProdotti, LocalDate inizioPrestito, LocalDate restituzioneEffettiva) {
        this.utente = utente;
        this.listaProdotti = listaProdotti;
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

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
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

    //METODI

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", listaProdotti=" + listaProdotti +
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                '}';
    }
}
