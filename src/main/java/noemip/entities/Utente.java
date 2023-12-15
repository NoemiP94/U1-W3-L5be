package noemip.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private long numeroTessera;

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;


    @OneToMany(mappedBy= "utente")
    private List<Prestito> listaPrestiti;

    //COSTRUTTORI


    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    //GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }


    //METODI

    @Override
    public String toString() {
        return "Utente{" +
                "Nome: " + nome +
                ", Cognome: " + cognome +
                ", Data di nascita: " + dataDiNascita +
                ", Numero tessera: " + numeroTessera +
                '}';
    }
}
