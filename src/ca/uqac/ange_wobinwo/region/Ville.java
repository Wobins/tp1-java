package ca.uqac.ange_wobinwo.region;

import java.util.ArrayList;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Ville {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private ArrayList<Quartier> quartiers;

	// Constructeur
	public Ville(String nom) {
		this.id = ++idCompteur;
		this.setNom(nom);
		this.quartiers = new ArrayList<Quartier>();
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public ArrayList<Quartier> getQuartiers() {
		return quartiers;
	}

	// Setter
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Ajouter une un quartier a une ville
	public void ajouterQuartier(Quartier quartier) {
		quartiers.add(quartier);
	}
	
	// Supprimer un quartier d'une ville
	public void supprimerQuartier(int idQuartier) {
		int resultat = Utilitaires.supprimerElementListe(quartiers, idQuartier, Quartier::getId);
		
		if (resultat != -1) {
		   System.out.println(String.format("Le quartier avec pour id %s a ete retire de la ville %s avec succes", 
				   			  				idQuartier, this.getNom()));
		} else {
		    System.out.println(String.format("Le quartier avec pour id %s n'a pas ete trouve dans la ville %s.",
		    								idQuartier, this.getNom()));
		}
		
		/*
		 * String nomQuartier = null;
		 * 
		 * int index = Utilitaires.retrouverIndexElement(quartiers, idQuartier,
		 * Quartier::getId);
		 * 
		 * if (index != -1) { nomQuartier = quartiers.get(index).getNom();
		 * quartiers.remove(index); System.out.println(String.
		 * format("Le quartier %s a ete retire de la ville %s avec succes.",
		 * nomQuartier, nom)); } else { System.out.println("Le quartier avec pour id " +
		 * idQuartier + " non trouve."); }
		 */
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
		StringBuilder listeQuartiers = new StringBuilder();
		
		// Parcourir tous les quartiers de la ville
		for(Quartier quartier : this.getQuartiers()) {
			StringBuilder listeRues = new StringBuilder();
			for(Rue rue : quartier.getRues()) {
				listeRues.append("\n\t\t\t\t**************Toutes les rues************")
						.append("\n\t\t\t\t-id:").append(Integer.toString(rue.getId()))
						.append("\t-nom:").append(rue.getNom());
			}
			
			listeQuartiers.append("\n\t\t-id:").append(Integer.toString(quartier.getId()))
					.append("\t-nom:").append(quartier.getNom())
					.append(listeRues)
					.append("\n\t\t\t");
		}
		
        return "\n\n\nNom de la classe:\t Ville" +  
        		"\nDescription:\t Cette classe permet de définir une ville ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant de la ville):\t" + this.getId() + 
        		"\n\t -nom (nom de la ville):\t" + this.getNom() + "\n\t -quartiers (tous les quartiers de la ville):\t" +
		        "\n\t\t" + listeQuartiers;
    }

}
