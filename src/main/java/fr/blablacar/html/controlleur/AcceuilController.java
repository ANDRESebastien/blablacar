package fr.blablacar.html.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AcceuilController {

	@GetMapping("/acceuil")
	public String acceuil() {
		System.out.println("AcceuilController:acceuil()");
		return "acceuil";
	}
	
	
	@GetMapping("/index")
	public String index() {
		System.out.println("AcceuilController:index()");
		return "index";
	}
}
