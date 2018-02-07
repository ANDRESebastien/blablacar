package fr.blablacar.html.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.html.HTMLButtonElement;

import fr.blablacar.bean.Personne;
import fr.blablacar.bean.Trajet;
import fr.blablacar.html.form.ListeTrajetForm;
import fr.blablacar.html.form.ReservationForm;
import fr.blablacar.html.form.TrajetForm;
import fr.blablacar.service.PersonneService;
import fr.blablacar.service.TrajetService;

import javax.validation.Valid;

@Controller
public class TrajetController {

	@Autowired
	private PersonneService personneService;

	@Autowired
	private TrajetService trajetService;

	@GetMapping("/trajet")
	public String trajet(TrajetForm trajetForm) {
		System.out.println("TrajetController:trajet()");
		return "trajet";
	}

	@GetMapping("/reservation")
	public String reservation(TrajetForm trajetForm, Model model) {
		System.out.println("TrajetController:reservation()");
		return "reservation";
	}

	@PostMapping("/reservation")
	public String ajouterReservation(ReservationForm reservationForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("TrajetController:ajouterReservation() IdPersonne=" + reservationForm.getIdPersonne()
				+ " IdTrajet=" + reservationForm.getIdTrajet());
		return "reservation";
	}

	@PostMapping("/trajet")
	public String ajouterTrajet(@Valid TrajetForm trajetForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("TrajetController:ajouterTrajet()");

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
		return "trajet";
	}

	@GetMapping("/listetrajet")
	public String lister(ListeTrajetForm listeTrajetForm, Model model) {
		System.out.println("TrajetController:lister()");
		Iterable<Trajet> listeDeTrajet = trajetService.lister();
		
		
		
		model.addAttribute("listeDeTrajet", listeDeTrajet);
		return "listetrajet";
	}

	@PostMapping("/listetrajet")
	public String reserverUnTrajet(ListeTrajetForm listeTrajetForm, RedirectAttributes redirectAttributes, Model model) {
		System.out.println("TrajetController:reserverUnTrajet()");

		HTMLButtonElement bouton = listeTrajetForm.getBouton();
		System.out.println("bouton value=" + bouton.getValue());
		
		
		model.addAttribute("idPersonne", listeTrajetForm.getIdPersonne());
		model.addAttribute("idTrajet", listeTrajetForm.getIdTrajet());
		return "reservation";
	}
}