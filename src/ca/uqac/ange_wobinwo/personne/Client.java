package ca.uqac.ange_wobinwo.personne;

import java.util.UUID;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Client implements Personne {
	private String id;
	private String nom;
	private String courriel;
	private String numeroPhone;

	public Client(String nom, String courriel, String numeroPhone) {
		this.id = UUID.randomUUID().toString() + "-" + (int)(Math.random() * 101);
		this.setNom(nom);
		this.setCourriel(courriel);
		this.setNumeroPhone(numeroPhone);
	}
	
	// Getters
	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getCourriel() {
		return courriel;
	}

	public String getNumeroPhone() {
		return numeroPhone;
	}

	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public void setNumeroPhone(String numeroPhone) {
		this.numeroPhone = numeroPhone;
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Rue" +  "\nDescription:\t Cette classe permet de définir une rue ou se situe un hebergement" + 
        		"\nChamps de la classe:\n\t -id (identifiant du client):\t" + this.getId() + 
        		"\n\t -nom (nom du client):\t" + this.getNom() +
        		"\n\t -courriel (courriel du client):\t" + this.getCourriel() +
        		"\n\t -numeroPhone (numero de telephone du client):\t" + this.getNumeroPhone();
    }


}
