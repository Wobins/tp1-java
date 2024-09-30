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

public class Quartier {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private ArrayList<Rue> rues;

	public Quartier(String nom) {
		this.id = ++idCompteur;
		this.setNom(nom);
		this.rues = new ArrayList<Rue>();
	}

	// Getters
	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Rue> getRues() {
		return rues;
	}

	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	// Ajouter une rue a un quartier
	public void ajouterRue(Rue rue) {
		rues.add(rue);
	}
	
	// Supprimer une rue du quartier
	public String supprimerRue(int idRue) {
		int i = 0;
		String nomRue = null;
		
		for(Rue rue : rues) {
			if (rue.getId() == idRue) {
				nomRue = rues.get(i).getNom();
				rues.remove(i);
			}
			
			++i;
		}
		
		return String.format("La rue %s a ete retiree du quartier %s avec succes", nomRue, nom);
	}
	
	// Supprimer une rue d'un quartier
	public void supprimerQuartier(int idRue) {
		String nomRue = null;
		
		int index = Utilitaires.retrouverIndexElement(rues, idRue, Rue::getId);
		 
		if (index != -1) {
		   nomRue = rues.get(index).getNom(); 
		   rues.remove(index);
		   System.out.println(String.format("La rue %s a ete retiree du quartier %s avec succes", nomRue, nom));
		} else {
		    System.out.println("La rue avec pour id " + idRue + " n'a pas ete trouvee.");
		}
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
		StringBuilder listeRues = new StringBuilder();
		
		// Parcourir toutes les rues du quartier
		for(Rue rue : this.getRues()) {
			listeRues.append("-id:").append(Integer.toString(rue.getId()))
					.append("\t-nom:").append(rue.getNom())
					.append("\n\t\t");
		}
		
        return "\n\n\nNom de la classe:\t Quartier" +  
        		"\nDescription:\t Cette classe permet de définir un quartier ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du quartier):\t" + this.getId() + 
        		"\n\t -nom (nom du quartier):\t" + this.getNom() + "\n\t -rues (toutes les rues du quartier):\t" +
		        "\n\t\t" + listeRues;
    }

}
