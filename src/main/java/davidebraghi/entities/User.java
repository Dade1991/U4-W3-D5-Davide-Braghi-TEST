package davidebraghi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue
    @OneToMany
    private UUID userId;
    private String name;
    private String surname;
    private LocalDate birthday;

    // Costruttori

    public User() {
    }

    public User(UUID userId,
                String name,
                String surname,
                LocalDate birthday) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    // Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // toString

    @Override
    public String toString() {
        return "User Details: {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
