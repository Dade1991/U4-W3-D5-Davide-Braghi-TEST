package davidebraghi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Catalogue {
    @Id
    @GeneratedValue
    protected UUID catalogueId;
    protected String title;
    protected Integer publishYear;
    protected Integer numberOfPages;

    // Costruttori

    public Catalogue() {
    }

    public Catalogue(String title,
                     Integer publishYear,
                     Integer numberOfPages) {
        this.title = title;
        this.publishYear = publishYear;
        this.numberOfPages = numberOfPages;
    }

    // Getter & Setter

    public UUID getCatalogueId() {
        return catalogueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    // toString

    @Override
    public String toString() {
        return "Catalogue Details: {" +
                "catalogueId=" + catalogueId +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
