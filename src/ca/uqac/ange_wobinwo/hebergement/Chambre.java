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

public class Chambre {
	private int id;
	private static int idCompteur = 0;
	private boolean estDisponible;
	private TypeChambre typeChambre;
	private double tarifNuitee;

	// Constructeur
	public Chambre(TypeChambre typeChambre, double tarif) {
		this.id = ++idCompteur;
		this.typeChambre = typeChambre;
		this.tarifNuitee = tarif;
		this.estDisponible = true;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Chambre:id#".concat(Integer.toString(this.id)));
	}

	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Chambre:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public TypeChambre getTypeChambre() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [typeChambre]", "Chambre:id#".concat(Integer.toString(this.id)));
		return typeChambre;
	}
	
	public Boolean getEstDisponible() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [estFisponible]", "Chambre:id#".concat(Integer.toString(this.id)));
		return estDisponible;
	}
	
	public double getTarifNuitee() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [tarifNuitee]", "Chambre:id#".concat(Integer.toString(this.id)));
		return tarifNuitee;
	}

	// Setters
	public void setId(int numero) {
		this.id = numero;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [id] modifiée", "Chambre:id#".concat(Integer.toString(this.id)));
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [typeChambre] modifiée", "Chambre:id#".concat(Integer.toString(this.id)));
	}
	
	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [estDisponible] modifiée", "Chambre:id#".concat(Integer.toString(this.id)));
	}
	
	public void setTarifNuitee(double tarifNuitee) {
		this.tarifNuitee = tarifNuitee;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [tarifNuitee] modifiée", "Chambre:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Chambre" +  "\nDescription:\t Cette classe permet de définir une chambre d'un logement" + 
        		"\nChamps de la classe:\n\t -id (id de la chambre):\t" + this.getId() + 
        		"\n\t -TypeChambre (type de la chambre):\t " + this.getTypeChambre().getNom() + " (id: " +this.getTypeChambre().getId() + ")" +
        		"\n\t -tarifNuitee (tarif par nuitee de la chambre):\t " + this.getTarifNuitee();
    }

}
