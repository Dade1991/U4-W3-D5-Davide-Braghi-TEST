package davidebraghi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Loan {
    @Id
    @GeneratedValue
    private UUID loanId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    private String loanedItem;
    private LocalDate forecastedItemReturnDate;
    private LocalDate actualItemRerunDate;

    // Costruttori

    public Loan() {
    }

    public Loan(UUID loanId,
                User user,
                String loanedItem,
                LocalDate forecastedItemReturnDate,
                LocalDate actualItemRerunDate) {
        this.loanId = loanId;
        this.user = user;
        this.loanedItem = loanedItem;
        this.forecastedItemReturnDate = forecastedItemReturnDate;
        this.actualItemRerunDate = actualItemRerunDate;
    }

    // Getter & Setter

    public UUID getLoanId() {
        return loanId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoanedItem() {
        return loanedItem;
    }

    public void setLoanedItem(String loanedItem) {
        this.loanedItem = loanedItem;
    }

    public LocalDate getForecastedItemReturnDate() {
        return forecastedItemReturnDate;
    }

    public void setForecastedItemReturnDate(LocalDate forecastedItemReturnDate) {
        this.forecastedItemReturnDate = forecastedItemReturnDate;
    }

    public LocalDate getActualItemRerunDate() {
        return actualItemRerunDate;
    }

    public void setActualItemRerunDate(LocalDate actualItemRerunDate) {
        this.actualItemRerunDate = actualItemRerunDate;
    }

    // toString


    @Override
    public String toString() {
        return "Loan Details: {" +
                "loanId=" + loanId +
                ", user=" + user +
                ", loanedItem='" + loanedItem + '\'' +
                ", forecastedItemReturnDate=" + forecastedItemReturnDate +
                ", actualItemRerunDate=" + actualItemRerunDate +
                '}';
    }
}
