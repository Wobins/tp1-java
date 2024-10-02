package ca.uqac.ange_wobinwo.main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ca.uqac.ange_wobinwo.hebergement.Chambre;
import ca.uqac.ange_wobinwo.hebergement.Hebergement;
import ca.uqac.ange_wobinwo.hebergement.Service;
import ca.uqac.ange_wobinwo.hebergement.TypeChambre;
import ca.uqac.ange_wobinwo.hebergement.TypeHebergement;
import ca.uqac.ange_wobinwo.personne.Client;
import ca.uqac.ange_wobinwo.region.Adresse;
import ca.uqac.ange_wobinwo.region.Rue;
import ca.uqac.ange_wobinwo.reservations.*;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */


public class Menu {
	public static List<Client> clients = new ArrayList<Client>();	
	public static List<Hebergement> hebergements = new ArrayList<Hebergement>();	
	public static List<Chambre> chambres = new ArrayList<Chambre>();	
	public static List<TypeChambre> typesChambre = new ArrayList<TypeChambre>();
	public static List<TypeHebergement> typesHebergement = new ArrayList<TypeHebergement>();
	public static List<Service> servicesOfferts = new ArrayList<Service>();
	public static List<Adresse> adresses = new ArrayList<Adresse>();
	public static List<Reservation> reservations = new ArrayList<Reservation>();
	
	private static void Initialisation() {
		// Initialisation des types de chambre
		typesChambre.add(new TypeChambre("Simple"));
		typesChambre.add(new TypeChambre("Double"));
		typesChambre.add(new TypeChambre("Suite"));

		// Initialisation des types d'hebergement
		typesHebergement.add(new TypeHebergement("Hotel"));
		typesHebergement.add(new TypeHebergement("Motel"));
		typesHebergement.add(new TypeHebergement("Couette"));
		typesHebergement.add(new TypeHebergement("Café"));
		
		// Initialisation des types de services
		servicesOfferts.add(new Service("piscine intérieure"));
		servicesOfferts.add(new Service("Cuisinette"));
		servicesOfferts.add(new Service("Salle de conditionnement physique"));
		servicesOfferts.add(new Service("Stationnement"));
		servicesOfferts.add(new Service("Accès handicapé"));
		servicesOfferts.add(new Service("Dépanneur"));
		servicesOfferts.add(new Service("Restaurant"));
		
	}
	
