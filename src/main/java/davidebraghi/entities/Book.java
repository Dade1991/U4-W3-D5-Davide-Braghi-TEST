package davidebraghi.entities;

import jakarta.persistence.Entity;

@Entity
public class Book extends Catalogue {
    protected String author;
    protected String genre;

    // Costruttori

    public Book() {
    }

    public Book(String title,
                Integer publishYear,
                Integer numberOfPages,
                String author,
                String genre) {
        super(title, publishYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    // Getter & Setter

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // toString

    @Override
    public String toString() {
        return "Books Details: {" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", catalogueId=" + catalogueId +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
