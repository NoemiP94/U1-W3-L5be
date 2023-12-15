package noemip.dao;

import noemip.entities.Libro;
import noemip.entities.Prodotto;
import noemip.entities.Rivista;
import noemip.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public Utente findByCard(long numeroTessera){
        return em.find(Utente.class, numeroTessera);
    }

    //save
    public void save(Utente u){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(u);
        transaction.commit();
        System.out.println("Utente salvato correttamente!");
    }

    //delete
    public void findByCardAndDelete(long numeroTessera){
        Utente found = em.find(Utente.class, numeroTessera);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Utente eliminato correttamente!");
        }else{
            System.err.println("L'Utente " + numeroTessera + " non è stato trovato!");
        }
    }




}
