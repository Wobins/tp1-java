package ca.uqac.ange_wobinwo.hebergement;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class TypeHebergement {
	private int id;
	private static int idCompteur = 0;
	private String nom;

	public TypeHebergement(String nom) {
		this.id = ++idCompteur;
		this.nom = nom;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "TypeHebergement:id#".concat(Integer.toString(this.id)));
	}
	
	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "TypeHebergement:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public String getNom() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nom]", "TypeHebergement:id#".concat(Integer.toString(this.id)));
		return nom;
	}
	
	// Setter
	public void setNom(String nom) {
		this.nom = nom;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [nom] modifiée", "TypeHebergement:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t TypeHebergement" +  "\nDescription:\t Cette classe permet de définir un type d'hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du type):\t" + this.getId() + "\n\t -nom (nom du type):\t" + this.getNom();
    }

}
