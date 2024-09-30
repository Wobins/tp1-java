package ca.uqac.ange_wobinwo.region;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Rue {
	private int id;
	private static int idCompteur = 0;
	private String nom;

	// Constructeur
	public Rue(String nom) {
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
        return "\n\n\nNom de la classe:\t Rue" +  
        		"\nDescription:\t Cette classe permet de définir une rue ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant de la rue):\t" + 
        		this.getId() + "\n\t -nom (nom de la rue):\t" + this.getNom();
    }

}
