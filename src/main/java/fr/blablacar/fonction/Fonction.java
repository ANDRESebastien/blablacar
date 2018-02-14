package fr.blablacar.fonction;

import java.time.Duration;
import java.time.LocalDateTime;

public class Fonction {

	public static boolean tempsRestant24H(LocalDateTime momentAnnulation) {
		LocalDateTime maintenant = LocalDateTime.now();
		 long tempsRestant = Duration.between(maintenant, momentAnnulation).getSeconds();
		if (tempsRestant > 60 * 60 * 24) {
			return true;
		} else {
			return false;
		}
	}
}
