package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Double> {
    @Query("SELECT SUM(donation.quantity) FROM Donation donation")
    Integer sumOfBugs();
}
