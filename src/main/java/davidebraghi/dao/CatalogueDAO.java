package davidebraghi.dao;

import davidebraghi.entities.Catalogue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CatalogueDAO {
    private EntityManager em;

    public CatalogueDAO(EntityManager em) {
        this.em = em;
    }

    // Salvataggio di un nuovo item nel Catalogue

    public void save(Catalogue newItem) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(newItem);
            transaction.commit();
            System.out.println("Book " + newItem.getCatalogueId() + " duly saved in our System.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Ricerca di un item per ID

    public Catalogue findByID(UUID catalogueId) {
        try {
            Catalogue foundItem = em.find(Catalogue.class, catalogueId);
            if (foundItem != null) {
                return foundItem;
            } else {
                System.out.println("Item not found. Please try again.");
            }
        } catch (Exception ex) {
            System.out.println("Error during search: " + ex.getMessage());
        }
        return null;
    }

    // Ricerca di un item per anno di pubblicazione

    public List<Catalogue> findByReleaseYear(Integer publishYear) {
        try {
            TypedQuery<Catalogue> query = em.createQuery("SELECT c FROM Catalogue c WHERE c.publishYear =:year", Catalogue.class);
            query.setParameter("year", publishYear);
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error during search: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    // Ricerca di un item per autore

    public List<Catalogue> findByAuthor(String author) {
        try {
            TypedQuery<Catalogue> query = em.createQuery("SELECT c FROM Catalogue c WHERE c.author LIKE :author", Catalogue.class);
            query.setParameter("author", "%" + author + "%");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error during search: " + ex.getMessage());
        }
        return null;
    }

    // Ricerca di un item per titolo o parte di esso

    public List<Catalogue> findByTitle(String title) {
        try {
            TypedQuery<Catalogue> query = em.createQuery("SELECT c FROM Catalogue c WHERE c.title LIKE :title", Catalogue.class);
            query.setParameter("title", "%" + title + "%");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error during search: " + ex.getMessage());
        }
        return null;
    }

    // Ricerca & rimozione di un item tramite ID

    public void findAndDeleteByID(UUID catalogueId) {
        try {
            EntityTransaction transaction = em.getTransaction();
            Catalogue foundItem = em.find(Catalogue.class, catalogueId);
            if (foundItem != null) {
                transaction.begin();
                em.remove(foundItem);
                transaction.commit();
                System.out.println("Item duly deleted");
            } else {
                System.out.println("Item not founded. Please try again.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
