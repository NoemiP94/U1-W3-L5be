package noemip.dao;

import noemip.entities.Prestito;
import noemip.entities.Prodotto;
import noemip.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public Prestito findById(long id) {
        return em.find(Prestito.class, id);
    }

    //save
    public void save(Prestito pr) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pr);
        transaction.commit();
        System.out.println("Prestito salvato correttamente!");
    }

    //delete
    public void findByIdAndDelete(long id) {
        Prestito found = em.find(Prestito.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Prestito eliminato correttamente!");
        } else {
            System.err.println("Il Prestito " + id + " non è stato trovato!");
        }
    }

    //ricerca degli elementi attualmente in prestito dato un numero di tessera utente
    /*public List<Prodotto> getProductsByCard(long numeroTessera){
        List<Prodotto> prodottiInPrestito = new ArrayList<>();

        List<Prestito> prestiti = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class).setParameter("numeroTessera", numeroTessera).getResultList();


        //per ogni prestito nella lista prestiti
        for(Prestito prestito : prestiti){
            if(prestito.getUtente().getNumeroTessera() == numeroTessera){  //se il numero della tessera inserito è uguale a quelli presenti
                prodottiInPrestito.addAll(prestito.getListaProdotti());
            }
        }
        return prodottiInPrestito;
    }*/

    //ricerca di tutti i prestiti scaduti e non ancora restituiti
    public List<Prestito> getNotReturnedProducts(){
        LocalDate today = LocalDate.now(); //crea data odierna
        List<Prestito> expired = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL AND p.restituzionePrevista < :today", Prestito.class) //cerca i prestiti in cui la restituzioneEffettiva è NULL e la restituzionePrevista è < della data odierna
                .setParameter("today", today)
                .getResultList();
        return expired;
    }
}
