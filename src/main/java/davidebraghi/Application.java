package davidebraghi;

import davidebraghi.dao.CatalogueDAO;
import davidebraghi.entities.Book;
import davidebraghi.entities.Catalogue;
import davidebraghi.entities.Frequency;
import davidebraghi.entities.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5-Davide-Braghi-TEST");

    private static CatalogueDAO getCatalogueDAO(EntityManager em) {
        CatalogueDAO catalDAO = new CatalogueDAO(em);

        Book item1 = new Book("Epicode bible", 2016, 400, "Lidia", "Horror");
        Book item2 = new Book("D&D Guide", 2025, 576, "Clara", "Gaming manual");
        Book item3 = new Book("How to riff like a demon", 2017, 335, "Davide", "Music theory");
        Magazine item4 = new Magazine("Come curare la noia", 2013, 80, Frequency.MONTHLY);
        Magazine item5 = new Magazine("Attack on Titan", 2017, 270, Frequency.SEMI_ANNUAL);
        Magazine item6 = new Magazine("PK", 2012, 120, Frequency.WEEKLY);

        // Spazio dedicato ai salvataggi ✅

//        catalDAO.save(item1);
//        catalDAO.save(item2);
//        catalDAO.save(item3);
//        catalDAO.save(item4);
//        catalDAO.save(item5);
//        catalDAO.save(item6);
        return catalDAO;
    }

    // Metodi dell'app ---------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogueDAO catalDAO = getCatalogueDAO(em);

        // Spazio dedicato alla ricerca di items per ID ✅

        Catalogue itemById = catalDAO.findByID(UUID.fromString("099fde2b-30f9-4f32-9d3a-5742be3f5db3"));
        System.out.println(itemById);

        // Spazio dedicato alla ricerca di items per anno di pubblicazione ✅

        List<Catalogue> yearSearchResults = catalDAO.findByReleaseYear(2017);
        System.out.println(yearSearchResults);

        // Spazio dedicato alla ricerca di items per autore o parte di esso ✅

        List<Catalogue> authorSearchResults = catalDAO.findByAuthor("Clara");
        System.out.println(authorSearchResults);

        // Spazio dedicato alla ricerca di items per titolo o parte di esso ✅

        List<Catalogue> titleSearchResults = catalDAO.findByTitle(("code"));
        System.out.println(titleSearchResults);

        // Spazio dedicato alla ricerca & rimozione di items ✅

        catalDAO.findAndDeleteByID(UUID.fromString("099fde2b-30f9-4f32-9d3a-5742be3f5db3"));

        // Chiusura default em & emf
        em.close();
        emf.close();
    }


}
