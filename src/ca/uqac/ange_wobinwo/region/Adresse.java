package ca.uqac.ange_wobinwo.region;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */


public class Adresse {
	private int numeroRue;
	private String rue;
	private String ville;
	private String province;
	private String pays;
	
	public Adresse(int _numeroRue, String _rue, String _ville, String _province, String _pays) {
		this.numeroRue = _numeroRue;
		this.rue = _rue;
		this.ville = _ville;
		this.province = _province;
		this.pays = _pays;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}

	// Getters
	public int getNumeroRue() {
		Utilitaires.logToFile("INFO", "Récupération de l'attribut [numeroRue]", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
		return numeroRue;
	}
	
	public String getRue() {
		Utilitaires.logToFile("INFO", "Récupération de l'attribut [rue]", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
		return rue;
	}
	
	public String getVille() {
		Utilitaires.logToFile("INFO", "Récupération de l'attribut [ville]", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
		return ville;
	}
	
	public String getProvince() {
		Utilitaires.logToFile("INFO", "Récupération de l'attribut [province]", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
		return province;
	}
	
	public String getPays() {
		Utilitaires.logToFile("INFO", "Récupération de l'attribut [pays]", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
		return pays;
	}

	// Setters
	public void setRue(String rue) {
		this.rue = rue;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [rue] modifiée", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}
	
	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [numeroRue] modifiée", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}

	public void setVille(String ville) {
		this.ville = ville;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [ville] modifiée", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}

	public void setProvince(String province) {
		this.province = province;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [province] modifiée", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}

	public void setPays(String pays) {
		this.pays = pays;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [pays] modifiée", "Adresse:id#".concat(Integer.toString(this.numeroRue)).concat(this.rue.toUpperCase()));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Adresse" +  "\nDescription:\t Cette classe permet de définir une adresse" + 
        		"\nChamps de la classe:\n\t -numeroRue:\t" + this.getNumeroRue() + 
        		"\n\t -rue:\t" + this.getRue().toUpperCase() +
        		"\n\t -ville :\t" + this.getVille().toUpperCase() +
        		"\n\t -province :\t" + this.getProvince().toUpperCase() +
        		"\n\t -pays :\t" + this.getPays().toUpperCase();
    }
}
