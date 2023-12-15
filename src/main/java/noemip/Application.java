package noemip;

import noemip.dao.ProdottoDao;
import noemip.dao.UtenteDAO;
import noemip.entities.Libro;
import noemip.entities.Periodicita;
import noemip.entities.Rivista;
import noemip.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliotecario");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ProdottoDao prodDAO = new ProdottoDao(em);
        UtenteDAO uDAO = new UtenteDAO(em);


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


        System.out.println("----------------------findByYear------------------------");
        prodDAO.findByYear(2009).forEach(System.out::println);
        System.out.println("----------------------findByAuthor----------------------------");
        prodDAO.findByAuthor("Lewis Carroll").forEach(System.out::println);
        System.out.println("----------------------findByTitleOrPartialTitle----------------------------");
        prodDAO.findByTitleOrPartialTitle("The").forEach(System.out::println);

        em.close();
        emf.close();

    }
}
