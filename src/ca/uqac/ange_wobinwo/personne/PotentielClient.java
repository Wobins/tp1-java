package ca.uqac.ange_wobinwo.personne;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class PotentielClient {
	protected String nom;
	protected String courriel;
	protected String numeroPhone;
	
	public PotentielClient(String nom, String courriel, String numeroPhone) {
		this.nom = nom;
		this.courriel = courriel;
		this.numeroPhone = numeroPhone;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "PotentielClient:courriel#".concat(this.courriel));
	}
	
	// Getters
	public String getNom() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nom]", "PotentielClient:courriel#".concat(this.courriel));
		return nom;
	}

	public String getCourriel() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [courriel]", "PotentielClient:courriel#".concat(this.courriel));
		return courriel;
	}

	public String getNumeroPhone() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nunumeroPhone]", "PotentielClient:courriel#".concat(this.courriel));
		return numeroPhone;
	}

	//Setters
	public void setNom(String nom) {
		this.nom = nom;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [nom] modifiée", "PotentielClient:courriel#".concat(this.courriel));
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [courriel] modifiée", "PotentielClient:courriel#".concat(this.courriel));
	}

	public void setNumeroPhone(String numeroPhone) {
		this.numeroPhone = numeroPhone;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [numeroPhone] modifiée", "PotentielClient:courriel#".concat(this.courriel));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t PotentielClient" +  "\nDescription:\t Cette classe permet de définir un potentiel client susceptible de reserver" + 
        		"\nChamps de la classe:\n\t -nom (nom du client):\t" + this.getNom().toUpperCase() +
        		"\n\t -courriel (courriel du client):\t" + this.getCourriel() +
        		"\n\t -numeroPhone (numero de telephone du client):\t" + this.getNumeroPhone();
    }

}
