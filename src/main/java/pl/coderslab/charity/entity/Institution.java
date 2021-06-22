package pl.coderslab.charity.entity;

import javax.persistence.*;

@Entity
@Table(name = "institution")
public class Institution {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;
@Column(name = "name")
    private String name;
@Column(name = "description")
    private String description;

    public Institution() {
    }

    public Institution(double id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
