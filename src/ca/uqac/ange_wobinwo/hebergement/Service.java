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

public class Service {
	private int id;
	private static int idCompteur = 0;
	private String nom;

	// Constructeur
	public Service(String nom) {
		this.id = ++idCompteur;
		this.nom = nom;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Service:id#".concat(Integer.toString(this.id)));
	}
	
	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Service:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public String getNom() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nom]", "Service:id#".concat(Integer.toString(this.id)));
		return nom;
	}
	
	// Setter
	public void setNom(String nom) {
		this.nom = nom;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [nom] modifiée", "Service:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Service" +  "\nDescription:\t Cette classe permet de définir un service offert par un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du service):\t" + this.getId() + "\n\t -nom (nom du serice):\t" + this.getNom();
    }

}
