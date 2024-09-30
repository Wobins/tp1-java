package ca.uqac.ange_wobinwo.hebergement;

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

	public Service(String nom) {
		this.id = ++idCompteur;
		this.setNom(nom);
	}
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	// Setter
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Service" +  "\nDescription:\t Cette classe permet de définir un service offert par un logement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du service):\t" + this.getId() + "\n\t -nom (nom du serice):\t" + this.getNom();
    }

}
