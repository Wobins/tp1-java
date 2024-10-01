package ca.uqac.ange_wobinwo.utilitaires;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Utilitaires {

	// Fonction pour recuperer l'index d'un element d'un List a partir de son id
	public static <T> int retrouverIndexElement(List<T> liste, int id, Function<T, Integer> getIdFunction) {
        for (int i = 0; i < liste.size(); i++) {
            T element = liste.get(i);
            if (getIdFunction.apply(element) == id) {
                return i;
            }
        }
        return -1;
    }
	
	// Fonction pour supprimer un element d'un objet de type List
	public static <T> int supprimerElementListe(List<T> liste, int id, Function<T, Integer> getIdFunction) {		
		int index = retrouverIndexElement(liste, id, getIdFunction);
		 
		if (index != -1) {
			liste.remove(index);
			return 1;
		}
		return -1;
	}
	
	public static void effacerConsole() {
		/*try {
            // Determine the appropriate command for clearing the console based on the operating system
            String command;
            if (System.getProperty("os.name").startsWith("Windows")) {
                command = "cmd /c cls";
            } else if (System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Unix")) {
                command = "clear";
            } else {
                // Handle other operating systems or throw an exception if not supported
                throw new RuntimeException("Unsupported operating system");
            }

            // Create a ProcessBuilder object with the command
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to finish
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/
		
		/*try { 
            if (System.getProperty("os.name").contains("Windows")) { 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            } else { 
                new ProcessBuilder("clear").inheritIO().start().waitFor(); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } */
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

}
