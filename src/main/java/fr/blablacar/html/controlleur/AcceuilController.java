package fr.blablacar.html.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.blablacar.html.form.AcceuilForm;

import javax.validation.Valid;

@Controller
public class AcceuilController {

	@GetMapping("/acceuil")
	public String showForm(AcceuilForm acceuilForm, @ModelAttribute("idPersonne" ) String idPersonne) {
		System.out.println("AcceuilController:showForm()");
		
		try {
			if (Integer.parseInt(idPersonne) > 0) {
				acceuilForm.setIdPersonne(idPersonne);
				return "acceuil";
			}
		} catch (Exception e) {
			return "redirect:/";
		}
		return "redirect:/";
	}


	@PostMapping("/acceuil")
	public String ajouter(@Valid AcceuilForm acceuilForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("AcceuilController:ajouter()");

		if (bindingResult.hasErrors()) {
			System.out.println("-> erreur technique");
			// Erreur bas niveau, retour sur la page
			return "acceuil";
		}

		// Si OK passage à la page suivante avec argument
		redirectAttributes.addFlashAttribute("idPersonne", acceuilForm.getIdPersonne());
		return "redirect:/trajet";
	}
}
