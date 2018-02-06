package fr.blablacar.html.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.blablacar.bean.Personne;
import fr.blablacar.html.form.PersonneCreationForm;
import fr.blablacar.service.PersonneService;

import javax.validation.Valid;

@Controller
public class PersonneCreationController {

	@Autowired
	private PersonneService personneService;

	@GetMapping("/")
	public String showForm(PersonneCreationForm personneCreationForm) {
		System.out.println("PersonneCreationController:showForm()");
		return "inscription";
	}

	@PostMapping("/")
	public String ajouter(@Valid PersonneCreationForm personneCreationForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("PersonneCreationController:ajouter()");

		if (bindingResult.hasErrors()) {
			System.out.println("-> erreur technique");
			// Erreur bas niveau, retour sur la page
			return "inscription";
		}

		// Controle métier
		Personne personne = personneService.ajouter(personneCreationForm.getNom(), personneCreationForm.getLogin(),
				personneCreationForm.getPassword());
		
		if (personne == null) {
			System.out.println("-> email déjà présent en base");
			//redirectAttributes.addFlashAttribute("message", "email déjà présent en base");
			model.addAttribute("emailEnBase", "Email déjà présent en base");
			return "inscription";
		}

		// Si OK passage à la page suivante avec argument
		redirectAttributes.addAttribute("idPersonne", personne.getIdPersonne());
		return "redirect:/acceuil";
	}

	@GetMapping("/acceuil")
	public String acceuil(@ModelAttribute("idPersonne") Long idPersonne, Model model) {
		System.out.println("PersonneCreationController:acceuil()");
		Personne personne = personneService.rechercher(idPersonne);
		model.addAttribute("personne", personne);
		return "acceuil";
	}
}
