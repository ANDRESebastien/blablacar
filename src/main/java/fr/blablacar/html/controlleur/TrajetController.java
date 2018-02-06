package fr.blablacar.html.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.blablacar.bean.Personne;
import fr.blablacar.html.form.TrajetForm;
import fr.blablacar.service.PersonneService;

import java.util.Date;

import javax.validation.Valid;

@Controller
public class TrajetController {

	@Autowired
	private PersonneService personneService;

	@GetMapping("/trajet")
	public String showForm(TrajetForm trajetForm) {
		System.out.println("TrajetController:showForm()");
		return "trajet";
	}

	@PostMapping("/trajet")
	public String ajouter(@Valid TrajetForm trajetForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("TrajetController:ajouter()");

		if (bindingResult.hasErrors()) {
			System.out.println("-> erreur technique");
			// Erreur bas niveau, retour sur la page
			return "trajet";
		}
		
		// Controle métier
		Personne personne = personneService.ajouterTrajet(trajetForm.getIdPersonne(), trajetForm.getNombrePlace(),
				trajetForm.getVilleDepart(), trajetForm.getVilleArrive());

		if (personne == null) {
			model.addAttribute("message", "Aucun utilisateur connecté");
			return "trajet";
		}

		// Si OK passage à la page suivante avec argument
		model.addAttribute("message", "Trajet ajouté");
		return "redirect:/trajet";
	}
}