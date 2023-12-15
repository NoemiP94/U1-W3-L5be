package noemip;

import noemip.dao.PrestitoDAO;
import noemip.dao.ProdottoDao;
import noemip.dao.UtenteDAO;
import noemip.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliotecario");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ProdottoDao prodDAO = new ProdottoDao(em);
        UtenteDAO uDAO = new UtenteDAO(em);
        PrestitoDAO pDAO = new PrestitoDAO(em);


        Libro l1 = new Libro("The Help", 2009, 522, "Kathryn Stockett", "Romanzo");
        Libro l2 = new Libro("Alice nel Paese delle Meraviglie", 2021, 298, "Lewis Carroll", "Romanzo" );
        Rivista r1 = new Rivista("Doctor Who Magazine", 2023, 38, Periodicita.MENSILE);
        Rivista r2 = new Rivista("Focus", 2023, 65, Periodicita.MENSILE);

        //prodDAO.save(l1);
        //prodDAO.save(l2);
        //prodDAO.save(r1);
        //prodDAO.save(r2);


        Utente u1 = new Utente("Chris", "Martin", LocalDate.of(1977,3,2) );
        Utente u2 = new Utente("Tom", "Hiddleston", LocalDate.of(1981, 2,9) );
        Utente u3 = new Utente("Brie", "Larson", LocalDate.of(1989, 10, 1));
        Utente u4 = new Utente("Taylor", "Swift", LocalDate.of(1989,12,13));

        //uDAO.save(u1);
        //uDAO.save(u2);
        //uDAO.save(u3);
        //uDAO.save(u4);

        Utente chris = uDAO.findByCard(1);
        Utente tom = uDAO.findByCard(2);
        Utente brie = uDAO.findByCard(3);
        Utente taylor = uDAO.findByCard(4);

        Prodotto help = prodDAO.findByISBN("1b92ba4b-fc9a-49b1-b369-50794d625e95");
        Prodotto alice = prodDAO.findByISBN("6dcf4b6a-342c-414d-b0a4-227af2bf3ab6");
        Prodotto magaz = prodDAO.findByISBN("276e8345-d06f-44b3-ba91-51e68c7cc9fc");
        Prodotto focus = prodDAO.findByISBN("8e4f977e-53c3-4c16-9af6-797441b7d595");


        Prestito p1 = new Prestito(chris, help, LocalDate.of(2023,10,15),null);
        Prestito p2 = new Prestito(tom, alice, LocalDate.of(2023,11,10),LocalDate.of(2023,12,7));
        Prestito p3 = new Prestito(brie, magaz, LocalDate.of(2023, 9,12), LocalDate.of(2023, 10,23));
        Prestito p4 = new Prestito(taylor, focus, LocalDate.of(2023, 9,15), null);

        //pDAO.save(p1);
        //pDAO.save(p2);
        //pDAO.save(p3);
        //pDAO.save(p4);

        List<Prestito> prestitiScaduti = pDAO.getNotReturnedProducts();
        List<Prodotto> prodottiInPrestito = prodDAO.getProductsByCard(3);

        System.out.println("----------------------findByYear------------------------");
        prodDAO.findByYear(2009).forEach(System.out::println);
        System.out.println("----------------------findByAuthor----------------------------");
        prodDAO.findByAuthor("Lewis Carroll").forEach(System.out::println);
        System.out.println("----------------------findByTitleOrPartialTitle----------------------------");
        prodDAO.findByTitleOrPartialTitle("The").forEach(System.out::println);
        System.out.println("------Prestiti scaduti e non restituiti: ");
        for(Prestito prestito : prestitiScaduti){
            System.out.println("- ID prestito: " + prestito.getId() + ", Utente: " + prestito.getUtente().getNome() + " " + prestito.getUtente().getCognome());
        }

        System.out.println("------Prodotti in presito per numero tessera: ");
        for(Prodotto prodotto : prodottiInPrestito){
            System.out.println(prodotto);
        }

        em.close();
        emf.close();

    }
}
