package ca.uqac.ange_wobinwo.hebergement;

import java.util.ArrayList;

import ca.uqac.ange_wobinwo.region.Adresse;
import ca.uqac.ange_wobinwo.region.Rue;
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
		this.setId(++idCompteur);
		this.setNom(nom);
		this.services = new ArrayList<Service>();
		this.chambres = new ArrayList<Chambre>();
	}

	// Getters
	public int getId() {
		return id;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public String getNom() {
		return nom;
	}
	
	public ArrayList<Service> getServices() {
		return services;
	}
	
	public TypeHebergement getTypeHebergement() {
		return typeHebergement;
	}
	
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}

	public int getNombreChambres() {
		nombreChambres = chambres.size();
		return nombreChambres;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	public void setTypeHebergement(TypeHebergement typeHebergement) {
		this.typeHebergement = typeHebergement;
	}

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	// Ajouter une chambre a un hebergement
	public void ajouterChambre(Chambre chambre) {
		chambres.add(chambre);
	}

	// Ajouter un service a un hebergement
	public void ajouterService(Service service) {
		services.add(service);
	}
	
	// Supprimer une chambre d'un hebergement
	public void supprimerChambre(int numeroChambre) {
		int resultat = Utilitaires.supprimerElementListe(chambres, numeroChambre, Chambre::getId);
		
		if (resultat != -1) {
		   System.out.println(String.format("La chambre avec pour numero %s a ete retiree de l'hebergement %s avec succes et n'est plus disponible pour aucune reservation desormais", 
				   				numeroChambre, this.getNom()));
		} else {
		    System.out.println(String.format("La chambre avec pour numero %s n'a pas ete trouvee dans l'hebergement %s.",
		    					numeroChambre, this.getNom()));
		}
	}

	// Supprimer un service d'un hebergement
	public void supprimerService(int idService) {
		int resultat = Utilitaires.supprimerElementListe(services, idService, Service::getId);
		
		if (resultat != -1) {
			System.out.println(String.format("Le service offert avec pour id %s a ete retire de l'hebergement %s avec succes", 
					idService, this.getNom()));
		} else {
			System.out.println(String.format("Le service avec pour id %s n'est pas offert par l'hebergement %s.",
					idService, this.getNom()));
		}
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
        		"\nChamps de la classe:\n\t -id (identifiant du service):\t" + this.getId() + 
        		"\n\t -nom (nom de l'hebergement):\t" + this.getNom() +
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
