package davidebraghi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Magazine extends Catalogue {
    @Enumerated(EnumType.STRING)
    protected Frequency frequency;

    // Costruttori

    public Magazine() {
    }

    public Magazine(String title,
                    Integer publishYear,
                    Integer numberOfPages,
                    Frequency frequency) {
        super(title, publishYear, numberOfPages);
        this.frequency = frequency;
    }

    // Getter & Setter

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    // toString

    @Override
    public String toString() {
        return "Magazine Details: {" +
                "frequency=" + frequency +
                ", catalogueId=" + catalogueId +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
