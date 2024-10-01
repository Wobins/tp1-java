package ca.uqac.ange_wobinwo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ca.uqac.ange_wobinwo.personne.Client;
import ca.uqac.ange_wobinwo.region.Rue;

public class Menu {
	public static List<Client> clients = new ArrayList<Client>();
	
	public static void Main() {
		Scanner scanner = new Scanner(System.in);
        boolean continuer = true; // variable pour checker si l'utilisateur veut sortir du programme

        while (continuer) {
            System.out.println("\n\n\nMenu principal : ");
            System.out.println("\t 1. Clients");
            System.out.println("\t 2. Hebergements");
            System.out.println("\t 3. Reservations");
            System.out.println("\t 4. Besoins");
            System.out.println("\t 0. Quitter");
            System.out.println("\t Veuillez faire un choix (1, 2, 3, 4 ou 0): \t");

            int choixPrincipal = scanner.nextInt();

            switch (choixPrincipal) {
                case 1:
                    menuClients(scanner);
                    break;
                case 2:
//                    menuHebergements(scanner);
                    break;
                case 3:
//                    menuReservations(scanner);
                    break;
                case 0:
                    System.out.println("Êtes-vous sûr de vouloir quitter ? (Oui/Non) \t");
                    String confirmation = scanner.next();
                    if (confirmation.equalsIgnoreCase("Oui")) {
                    	System.out.println("Fermeture du programme ...");
                    	System.out.println("Merci et a bientot.");
                        continuer = false;
                    }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez reesayer *****0");
            }
        }
        
        scanner.close();
    }
	
	private static void menuClients(Scanner scanner) {
		boolean retour = false;
		
		while(!retour) {
			System.out.println("Menu Clients : ");
			System.out.println("a. Ajouter un client");
			System.out.println("b. Consulter tous les clients");
			System.out.println("c. Consulter les details d'un client");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b ou r): \t");
			
			String choix = scanner.nextLine().toLowerCase();

            switch (choix) {
                case "a":
                	System.out.println("\n Enregistrement des clients...");
                	boolean continuer = true;
                	while(continuer) {
                		System.out.println("Entrez le nom : \t");
                		String nom = scanner.nextLine().toLowerCase();
                		System.out.println("Entrez le courriel : \t");
                		String courriel = scanner.nextLine().toLowerCase();
                		System.out.println("Entrez le numero de telephone : \t");
                		String numeroTel = scanner.nextLine().toLowerCase();
                		Client _client = new Client(nom, courriel, numeroTel);
                		clients.add(_client);
                		System.out.println(_client);
                		
                		System.out.println("Voulez vous continuer a ajouter des clients ? (Oui/Non) \t");
                        String confirmation = scanner.next();
                        if (confirmation.equalsIgnoreCase("Non")) {
                        	System.out.println("Fermeture du programme ...");
                        	System.out.println("Merci et a bientot.");
                            continuer = false;
                        }
                		
                	}
                    break;
                case "b":
                    System.out.println("\n Consultation des clients...");
                    if (clients.isEmpty()) {
                    	System.out.println("Aucun client n'a encore ete enregistre dans le systeme");
                    } else {
                    	for(Client client : clients) {
                    		System.out.println(client);
                    	}
                    }
                    break;
                case "c":
                    System.out.println("\n Consultation des details...");
                    if (clients.isEmpty()) {
                    	System.out.println("Aucun client n'a encore ete enregistre dans le systeme");
                    } else {
                    	System.out.println("Bien vouloir renseigner l'ID du client : \t");
                    	int idClient = scanner.nextInt();
                    	
                    	for(Client client : clients) {
                    		if (client.getId() == idClient) {
                    			System.out.println(client);
                    		} else {
                    			System.out.println("ID du client incorrect. Allez verifier!");
                    		}
                    	}
                    }
                    break;
                case "r":
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.***1");
                    break;
            }
		}
        // ... Implémentation du menu Produits

        // ... Traitement des choix du sous-menu
    }

}
