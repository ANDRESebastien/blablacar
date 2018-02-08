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
import fr.blablacar.bean.Trajet;
import fr.blablacar.html.form.ListeTrajetForm;
import fr.blablacar.html.form.ReservationForm;
import fr.blablacar.html.form.TrajetForm;
import fr.blablacar.service.PersonneService;
import fr.blablacar.service.TrajetService;

import java.security.Principal;

import javax.validation.Valid;

@Controller
public class TrajetController {

	@Autowired
	private PersonneService personneService;

	@Autowired
	private TrajetService trajetService;

	@GetMapping("/trajet")
	public String trajet(TrajetForm trajetForm, Model model) {
		System.out.println("TrajetController:trajet()");
		model.addAttribute("idPersonne", trajetForm.getIdPersonne());
		return "trajet";
	}

	@GetMapping("/reservation")
	public String reservation(ReservationForm reservationForm, Model model,
			@ModelAttribute("idPersonne") String idPersonne, @ModelAttribute("idTrajet") String idTrajet) {

		System.out.println("TrajetController:reservation() idPersonne=" + idPersonne + " idTrajet=" + idTrajet);

		try {
			long identifiantPersonne = Long.parseLong(idPersonne);
			long identifiantTrajet = Long.parseLong(idTrajet);

			if (identifiantPersonne > 0 && identifiantTrajet > 0) {
				reservationForm.setIdPersonne(identifiantPersonne);
				reservationForm.setIdTrajet(identifiantTrajet);

				Personne personne = personneService.rechercher(identifiantPersonne);
				Trajet trajet = trajetService.rechercher(identifiantTrajet);

				if (trajet.getConducteur().getIdPersonne() == personne.getIdPersonne()) {
					reservationForm.setVilleDepart(trajet.getVilleDepart());
					reservationForm.setVilleArrive(trajet.getVilleArrive());
					reservationForm.setNombrePlace(trajet.getNombrePlace());
					reservationForm.setNombrePlaceReserve(1);
					return "reservation";
				}
			}
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return "redirect:/";
		}
		//model.addAttribute("idPersonne", idPersonne);
		return "redirect:/listetrajet";
	}

	@PostMapping("/reservation")
	public String ajouterReservation(ReservationForm reservationForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("TrajetController:ajouterReservation() IdPersonne=" + reservationForm.getIdPersonne()
				+ " IdTrajet=" + reservationForm.getIdTrajet());
		
		
		Personne personne = personneService.rechercher(reservationForm.getIdPersonne());
		Trajet trajet = trajetService.rechercher(reservationForm.getIdTrajet());
		personne = personneService.ajouterReservation(personne.getIdPersonne(), trajet.getIdTrajet(), reservationForm.getNombrePlaceReserve());
		
		
		
		model.addAttribute("reservationForm", reservationForm);
		model.addAttribute("message", personne.getPrenom() +" merci d'avoir réservé le trajet pour " + trajet.getVilleArrive());
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
		model.addAttribute("idPersonne", trajetForm.getIdPersonne());
		return "trajet";
	}

	@GetMapping("/listetrajet")
	public String listetrajet(ListeTrajetForm listeTrajetForm, Model model) {
		System.out.println("TrajetController:listetrajet()");
		Iterable<Trajet> listeDeTrajet = trajetService.lister();

		model.addAttribute("idPersonne", listeTrajetForm.getIdPersonne());
		model.addAttribute("listeDeTrajet", listeDeTrajet);
		return "listetrajet";
	}

	@PostMapping("/listetrajet")
	public String reserverUnTrajet(ListeTrajetForm listeTrajetForm, RedirectAttributes redirectAttributes,
			Model model, Principal principal) {
		System.out.println("TrajetController:reserverUnTrajet() IdPersonne=" + listeTrajetForm.getIdPersonne()
				+ " IdTrajet=" + listeTrajetForm.getIdTrajet());

		String name = principal.getName();
		
		

		// donner des infos au controlleur
		redirectAttributes.addFlashAttribute("idPersonne", "1");
		redirectAttributes.addFlashAttribute("idTrajet", listeTrajetForm.getIdTrajet());
		// model; donne des infos à la vue
		return "redirect:/reservation";
	}
}