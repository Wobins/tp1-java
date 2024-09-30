package ca.uqac.ange_wobinwo.region;

import java.util.ArrayList;
import ca.uqac.ange_wobinwo.utilitaires.*;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Province {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private ArrayList<Ville> villes;

	public Province(String nom) {
		this.id = ++idCompteur;
		this.setNom(nom);
		this.villes = new ArrayList<Ville>();
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public ArrayList<Ville> getVilles() {
		return villes;
	}

	// Setter
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Ajouter une ville a une province
	public void ajouterVille(Ville ville) {
		villes.add(ville);
	}
	
	// Supprimer une ville d'une province
	public void supprimerVille(int idVille) {
		String nomVille = null;
		
		int index = Utilitaires.retrouverIndexElement(villes, idVille, Ville::getId);
		 
		if (index != -1) {
			nomVille = villes.get(index).getNom();
			villes.remove(index);
		    System.out.println(String.format("La ville %s a ete retiree de la province %s avec succes.", 
				   				nomVille, nom));
		} else {
		    System.out.println("Le quartier avec pour id " + idVille + " non trouve.");
		}
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
		StringBuilder listeVilles = new StringBuilder();
		
		// Parcourir toutes les villes de la province
		for(Ville ville : villes) {
			StringBuilder listeQuartiers = new StringBuilder();
			
			// Parcourir tous les quartiers de la ville
			for(Quartier quartier : ville.getQuartiers()) {
				StringBuilder listeRues = new StringBuilder();
				
				// Parcourir toutes les rues du quartier
				for(Rue rue : quartier.getRues()) {
					listeRues.append("\n\t\t\t\t\t\t-id:")
							 .append(Integer.toString(rue.getId()))
							 .append("\t-nom:").append(rue.getNom());					
				}
				
				listeQuartiers.append("\n\t\t\t**************Tous les quartiers************")
							  .append("\n\t\t\t-id:")
							  .append(Integer.toString(quartier.getId()))
						  	  .append("\t-nom:").append(quartier.getNom())
						  	  .append(listeRues)
						  	  .append("\n\t\t\t");
			}
			
			listeVilles.append("\n\t\t-id:").append(Integer.toString(ville.getId()))
					    .append("\t-nom:").append(ville.getNom())
					    .append(listeQuartiers)
					    .append("\n\t\t\t");
		}
		
        return "\n\n\nNom de la classe:\t Province" +  
        		"\nDescription:\t Cette classe permet de définir une province ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant de la province):\t" + this.getId() + 
        		"\n\t -nom (nom de la province):\t" + this.getNom() + "\n\t -villes (toutes les villes de la province):\t" +
		        "\n\t\t" + listeVilles;
    }

}
