package fr.blablacar.html.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.blablacar.bean.Personne;
import fr.blablacar.html.form.InscriptionForm;
import fr.blablacar.service.PersonneService;

import javax.validation.Valid;

@Controller
public class PersonneController {

	@Autowired
	private PersonneService personneService;

	@GetMapping({ "/", "/inscription" })
	public String inscription(InscriptionForm inscriptionForm, Model model) {
		return "inscription";
	}

	@PostMapping({ "/", "/inscription" })
	public String ajouterInscription(@Valid InscriptionForm inscriptionForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("PersonneCreationController:ajouterInscription()");

		if (bindingResult.hasErrors()) {
			System.out.println("-> erreur technique : " + bindingResult.getAllErrors());
			// log.error("errors = " + bindingResult.getAllErrors());
			// Erreur bas niveau, retour sur la page
			return "inscription";
		}

		// Controle métier

		Personne personne = personneService.ajouter(inscriptionForm.getNom(), inscriptionForm.getLogin(),
				inscriptionForm.getPassword());

		if (personne == null) {
			System.out.println("-> email déjà présent en base");
			// redirectAttributes.addFlashAttribute("message", "email déjà présent en
			// base");
			model.addAttribute("emailEnBase", "Email déjà présent en base");
			return "inscription";
		}

		// Si OK passage à la page suivante avec argument
		String numPersonne = String.valueOf(personne.getIdPersonne());
		return "redirect:/acceuil";
	}
}
