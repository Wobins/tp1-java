package ca.uqac.ange_wobinwo.main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ca.uqac.ange_wobinwo.besoin.Besoin;
import ca.uqac.ange_wobinwo.besoin.BesoinService;
import ca.uqac.ange_wobinwo.hebergement.Chambre;
import ca.uqac.ange_wobinwo.hebergement.Hebergement;
import ca.uqac.ange_wobinwo.hebergement.Service;
import ca.uqac.ange_wobinwo.hebergement.TypeChambre;
import ca.uqac.ange_wobinwo.hebergement.TypeHebergement;
import ca.uqac.ange_wobinwo.personne.Client;
import ca.uqac.ange_wobinwo.personne.PotentielClient;
import ca.uqac.ange_wobinwo.region.Adresse;
import ca.uqac.ange_wobinwo.reservations.*;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title: TP1 Description: TP1 pour cours 8INF957 Copyright: Copyright (c) 2024
 * School: UQAC
 * 
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Menu {
	public static List<TypeChambre> typesChambre = new ArrayList<TypeChambre>();
	public static List<Service> servicesOfferts = new ArrayList<Service>();
	public static List<TypeHebergement> typesHebergement = new ArrayList<TypeHebergement>();

	public static List<Client> clients = new ArrayList<Client>();
	public static List<Hebergement> hebergements = new ArrayList<Hebergement>();
	public static List<Chambre> chambres = new ArrayList<Chambre>();
	public static List<Adresse> adresses = new ArrayList<Adresse>();
//	public static List<Reservation> reservations = new ArrayList<Reservation>();

	// Initialisation des donnees de base (services, types de chambre et types d'hebergement)
	private static void Initialisation() {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [Initialisation]", "Menu");
		
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

//		Client ange = new Client("Ange W.", "wobinwoange@yahoo.com", "418 714-7089");
//		clients.add(ange);
//		
//		Adresse address = new Adresse(300, "Newton", "Ottawa", "Maine", "USA");
//		adresses.add(address);
//		
//		Chambre ch1 = new Chambre(typesChambre.get(0), 55.5);
//		ch1.setId(101);
//		Chambre ch2 = new Chambre(typesChambre.get(0), 44);
//		ch2.setEstDisponible(false);
//		Chambre ch3 = new Chambre(typesChambre.get(0), 35.99);
//		ch2.setEstDisponible(false);
//		chambres.add(ch1);
//		chambres.add(ch2);
//		chambres.add(ch3);
//		
//		Hebergement leParc = new Hebergement("Residence Le Parc");
//		leParc.getChambres().add(ch1);
//		leParc.getChambres().add(ch2);
//		leParc.setAdresse(address);
//		leParc.setTypeHebergement(typesHebergement.get(2));
//		leParc.getServices().add(servicesOfferts.get(3));
//		leParc.getServices().add(servicesOfferts.get(1));
//		hebergements.add(leParc);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [Initialisation]", "Menu");
	}

	// Menu principal
	public static void Main() {
		Utilitaires.logToFile("INFO", "Ouverture du menu principal", "Menu");
		Initialisation();
		SystemeGestionReservationsImpl systeme_gestion = new SystemeGestionReservationsImpl();
		BesoinService besoin_service = new BesoinService();

		Scanner scanner = new Scanner(System.in);
		boolean continuer = true; // variable pour checker si l'utilisateur veut sortir du programme

		while (continuer) {
			System.out.println("\n\n\nMenu principal : ");
			System.out.println("\t 1. Clients");
			System.out.println("\t 2. Hebergements");
			System.out.println("\t 3. Reservations");
			System.out.println("\t 4. Besoins");
			System.out.println("\t 0. Quitter le systeme");
			System.out.println("\t Veuillez faire un choix (1, 2, 3, 4 ou 0): \t");

			int choixPrincipal = scanner.nextInt();
			
			switch (choixPrincipal) {
				case 1:
					Utilitaires.logToFile("INFO", "Ouverture du sous-menu [Clients]", "Menu");
					menuClients(scanner);
					Utilitaires.logToFile("INFO", "Fermeture du sous-menu [Clients]", "Menu");
					break;
				case 2:
					Utilitaires.logToFile("INFO", "Ouverture du sous-menu [Hebergements]", "Menu");
					menuHebergements(scanner);
					Utilitaires.logToFile("INFO", "Fermeture du sous-menu [Hebergements]", "Menu");
					break;
				case 3:
					Utilitaires.logToFile("INFO", "Ouverture du sous-menu [Reservations]", "Menu");
					menuReservations(scanner, systeme_gestion);
					Utilitaires.logToFile("INFO", "Fermeture du sous-menu [Reservations]", "Menu");
					break;
				case 4:
					Utilitaires.logToFile("INFO", "Ouverture du sous-menu [Besoins]", "Menu");
	                menuBesoins(scanner, besoin_service);
	                Utilitaires.logToFile("INFO", "Fermeture du sous-menu [Besoins]", "Menu");
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
					System.out.println("Choix invalide. Veuillez reesayer et choisir entre 1 et 4 ou 0");
				}
		}

		scanner.close();
		Utilitaires.logToFile("INFO", "Fermeture du menu principal", "Menu");
	}

	// Menu des operations sur les clients
	private static void menuClients(Scanner scanner) {
		boolean retour = false;

		while (!retour) {
			System.out.println("\nMenu Clients : ");
			System.out.println("a. Ajouter un client");
			System.out.println("b. Consulter tous les clients");
			System.out.println("c. Consulter les details d'un client");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b ou r): \t");

			String choix_1 = scanner.nextLine();

			switch (choix_1.toLowerCase()) {
			case "a":
				System.out.println("\n Enregistrement des clients...");
				System.out.println("Entrez le nom : \t");
				String nom = scanner.nextLine();
				System.out.println("Entrez le courriel : \t");
				String courriel = scanner.nextLine();
				System.out.println("Entrez le numero de telephone : \t");
				String numeroTel = scanner.nextLine();
				Client _client = new Client(nom.toUpperCase(), courriel, numeroTel);
				clients.add(_client);
				System.out.println(_client);
				
				break;
			case "b":
				System.out.println("Consultation des clients...");
				if (clients.isEmpty()) {
					System.out.println("Aucun client n'a encore ete enregistre dans le systeme");
				} else {
					for (Client client : clients) {
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

					for (Client client : clients) {
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
//                default:
//                    System.out.println("Choix invalide. Veuillez réessayer.***1");
//                    break;
			}
		}
	}

	// Menu des operations relatives sur les hebergements
	private static void menuHebergements(Scanner scanner) {
		boolean retour = false;

		while (!retour) {
			System.out.println("\nMenu Hebergements : ");
			System.out.println("a. Ajouter un hebergement");
			System.out.println("b. Ajouter une chambre a un hebergement");
			System.out.println("c. Ajouter un service a un hebergement");
			System.out.println("d. Consulter tous les hebergements");
			System.out.println("e. Consulter les details d'un hebergement");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b, c, d, e ou r): \t");

			String choix_2 = scanner.nextLine();

			switch (choix_2.toLowerCase()) {
				case "a":
					System.out.println("\nEnregistrement d'un hebergement ...");
					System.out.println("Entrez le nom de l'hebergement :");
					String _nom = scanner.nextLine();
					System.out.println("Dans quel pays est il situe ? :");
					String _pays = scanner.nextLine();
					System.out.println("Dans quelle province est il situe ? : \t");
					String _province = scanner.nextLine();
					System.out.println("Dans quelle ville est il situe ? : \t");
					String _ville = scanner.nextLine();
					System.out.println("Dans quelle rue est il situe ? : \t");
					String _rue = scanner.nextLine();
					System.out.println("Quel est le numero de rue ? : \t");
					int numero_rue = scanner.nextInt();
					
					System.out.println("Veuillez faire 1 choix parmi les types d'hebergement suivants (1, 2, 3 ou 4) : \t");
					typesHebergement.forEach(_typeHebergement -> System.out
							.println(_typeHebergement.getId() + ")" + _typeHebergement.getNom()));
					int hebergement_id1 = scanner.nextInt();
					int index1 = Utilitaires.retrouverIndexElement(typesHebergement, hebergement_id1, TypeHebergement::getId);
					
					System.out.println("Veuillez choisir parmi les services offerts suivants (1 ou 2 ou 3 etc.) : \t");
					servicesOfferts.forEach(
							serviceOffert -> System.out.println(serviceOffert.getId() + ")" + serviceOffert.getNom()));
					int service_id1 = scanner.nextInt();
					int index = Utilitaires.retrouverIndexElement(servicesOfferts, service_id1, Service::getId);
					
					Adresse nouvelle_adresse = new Adresse(numero_rue, _rue, _ville, _province, _pays);
					adresses.add(nouvelle_adresse);
					
					Hebergement nouvel_hebergement = new Hebergement(_nom);
					nouvel_hebergement.ajouterService(servicesOfferts.get(index));
					nouvel_hebergement.setTypeHebergement(typesHebergement.get(index1));
					nouvel_hebergement.setAdresse(nouvelle_adresse);
					
					hebergements.add(nouvel_hebergement);
					System.out.println(nouvel_hebergement);
					break;
				case "b":
					System.out.println("Ajout d'une chambre a l'hebergement...");
					if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement n'a encore ete enregistre dans le systeme");
					} else {
						for (Hebergement hebergement : hebergements) {
							System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
						}
						System.out.println("Veuillez renseigner l'ID correspondant:\t");
						int hebergement_id = scanner.nextInt();
	
						System.out.println(
								"Veuillez renseigner le tarif de la nuitee dans cette chambre en utilisant si besoin le point (.) pour la deimale:\t");
						double tarif_chambre = (double) scanner.nextDouble();
	
						System.out.println(
								"Veuillez renseigner l'id parmi les types de chambre ci-dessous a ajouter (1, 2 ou 3):\t");
						typesChambre.forEach(
								_typeChambre -> System.out.println(_typeChambre.getId() + ")" + _typeChambre.getNom()));
						int typeChambre_id = scanner.nextInt();
	
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id,
								Hebergement::getId);
						int index_typeChambre = Utilitaires.retrouverIndexElement(typesChambre, typeChambre_id,
								TypeChambre::getId);
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
						for (Hebergement hebergement : hebergements) {
							System.out.println("ID: " + hebergement.getId() + "\tNom: " + hebergement.getNom());
						}
						System.out.println("Veuillez renseigner l'ID correspondant:\t");
						int hebergement_id = scanner.nextInt();
	
						System.out.println("Veuillez renseigner l'id parmi les types de services (1, 2 ou 3):\t");
						servicesOfferts.forEach(
								serviceOffert -> System.out.println(serviceOffert.getId() + ")" + serviceOffert.getNom()));
						int service_id = scanner.nextInt();
	
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id,
								Hebergement::getId);
						int index_ServiceOffert = Utilitaires.retrouverIndexElement(servicesOfferts, service_id,
								Service::getId);
	
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
						System.out.println("Veuillez renseigner l'id de l'hebergement:\t");
						System.out.println("ID Hebergement\t\tNom de l'hebergement");
						hebergements.forEach(
								hebergement -> System.out.println(hebergement.getId() + "\t\t" + hebergement.getNom()));
						int hebergement_id = scanner.nextInt();
	
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id,
								Hebergement::getId);
	
						System.out.print(hebergements.get(index_hebergement));
					}
					break;
				case "r":
					retour = true;
					break;
//				default:
//					System.out.println("Choix invalide. Veuillez réessayer.***2");
//					break;
				}
		}
	}
	
	// Menu des operations relatives aux reservations
	private static void menuReservations(Scanner scanner, SystemeGestionReservationsImpl systeme_gestion) {
		boolean retour = false;

		while (!retour) {
			System.out.println("\nMenu Reservations : ");
			System.out.println("a. Effectuer une reservation");
			System.out.println("b. Consulter toutes les reservations");
			System.out.println("c. Consulter les details d'une reservation");
			System.out.println("d. Annuler une reservation");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b, c, d ou r): \t");

			String choix_3 = scanner.next();

			switch (choix_3.toLowerCase()) {
				case "a":
					System.out.println("Enregistrement d'une reservation en cours ...");
	
					if (clients.isEmpty()) {
						System.out.println("Aucun client trouve dans le systeme!!");
						System.out.println("Veuillez enregistrer au moins un client.");
					} else if (hebergements.isEmpty()) {
						System.out.println("Aucun hebergement trouve dans le systeme!!");
						System.out.println("Veuillez enregistrer au moins un hebergement.");
					} else {
						System.out.println("Renseigner l'id de l'hebergement (1, 2, ou 3, etc.):\t");
						System.out.println("ID\t\t\tNom\t\t\tPays\t\t\tVille");
						hebergements.forEach(_hebergement -> System.out.println(_hebergement.getId() + "\t\t\t"
								+ _hebergement.getNom() + "\t\t\t" + _hebergement.getAdresse().getPays() + "\t\t\t"
								+ _hebergement.getAdresse().getVille()));
						
						int hebergement_id = scanner.nextInt();
						int index_hebergement = Utilitaires.retrouverIndexElement(hebergements, hebergement_id,
								Hebergement::getId);
						Hebergement hebergementReserve = hebergements.get(index_hebergement);
	
						if (hebergementReserve.getChambres().isEmpty()) {
							System.out.println("Aucune chambre affectee a cet hebergement!");
							System.out.println("Veuiller ajouter une chambre a cet hebergement!");
						} else {
							StringBuilder chambresDispo = new StringBuilder();
							int i = 0;
							for (Chambre _chambre : hebergementReserve.getChambres()) {
								if (_chambre.getEstDisponible()) {
									++i;
									chambresDispo.append("\n").append(_chambre.getId()).append("\t\t")
											.append(_chambre.getTypeChambre().getNom())
											.append("\t\t").append(_chambre.getTarifNuitee());
								}
							}
	
							if (i > 0) {
								System.out.println("Renseigner le nombre de nuits a reserver :\t");
								int nombre_nuits = scanner.nextInt();
	
								System.out.println("Renseigner l'id de la chambre (1, 2, ou 3, etc.):\t");
								System.out.println("ID\t\tType\t\tTarif");
								System.out.println(chambresDispo);
								int chambre_id = scanner.nextInt();
								int indexChambre = Utilitaires.retrouverIndexElement(chambres, chambre_id, Chambre::getId);
								Chambre chambre = chambres.get(indexChambre);
	
								System.out.println("Renseigner l'id parmi les clients ci-dessous a ajouter (1, 2, ou 3, etc.):\t");
								System.out.println("ID\t\tNom Client");
								clients.forEach(_client -> System.out
										.println(_client.getId() + "\t\t" + _client.getNom().toUpperCase()));
								int client_id = scanner.nextInt();
								int indexClient = Utilitaires.retrouverIndexElement(clients, client_id, Client::getId);
								Client client = clients.get(indexClient);
	
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dateArrivee = null;
								while(dateArrivee == null) {
									System.out.println("Renseigner la date d'arrivee (format yyyy-MM-dd) :\t");
									String dateSaisie = scanner.next();
									try { 
										dateArrivee = LocalDate.parse(dateSaisie, formatter);
									} catch (Exception e) {
										System.out.println("Format de date incorrect. Veuillez réessayer."); 
									}								
								}
								System.out.println("La date saisie est : " + dateArrivee);
								
								Reservation reservation_en_suspens = new Reservation(client, chambre, hebergementReserve, nombre_nuits);
								reservation_en_suspens.setDateArrivee(dateArrivee);
								reservation_en_suspens.setDateDepart(dateArrivee.plusDays(nombre_nuits));
								Reservation nouvelle_reservation = systeme_gestion.effectuerReservation(reservation_en_suspens);
								chambres.get(indexChambre).setEstDisponible(false);
								System.out.println(nouvelle_reservation);					
		
									 							 
							} else {
								System.out.println("Aucune chambre disponible a ce jour dans cet hebergement");
							}
						}
	
					}
					break;
				case "b":
					System.out.println("Consultation de toutes les reservations ...");
					if (systeme_gestion.consulterReservations().isEmpty()) {
						System.out.println("Aucune reservation a ce jour.");
					} else {
						systeme_gestion.consulterReservations()
									   .forEach(_reservation -> System.out.println(_reservation));
					}
					break;
				case "c":
					System.out.println("Consultation des details d'une reservation...");
					if (systeme_gestion.consulterReservations().isEmpty()) {
						System.out.println("Aucune reservation a ce jour.");
					} else {
						System.out.println("ID Reservation\t\tNom du client\t\tNom de l'hebergement");
						systeme_gestion.consulterReservations().forEach(
										_reservation -> System.out.println(
													_reservation.getId() + "\t\t" + _reservation.getClient().getNom() + "\t\t" + _reservation.getHebergement().getNom()
												)
										);
						System.out.println("Entrez l'Id de la reservation a consulter :\t");
						int _reservationId_input = scanner.nextInt();
						System.out.println(systeme_gestion.trouverReservation(_reservationId_input));
						
					}
					break;
				case "d":
					System.out.println("Annulation d'une reservation en cours ...");
					if (systeme_gestion.consulterReservations().isEmpty()) {
						System.out.println("Aucune reservation a ce jour.");
					} else {
						System.out.println("ID\t\tClient\t\tHebergement\t\tMontant");
						systeme_gestion.consulterReservations().forEach(
								_reservation -> System.out.println(
										_reservation.getId() + "\t\t" + _reservation.getClient().getNom() + "\t\t" + _reservation.getHebergement().getNom() + "\t\t" + _reservation.getMontantFacture()
										)
								);
						System.out.println("Entrez l'Id de la reservation a annuler :\t");
						int id_reservation_input = scanner.nextInt();
						systeme_gestion.annulerReservation(id_reservation_input);
					}
					break;
				case "r":
					retour = true;
					break;
//				default:
//					System.out.println("Choix invalide. Veuillez réessayer.***3");
//					break;
			}
		}
	}	

	// Menu des operations relatives aux besoins
	private static void menuBesoins(Scanner scanner, BesoinService besoin_service) {
		boolean retour = false;
		
		while (!retour) {
			System.out.println("\nMenu Besoins : ");
			System.out.println("a. Chercher une place par rapport a un besoin");
			System.out.println("b. Consulter tous les besoins en attente");
			System.out.println("r. Retour");
			System.out.println("Choisissez une option (a, b, ou r): \t");
			
			String choix_4 = scanner.next();
			
			switch (choix_4.toLowerCase()) {
				case "a":
					System.out.println("Recherche d'une chambre ...");
					
					System.out.println("Filtrer la recherche par (1, 2 ou 3): \n1-ville\n2-province\n3-pays \t");
					int region_id = scanner.nextInt();
					System.out.println("Renseignez le nom de la region souhaitee suivant le filtre precedent :\t");
					String region = scanner.next();

					System.out.println("Renseignez l'id du type d'hebergement souhaite :\t");
					System.out.println("ID\t\tNom");
					for(TypeHebergement typeHebergement : typesHebergement) {
						System.out.println(typeHebergement.getId() + "\t\t" + typeHebergement.getNom());
					}
					int type_h = scanner.nextInt();
					
					System.out.println("Renseignez l'id du type de chambre souhaite :\t");
					System.out.println("ID\t\tNom");
					for(TypeChambre typeChambre : typesChambre) {
						System.out.println(typeChambre.getId() + "\t\t" + typeChambre.getNom());
					}
					int type_c = scanner.nextInt();
					
					System.out.println("Renseignez l'id du service desire :\t");
					System.out.println("ID\t\tNom");
					for(Service _service : servicesOfferts) {
						System.out.println(_service.getId() + "\t\t" + _service.getNom());
					}
					int _service = scanner.nextInt();
					

					System.out.println("Renseignez le tarif maximum :\t");
					double tarif_max = scanner.nextDouble();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dateArrivee = null;
					LocalDate dateDepart = null;
					while(dateArrivee == null) {
						System.out.println("Date d'arrivee souhaitee (format yyyy-MM-dd) :\t");
						String dateSaisie = scanner.next();
						try { 
							dateArrivee = LocalDate.parse(dateSaisie, formatter);
						} catch (Exception e) {
							System.out.println("Format de date incorrect. Veuillez réessayer."); 
						}
					}								
					System.out.println("La date d'arrivee saisie est : " + dateArrivee);
					while(dateDepart == null) {
						System.out.println("Date de depart souhaitee (format yyyy-MM-dd) :\t");
						String dateSaisie = scanner.next();
						try { 
							dateDepart = LocalDate.parse(dateSaisie, formatter);
						} catch (Exception e) {
							System.out.println("Format de date incorrect. Veuillez réessayer."); 
						}
					}								
					System.out.println("La date de depart saisie est : " + dateDepart);
					
					String chambres_dispo = "";
					String chambres_non_dispo = "";
					for(Hebergement _hebergement : hebergements) {
						int index_service = Utilitaires.retrouverIndexElement(servicesOfferts, _service, Service::getId);
						if (_hebergement.getTypeHebergement().getId() == type_h &&
							_hebergement.getServices().contains(servicesOfferts.get(index_service)) &&
								(_hebergement.getAdresse().getPays().equalsIgnoreCase(region) ||
								_hebergement.getAdresse().getProvince().equalsIgnoreCase(region) ||
								_hebergement.getAdresse().getVille().equalsIgnoreCase(region))
							)
						{
							for(Chambre chambre : _hebergement.getChambres()) {
								if(chambre.getTypeChambre().getId() == type_c && chambre.getTarifNuitee() <= tarif_max) {
									boolean disponibilite = chambre.getEstDisponible();
									String statut = disponibilite ? "Disponible" : "Non disponible";
									String adresse = _hebergement.getAdresse().getNumeroRue() + " RUE "
											+ _hebergement.getAdresse().getRue().toUpperCase() + ", "
											+ _hebergement.getAdresse().getVille().toUpperCase() + ", "
											+ _hebergement.getAdresse().getProvince().toUpperCase() + ", "
											+ _hebergement.getAdresse().getPays().toUpperCase();
									if (chambre.getEstDisponible()) {
										chambres_dispo += chambres_dispo.concat("\nLa chambre ") 
												.concat(Integer.toString(chambre.getId()))
												.concat(" de l'hebergement ") 
												.concat(_hebergement.getNom()).concat(" situe a l'adresse ").concat(adresse)
												.concat(" correspond aux besoins du client.")
												.concat(" (Statut: ").concat(statut).concat(")");
									} else {
										chambres_non_dispo += chambres_non_dispo.concat("\nLa chambre ") 
												.concat(Integer.toString(chambre.getId()))
												.concat(" de l'hebergement ") 
												.concat(_hebergement.getNom()).concat(" situe a l'adresse ").concat(adresse)
												.concat(" correspond aux besoins du client.")
												.concat(" (Statut: ").concat(statut).concat(")");
										
									}								
								}
							}
						}
					}
					if (!chambres_dispo.isEmpty()) {
						System.out.println("Chambres disponibles :\t");						
						System.out.println(chambres_dispo);		
						System.out.println("Vous pouvez reserver!");
					} else if (!chambres_non_dispo.isEmpty()) {
						System.out.println("Chambres non disponibles :\t");						
						System.out.println(chambres_non_dispo);		
						System.out.println("Souhaitez vous mettre le besoin en attente? (Oui/Non)\t");
						String confirmation = scanner.next();
						if (confirmation.equalsIgnoreCase("Oui")) {
							System.out.println("Enrez le nom du potentiel client :\t");
							String nom_potentielClient = scanner.nextLine();
							System.out.println("Enrez le numero de telephone du potentiel client :\t");
							String tel_potentielClient = scanner.nextLine();
							System.out.println("Enrez l'adresse courriel du potentiel client :\t");
							String courriel_potentielClient = scanner.nextLine();
							PotentielClient _potentielClient = new PotentielClient(nom_potentielClient, courriel_potentielClient, tel_potentielClient);
							int index_type_hebergement = Utilitaires.retrouverIndexElement(typesHebergement, type_h, TypeHebergement::getId);
							int index_type_chambre = Utilitaires.retrouverIndexElement(typesChambre, type_c, TypeChambre::getId);
							int index_service = Utilitaires.retrouverIndexElement(servicesOfferts, _service, Service::getId);
							Service service_offert = servicesOfferts.get(index_service);
							TypeChambre type_chambre = typesChambre.get(index_type_chambre);
							TypeHebergement type_hebergement = typesHebergement.get(index_type_hebergement);
							Besoin nouveau_besoin = new Besoin(_potentielClient, tarif_max, type_chambre, type_hebergement, dateArrivee, dateDepart);
							nouveau_besoin.ajouterService(service_offert);
							
							switch(region_id) {
								case 1:
									nouveau_besoin.setAdresse(new Adresse(0, "", region.toUpperCase(), "", ""));
									break;
								case 2:
									nouveau_besoin.setAdresse(new Adresse(0, "", "", region.toUpperCase(), ""));
									break;
								case 3:
									nouveau_besoin.setAdresse(new Adresse(0, "", "", "", region.toUpperCase()));
									break;
							}
							
							besoin_service.AjouterBesoinEnAttente(nouveau_besoin);
						}
					} else {
						System.out.println("Aucun emplacement ne correspond au besoin recherche.");
					}
					
					
					break;
				case "b":
					System.out.println("Consultation des besoins en attente...");
					if (besoin_service.ConsulterBesoins().isEmpty()) {
						System.out.println("Aucune besoin en attente!!");
					} else {
						besoin_service.ConsulterBesoins().forEach(besoin -> System.out.println(besoin));
					}
										
					break;
				case "r":
					retour = true;
					break;
//				default:
//					System.out.println("Choix invalide. Veuillez réessayer.***4");
//					break;
			}
		}
	}

}
