package noemip.dao;

import noemip.entities.Libro;
import noemip.entities.Prodotto;
import noemip.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdottoDao {
    private final EntityManager em;

    public ProdottoDao(EntityManager em) {
        this.em = em;
    }

    //findByISBN
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
    public List<Prodotto> findByYear(int annoPubblicazione){
        TypedQuery<Prodotto> getProductsByYear = em.createNamedQuery("findByYear", Prodotto.class);
        getProductsByYear.setParameter("annoPubblicazione", annoPubblicazione);
        return getProductsByYear.getResultList();
    }

    //findByAuthor
    public List<Prodotto> findByAuthor(String autore){
        TypedQuery<Prodotto> getProductsByAuthor = em.createNamedQuery("findByAuthor", Prodotto.class);
        getProductsByAuthor.setParameter("autore", autore);
        return getProductsByAuthor.getResultList();
    }

    //findByTitleOrPartialTitle
    public List<Prodotto> findByTitleOrPartialTitle(String partialtitle){
        TypedQuery<Prodotto> getProductsByTitle = em.createNamedQuery("findByTitle", Prodotto.class);
        getProductsByTitle.setParameter("partialtitle", partialtitle);
        return getProductsByTitle.getResultList();
    }

}
