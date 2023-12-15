package noemip;

import noemip.dao.ProdottoDao;
import noemip.entities.Libro;
import noemip.entities.Periodicita;
import noemip.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliotecario");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ProdottoDao prodDAO = new ProdottoDao(em);

        Libro l1 = new Libro("The Help", 2009, 522, "Kathryn Stockett", "Romanzo");
        Libro l2 = new Libro("Alice nel Paese delle Meraviglie", 2021, 298, "Lewis Carroll", "Romanzo" );
        Rivista r1 = new Rivista("Doctor Who Magazine", 2023, 38, Periodicita.MENSILE);
        Rivista r2 = new Rivista("Focus", 2023, 65, Periodicita.MENSILE);

        //prodDAO.save(l1);
        //prodDAO.save(l2);
        //prodDAO.save(r1);
        //prodDAO.save(r2);

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
