package noemip.dao;

import noemip.entities.Libro;
import noemip.entities.Prodotto;
import noemip.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProdottoDao {
    private final EntityManager em;

    //findByISBN
    public ProdottoDao(EntityManager em) {
        this.em = em;
    }

    public Prodotto findByISBN(String isbn){
        return em.find(Prodotto.class, isbn);
    }

    public Libro findBookByISBN(String isbn){
        return em.find(Libro.class, isbn);
    }

    public Rivista findMagazineByISBN(String isbn){
        return em.find(Rivista.class, isbn);
    }

    //save
    public void save(Prodotto p){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Prodotto salvato correttamente!");
    }

    //delete
    public void findByISBNandDelete(String isbn){
        Prodotto found = em.find(Prodotto.class, isbn);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Prodotto eliminato correttamente!");
        }else{
            System.err.println("Il prodotto con " + isbn + " non è stato trovato!");
        }
    }

    //findByYear



}
