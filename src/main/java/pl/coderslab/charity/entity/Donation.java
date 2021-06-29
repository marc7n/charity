package pl.coderslab.charity.entity;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Quantity cannot be empty")
    @Min(value = 1, message = "Minimum quantity is 1")
    @Column(name = "quantity")
    private int quantity;

    @NotEmpty(message = "Categories canont be empty")
    @ManyToMany
    private List<Category> categories;

    @NotNull(message = "Institution canont be empty")
    @ManyToOne
    private Institution institution;

    @NotBlank(message = "Street name cannot be empty")
    @Column(name = "street")
    private String street;

    @NotBlank(message = "City name cannot be empty")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Zip code cannot be empty")
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull(message = "Pick up date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;

    @NotNull(message = "Pick up time cannot be empty")
    @DateTimeFormat(pattern = "H:mm")
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;

    @Size(max = 255, message = "Pick up comment should have maximum 255 characters")
    @Column(name = "pick_up_comment", columnDefinition = "varchar(255) default ''")
    private String pickUpComment;

    @Size(min = 9, max = 15)
    @NotBlank(message = "Phone number cannot be empty")
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    public Donation() {
    }

    public Donation(Integer quantity,
                    List<Category> categories,
                    Institution institution,
                    String street,
                    String city,
                    String zipCode,
                    LocalDate pickUpDate,
                    LocalTime pickUpTime,
                    String pickUpComment,
                    String phoneNumber) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public Donation setId(Long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Donation setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Donation setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Donation setInstitution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Donation setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Donation setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Donation setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public Donation setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public Donation setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
        return this;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public Donation setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Donation setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", categories=" + categories +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}