package noemip.dao;

import noemip.entities.Prestito;
import noemip.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
