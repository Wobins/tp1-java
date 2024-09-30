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

public class Pays {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private ArrayList<Province> provinces;

	// Constructeur
	public Pays(String nom) {
		this.id = ++idCompteur;
		this.setNom(nom);
		this.setProvinces(new ArrayList<Province>());
	}

	// Getters
	public String getNom() {
		return nom;
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Province> getProvinces() {
		return provinces;
	}

	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setProvinces(ArrayList<Province> provinces) {
		this.provinces = provinces;
	}
	
	// Ajouter une province a un pays
	public void ajouterProvince(Province province) {
		provinces.add(province);
	}
	
	// Supprimer une province d'un pays
	public void supprimerProvince(int idProvince) {
		int resultat = Utilitaires.supprimerElementListe(provinces, idProvince, Province::getId);
		
		if (resultat != -1) {
		   System.out.println(String.format("La province avec pour id %s a ete retiree du pays %s avec succes", 
				   idProvince, this.getNom()));
		} else {
		    System.out.println(String.format("La province avec pour id %s n'a pas ete trouvee dans le pays %s.",
		    		idProvince, this.getNom()));
		}
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
		StringBuilder listeProvinces = new StringBuilder();
		
		// Parcourir toutes les provinces du pays
		for(Province province : provinces) {
			StringBuilder listeVilles = new StringBuilder();
			
			// Parcourir toutes les villes de la province
			for(Ville ville : province.getVilles()) {
				StringBuilder listeQuartiers = new StringBuilder();
				
				// Parcourir tous les quartiers de la ville
				for(Quartier quartier : ville.getQuartiers()) {
					StringBuilder listeRues = new StringBuilder();
					
					// Parcourir toutes les rues du quartier
					for(Rue rue : quartier.getRues()) {
						listeRues.append("\n\t\t\t\t\t\t\t-id:")
						.append(Integer.toString(rue.getId()))
						.append("\t-nom:").append(rue.getNom());					
					}
					
					listeQuartiers.append("\n\t\t\t\t**************Tous les quartiers************")
								  .append("\n\t\t\t\t-id:")
							  	  .append(Integer.toString(quartier.getId()))
							  	  .append("\t-nom:").append(quartier.getNom())
							  	  .append(listeRues)
							  	  .append("\n\t\t\t");
				}
				
				listeVilles.append("\n\t\t\t************Toutes les villes***********")
						   .append("\n\t\t\t-id:").append(Integer.toString(ville.getId()))
						   .append("\t-nom:").append(ville.getNom())
						   .append(listeQuartiers)
						   .append("\n\t\t\t");
			}
			
			listeProvinces.append("\n\t\t-id:").append(Integer.toString(province.getId()))
			.append("\t-nom:").append(province.getNom())
			.append(listeVilles)
			.append("\n\t\t\t");
		}
		
		
        return "\n\n\nNom de la classe:\t Pays" +  
        		"\nDescription:\t Cette classe permet de définir un pays ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du pays):\t" + this.getId() + 
        		"\n\t -nom (nom du pays):\t" + this.getNom() + 
        		"\n\t -provinces (toutes les provinces du pays):\t" + "\n\t\t" + listeProvinces;
    }
}
