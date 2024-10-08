package ca.uqac.ange_wobinwo.main;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

public class Main {
	public static void main(String[] args) {
		try { 
			Utilitaires.logToFile("INFO", "Demarrage du programme", "Main");
			Menu.Main();
			Utilitaires.logToFile("INFO", "Fermeture du programme", "Main");
		} catch (Exception e) {
			System.out.print(e); 
		}
	}
}