	public static void Main() {
		Initialisation();
		SystemeGestionReservationsImpl systeme_gestion = new SystemeGestionReservationsImpl();
		
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
                    menuHebergements(scanner);
                    break;
                case 3:
                    menuReservations(scanner, systeme_gestion);
                    break;
                case 4:
//                	menuBesoins(scanner);
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
	
	// Menu des operations sur les clients
	private static void menuClients(Scanner scanner) {
		boolean retour = false;
		
		while(!retour) {
			System.out.println("Menu Clients : ");
			System.out.println("a. Ajouter un client");
			System.out.println("b. Consulter tous les clients");
			System.out.println("c. Consulter les details d'un client");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b ou r): \t");
			
			String choix_1 = scanner.nextLine().toLowerCase();

            switch (choix_1) {
                case "a":
                	System.out.println("\n Enregistrement des clients...");
                	System.out.println("Entrez le nom : \t");
                	String nom = scanner.nextLine().toLowerCase();
                	System.out.println("Entrez le courriel : \t");
                	String courriel = scanner.nextLine().toLowerCase();
                	System.out.println("Entrez le numero de telephone : \t");
                	String numeroTel = scanner.nextLine().toLowerCase();
                	Client _client = new Client(nom, courriel, numeroTel);
                	clients.add(_client);
                	System.out.println(_client);
					/*
					 * boolean continuer = true; while(continuer) {
					 * 
					 * System.out.
					 * println("Voulez vous continuer a ajouter des clients ? (Oui/Non) \t"); String
					 * confirmation = scanner.next(); if (confirmation.equalsIgnoreCase("Non")) {
					 * System.out.println("Fermeture du programme ...");
					 * System.out.println("Merci et a bientot."); continuer = false; }
					 * 
					 * }
					 */
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
    }
	
	// Menu des operations relatives sur les hebergements
	private static void menuHebergements(Scanner scanner) {
		boolean retour = false;
		
		while(!retour) {
			System.out.println("\nMenu Hebergements : ");
			System.out.println("a. Ajouter un hebergement");
			System.out.println("b. Ajouter une chambre a un hebergement");
			System.out.println("c. Ajouter un service a un hebergement");
			System.out.println("d. Consulter tous les hebergements");
			System.out.println("e. Consulter les details d'un hebergement");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b ou r): \t");
			
			String choix_2 = scanner.nextLine().toLowerCase();
			
			switch (choix_2) {
				case "a":
					System.out.println("\nEnregistrement d'un hebergement ...");
					boolean continuer = true;
					while(continuer) {
						System.out.println("Entrez le nom de l'hebergement : \t");
						String nom = scanner.nextLine();
						Hebergement nouvel_hebergement = new Hebergement(nom);						
						
						System.out.println("Dans quel pays est il situe ? : \t");
						String _pays = scanner.nextLine().toUpperCase();						
						System.out.println("Dans quelle province est il situe ? : \t");
						String _province = scanner.nextLine().toUpperCase();
						System.out.println("Dans quelle ville est il situe ? : \t");
						String _ville = scanner.nextLine().toUpperCase();					
						System.out.println("Dans quelle rue est il situe ? : \t");
						String _rue = scanner.nextLine().toUpperCase();
						System.out.println("Quel est le numero de rue ? : \t");
						int numero_rue = scanner.nextInt();

						System.out.println("Veuillez faire 1 choix parmi les types d'hebergement suivants (1, 2, 3 ou 4) : \t");
						typesHebergement.forEach(_typeHebergement -> System.out.println(_typeHebergement.getId() + ")" + _typeHebergement.getNom()));
						int type_hebergement_id = scanner.nextInt();
						
						System.out.println("Veuillez choisir parmi les services offerts suivants (1 ou 2 ou 3 etc.) : \t");
						servicesOfferts.forEach(serviceOffert -> System.out.println(serviceOffert.getId() + ")" + serviceOffert.getNom()));
						int service_id = scanner.nextInt();
						int index = Utilitaires.retrouverIndexElement(servicesOfferts, service_id, Service::getId);
						nouvel_hebergement.ajouterService(servicesOfferts.get(index));

						Adresse nouvelle_adresse = new Adresse(numero_rue, _rue, _ville, _province, _pays);
						adresses.add(nouvelle_adresse);
						nouvel_hebergement.setAdresse(nouvelle_adresse);
						hebergements.add(nouvel_hebergement);
						System.out.println(nouvel_hebergement);
				
						continuer = false;						
					}
					break;
				case "b":
					System.out.println("Ajout d'une chambre a l'hebergement...");
					if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
					} else {
						for(Hebergement hebergement : hebergements) {
							System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
						}
						System.out.println("Veuillez renseigner l'ID correspondant:\t");
						int hebergement_id = scanner.nextInt();
						
						System.out.println("Veuillez renseigner le tarif de la nuitee dans cette chambre en utilisant si besoin le point (.) pour la deimale:\t");
						double tarif_chambre = (double)scanner.nextDouble();

						System.out.println("Veuillez renseigner l'id parmi les types de chambre ci-dessous a ajouter (1, 2 ou 3):\t");
						typesChambre.forEach(_typeChambre -> System.out.println(_typeChambre.getId() + ")" + _typeChambre.getNom()));
						int typeChambre_id = scanner.nextInt();
						
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
						int index_typeChambre = Utilitaires.retrouverIndexElement(typesChambre, typeChambre_id, TypeChambre::getId);
						Chambre nouvelle_chambre = new Chambre(typesChambre.get(index_typeChambre), tarif_chambre);
						chambres.add(nouvelle_chambre);
						hebergements.get(index_hebergement).ajouterChambre(nouvelle_chambre);						
						System.out.print(hebergements.get(index_hebergement));
					}
					break;
				case "c":
					System.out.println("\nAjout d'un service a l'hebergement...");
					if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
					} else {
						for(Hebergement hebergement : hebergements) {
							System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
						}
						System.out.println("Veuillez renseigner l'ID correspondant:\t");
						int hebergement_id = scanner.nextInt();
						
						System.out.println("Veuillez renseigner l'id parmi les types de services (1, 2 ou 3):\t");
						servicesOfferts.forEach(serviceOffert -> System.out.println(serviceOffert.getId() + ")" + serviceOffert.getNom()));
						int service_id = scanner.nextInt();
						
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
						int index_ServiceOffert = Utilitaires.retrouverIndexElement(servicesOfferts, service_id, Service::getId);
		
						hebergements.get(index_hebergement).ajouterService(servicesOfferts.get(index_ServiceOffert));
						System.out.print(hebergements.get(index_hebergement));
					}
					break;
				case "d":
					System.out.println("\nConsultation de tous les hebergements ...");
					if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
					} else {
						hebergements.forEach(hebergement -> System.out.println(hebergement));
					}
					break;
				case "e":
					System.out.println("\nConsultation des details d'un hebergement...");
					if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
					} else {
						System.out.println("Veuillez renseigner l'id parmi les hebergements (1, 2 ou 3, etc.):\t");						
						hebergements.forEach(hebergement -> System.out.println(hebergement.getId() + ")" + hebergement.getNom()));
						int hebergement_id = scanner.nextInt();				
						
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
		
						System.out.print(hebergements.get(index_hebergement));
					}
					break;
				case "r":
					retour = true;
					break;
				default:
					System.out.println("Choix invalide. Veuillez réessayer.***2");
					break;
			}
		}
	}
	
	private static void menuReservations(Scanner scanner, SystemeGestionReservationsImpl systeme_gestion) {
		boolean retour = false;
		
		while(!retour) {
			System.out.println("\nMenu Reservations : ");
			System.out.println("a. Effectuer une reservation");
			System.out.println("b. Consulter toutes les reservations");
			System.out.println("c. Consulter les details d'une reservation");
			System.out.println("d. Annuler une reservation");
//			System.out.println("c. Chercher une reservation");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b, c, d ou r): \t");
			
			String choix_3 = scanner.nextLine().toLowerCase();
			
			switch (choix_3) {
			case "a":
				System.out.println("Enregistrement d'une reservation en cours ...");
				
				if (clients.isEmpty()) {
					System.out.println("Aucun client trouve dans le systeme!!");
					System.out.println("Veuillez vous assurer d'avoir enregistre au moins un client.");				
				} 
				else if(hebergements.isEmpty()) {
					System.out.println("Aucun hebergement trouve dans le systeme!!");
					System.out.println("Veuillez vous assurer d'avoir enregistre au moins un hebergement.");									
				} 
				else {
					System.out.println("Renseigner l'id de l'hebergement (1, 2, ou 3, etc.):\t");
					System.out.println("ID\tNom\tPays\tVille");
					hebergements.forEach(_hebergement -> System.out.println(_hebergement.getId() + "\t" + _hebergement.getNom() + "\t" + _hebergement.getAdresse().getPays() + "\t" + _hebergement.getAdresse().getVille()));					
					int hebergement_id = scanner.nextInt();
					int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
					Hebergement hebergementReserve = hebergements.get(index_hebergement);
					
					if (hebergementReserve.getChambres().isEmpty()) {
						System.out.println("Aucune chambre affectee a cet hebergement!");
						System.out.println("Veuiller ajouter une chambre a cet hebergement!");
					} 
					else {
						StringBuilder chambresDispo = new StringBuilder();
						int i = 0;
						for (Chambre _chambre : hebergementReserve.getChambres()) {
							if(_chambre.getEstDisponible()) {
								++i;
								chambresDispo.append(_chambre.getId())
											 .append("\t")
											 .append(_chambre.getTarifNuitee());
							}
						}
						
						if (i > 0) {							
							System.out.println("Renseigner le nombre de nuits a reserver :\t");
							int nombre_nuits = scanner.nextInt();
							
							System.out.println("Renseigner l'id de la chambre (1, 2, ou 3, etc.):\t");
							System.out.println("ID\tTarif");
							System.out.println(chambresDispo);
							int chambre_id = scanner.nextInt();
							int indexChambre = Utilitaires.retrouverIndexElement(chambres, chambre_id, Chambre::getId);
							Chambre chambre = chambres.get(indexChambre);
							
							
							System.out.println("Renseigner l'id parmi les clients ci-dessous a ajouter (1, 2, ou 3, etc.):\t");
							clients.forEach(_client -> System.out.println(_client.getId() + ")" + _client.getNom()));
							int client_id = scanner.nextInt();
							int indexClient = Utilitaires.retrouverIndexElement(clients, client_id, Client::getId);
							Client client = clients.get(indexClient);
							
							
							System.out.println("Renseigner la date d'arrivee (dd/MM/yyyy) :\t");
							String dateSaisie = scanner.nextLine();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate dateArrivee = LocalDate.parse(dateSaisie, formatter);
							System.out.println("La date saisie est : " + dateArrivee);						
							
							Reservation reservation_en_suspens = new Reservation(client, chambre, hebergementReserve, nombre_nuits);
							reservation_en_suspens.setDateArrivee(dateArrivee);
							reservation_en_suspens.setDateDepart(dateArrivee.plusDays(nombre_nuits));
							Reservation nouvelle_reservation = systeme_gestion.effectuerReservation(reservation_en_suspens);
							chambres.get(indexChambre).setEstDisponible(false);
							System.out.println(nouvelle_reservation);
							/*
							 * try { } catch (Exception e) {
							 * System.out.println("Format de date incorrect. Veuillez réessayer."); }
							 */						
						} else {
							System.out.println("Aucune chambre disponible a ce jour dans cet hebergement");							
						}
					}

					
				}
				break;
			case "b":
				System.out.println("Ajout d'une chambre a l'hebergement...");
				if (hebergements.isEmpty()) {
					System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
				} else {
					for(Hebergement hebergement : hebergements) {
						System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
					}
					System.out.println("Veuillez renseigner l'ID correspondant:\t");
					int hebergement_id = scanner.nextInt();
					
					System.out.println("Veuillez renseigner le tarif de la nuitee dans cette chambre en utilisant si besoin le point (.) pour la deimale:\t");
					double tarif_chambre = (double)scanner.nextDouble();
					
					System.out.println("Veuillez renseigner l'id parmi les types de chambre ci-dessous a ajouter (1, 2 ou 3):\t");
					typesChambre.forEach(_typeChambre -> System.out.println(_typeChambre.getId() + ")" + _typeChambre.getNom()));
					int typeChambre_id = scanner.nextInt();
					
					int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
					int index_typeChambre = Utilitaires.retrouverIndexElement(typesChambre, typeChambre_id, TypeChambre::getId);
					Chambre nouvelle_chambre = new Chambre(typesChambre.get(index_typeChambre), tarif_chambre);
					chambres.add(nouvelle_chambre);
					hebergements.get(index_hebergement).ajouterChambre(nouvelle_chambre);						
					System.out.print(hebergements.get(index_hebergement));
				}
				break;
			case "c":
				System.out.println("\n Ajout d'un service a l'hebergement...");
				if (hebergements.isEmpty()) {
					System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
				} else {
					for(Hebergement hebergement : hebergements) {
						System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
					}
					System.out.println("Veuillez renseigner l'ID correspondant:\t");
					int hebergement_id = scanner.nextInt();
					
					System.out.println("Veuillez renseigner l'id parmi les types de services (1, 2 ou 3):\t");
					servicesOfferts.forEach(serviceOffert -> System.out.println(serviceOffert.getId() + ")" + serviceOffert.getNom()));
					int service_id = scanner.nextInt();
					
					int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
					int index_ServiceOffert = Utilitaires.retrouverIndexElement(servicesOfferts, service_id, Service::getId);
					
					hebergements.get(index_hebergement).ajouterService(servicesOfferts.get(index_ServiceOffert));
					System.out.print(hebergements.get(index_hebergement));
				}
				break;
			case "d":
				System.out.println("\n Consultation de tous les hebergements ...");
				if (hebergements.isEmpty()) {
					System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
				} else {
					hebergements.forEach(hebergement -> System.out.println(hebergement));
				}
				break;
			case "e":
				System.out.println("\n Consultation des details d'un hebergement...");
				if (hebergements.isEmpty()) {
					System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
				} else {
					System.out.println("Veuillez renseigner l'id parmi les hebergements (1, 2 ou 3, etc.):\t");						
					hebergements.forEach(hebergement -> System.out.println(hebergement.getId() + ")" + hebergement.getNom()));
					int hebergement_id = scanner.nextInt();				
					
					int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id, Hebergement::getId);
					
					System.out.print(hebergements.get(index_hebergement));
				}
				break;
			case "r":
				retour = true;
				break;
			default:
				System.out.println("Choix invalide. Veuillez réessayer.***3");
				break;
			}
		}
	}

}
