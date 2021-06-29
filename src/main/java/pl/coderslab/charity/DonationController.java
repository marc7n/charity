package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepository.findAll();
    }


    @PostMapping("/form")
    public String donationAddFormPerform(@Valid Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        if (donation.getQuantity() <= 0) {
            bindingResult.addError(new ObjectError("Quantity", "Quantity should be more than 0"));
            return "form";
        }

        donationRepository.save(donation);

        return "form-confirmation";
    }
}
