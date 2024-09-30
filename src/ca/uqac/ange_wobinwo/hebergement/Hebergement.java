package ca.uqac.ange_wobinwo.hebergement;

import java.util.ArrayList;

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
	private Rue rue;
	private int numeroRue;

	// Constructeur
	public Hebergement(String nom, ArrayList<Service> services, TypeHebergement typeHebergement, Rue rue, int numeroRue) {
		this.setId(++idCompteur);
		this.setNom(nom);
		this.setServices(services);
		this.chambres = new ArrayList<Chambre>();
		this.nombreChambres = this.getChambres().size();
		this.setTypeHebergement(typeHebergement);
		this.setRue(rue);
		this.setNumeroRue(numeroRue);
	}

	// Getters
	public int getId() {
		return id;
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
	
	public Rue getRue() {
		return rue;
	}
	
	public int getNumeroRue() {
		return numeroRue;
	}
	
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}

	public int getNombreChambres() {
		return nombreChambres;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
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

	public void setRue(Rue rue) {
		this.rue = rue;
	}

	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	// Ajouter une chambre a un hebergement
	public void ajouterChambre(Chambre chambre) {
		chambres.add(chambre);
	}

	// Ajouter un service a un hebergement
	public void ajouterVille(Service service) {
		services.add(service);
	}
	
	// Supprimer une chambre d'un hebergement
	public void supprimerChambre(int numeroChambre) {
		int resultat = Utilitaires.supprimerElementListe(chambres, numeroChambre, Chambre::getNumero);
		
		if (resultat != -1) {
		   int index = Utilitaires.retrouverIndexElement(chambres, id, Chambre::getNumero);	
		   this.getChambres().get(index).setEstDisponible(false); // Rendre la chambre supprimee indisponible
		   
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
			listeChambres.append("-id:").append(Integer.toString(chambre.getNumero()))
					.append("\t-type:").append(chambre.getTypeChambre())
					.append("\t-estDisponible:").append(chambre.getEstDisponible())
					.append("\n\t\t");
		}

		// Parcourir toutes les services offerts par l'hebergement
		for(Service service : this.getServices()) {
			listeServices.append("-id:").append(Integer.toString(service.getId()))
						.append("\t-nom:").append(service.getNom())
						.append("\n\t\t");
		}
		
        return "\n\n\n\nNom de la classe:\t Hebergement" +  "\nDescription:\t Cette classe permet de définir un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du service):\t" + this.getId() + 
        		"\n\t -nom (nom de l'hebergement):\t" + this.getNom() +
    			"\n\t -rue (rue de l'hebergement):\t" + this.getRue().getNom() + " (id: " + this.getRue().getId() + ")" +
        		"\n\t -numeroRue (numero de la rue de l'hebergement):\t" + this.getNumeroRue() +
		        "\n\t -services (les services offerts par l'hebergement):\t" + listeServices +
		        "\n\t -nombreChambres (les chambres de l'hebergement):\t" + this.getNombreChambres() +
		        "\n\t -chambres (les chambres de l'hebergement):\t" + listeChambres;
    }

}
