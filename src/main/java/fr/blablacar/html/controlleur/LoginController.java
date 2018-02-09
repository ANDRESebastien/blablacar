package fr.blablacar.html.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.blablacar.html.form.ConnexionForm;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/connexion")
	public String connexion(ConnexionForm connexionForm, Model model) {
		return "login";
	}

}