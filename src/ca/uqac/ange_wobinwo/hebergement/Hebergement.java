package ca.uqac.ange_wobinwo.hebergement;

import java.util.ArrayList;

import ca.uqac.ange_wobinwo.region.Adresse;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Hebergement {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private ArrayList<Service> services;
	private ArrayList<Chambre> chambres;
	private int nombreChambres;
	private TypeHebergement typeHebergement;
	private Adresse adresse;

	// Constructeur
	public Hebergement(String nom) {
		this.id = ++idCompteur;
		this.nom = nom;
		this.services = new ArrayList<Service>();
		this.chambres = new ArrayList<Chambre>();
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public Adresse getAdresse() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [adresse]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return adresse;
	}

	public String getNom() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nom]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return nom;
	}
	
	public ArrayList<Service> getServices() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [services]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return services;
	}
	
	public TypeHebergement getTypeHebergement() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [typeHebergement]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return typeHebergement;
	}
	
	public ArrayList<Chambre> getChambres() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [chambre]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return chambres;
	}

	public int getNombreChambres() {
		nombreChambres = chambres.size();
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nombreChambres]", "Hebergement:id#".concat(Integer.toString(this.id)));
		return nombreChambres;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [id] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [adresse] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	public void setNom(String nom) {
		this.nom = nom;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [nom] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [services] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	public void setTypeHebergement(TypeHebergement typeHebergement) {
		this.typeHebergement = typeHebergement;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [typeHebergement] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [chambres] modifiée", "Hebergement:id#".concat(Integer.toString(this.id)));
	}
	
	// Ajouter une chambre a un hebergement
	public void ajouterChambre(Chambre chambre) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [ajouterChambre]", "Hebergement:id#".concat(Integer.toString(this.id)));
		chambres.add(chambre);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [ajouterChambre]", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	// Ajouter un service a un hebergement
	public void ajouterService(Service service) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [ajouterService]", "Hebergement:id#".concat(Integer.toString(this.id)));
		services.add(service);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [ajouterService]", "Hebergement:id#".concat(Integer.toString(this.id)));
	}
	
	// Supprimer une chambre d'un hebergement
	public void supprimerChambre(int numeroChambre) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [supprimerChambre]", "Hebergement:id#".concat(Integer.toString(this.id)));
		int resultat = Utilitaires.supprimerElementListe(chambres, numeroChambre, Chambre::getId);
		
		if (resultat != -1) {
		   System.out.println(String.format("La chambre avec pour numero %s a ete retiree de l'hebergement %s avec succes et n'est plus disponible pour aucune reservation desormais", 
				   				numeroChambre, this.getNom()));
		} else {
		    System.out.println(String.format("La chambre avec pour numero %s n'a pas ete trouvee dans l'hebergement %s.",
		    					numeroChambre, this.getNom()));
		}
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [supprimerChambre]", "Hebergement:id#".concat(Integer.toString(this.id)));
	}

	// Supprimer un service d'un hebergement
	public void supprimerService(int idService) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [supprimerService]", "Hebergement:id#".concat(Integer.toString(this.id)));
		int resultat = Utilitaires.supprimerElementListe(services, idService, Service::getId);
		
		if (resultat != -1) {
			System.out.println(String.format("Le service offert avec pour id %s a ete retire de l'hebergement %s avec succes", 
					idService, this.getNom()));
		} else {
			System.out.println(String.format("Le service avec pour id %s n'est pas offert par l'hebergement %s.",
					idService, this.getNom()));
		}
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [supprimerService]", "Hebergement:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
		StringBuilder listeChambres = new StringBuilder();
		StringBuilder listeServices = new StringBuilder();
		
		// Parcourir toutes les chambres presentes dans l'hebergement
		for(Chambre chambre : this.getChambres()) {
			listeChambres.append("\n\t\t-id: ").append(Integer.toString(chambre.getId()))
					.append("\t-type: ").append(chambre.getTypeChambre().getNom())
					.append("\t-estDisponible: ").append(chambre.getEstDisponible())
					.append("\n\t\t");
		}

		// Parcourir toutes les services offerts par l'hebergement
		for(Service service : this.getServices()) {
			listeServices.append("\n\t\t-id: ").append(Integer.toString(service.getId()))
						.append("\t-nom: ").append(service.getNom())
						.append("\n\t\t");
		}
		
        return "\n\n\n\nNom de la classe:\t Hebergement" +  "\nDescription:\t Cette classe permet de définir un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant de l'hebergement):\t" + this.getId() + 
        		"\n\t -nom (nom de l'hebergement):\t" + this.getNom() +
        		"\n\t -typeHebergement (type de l'hebergement):\t" + this.getTypeHebergement().getNom() + " (id:" + this.getTypeHebergement().getId() + " )" +
    			"\n\t -Adresse (adresse de l'hebergement):\t" + this.getAdresse().getNumeroRue()
    													 + " RUE " + this.getAdresse().getRue()
    													 + ", " + this.getAdresse().getVille() 
    													 + ", " + this.getAdresse().getProvince()
    													 + ", " + this.getAdresse().getPays() +
		        "\n\t -services (les services offerts par l'hebergement):\t" + listeServices +
		        "\n\t -nombreChambres (les chambres de l'hebergement):\t" + this.getNombreChambres() +
		        "\n\t -chambres (les chambres de l'hebergement):\t" + listeChambres;
    }

}
