package ca.uqac.ange_wobinwo.hebergement;

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
		this.setId(++idCompteur);
		this.setTypeChambre(typeChambre);
		this.setTarifNuitee(tarif);
		this.estDisponible = true;
	}

	// Getters
	public int getId() {
		return id;
	}
	
	public TypeChambre getTypeChambre() {
		return typeChambre;
	}
	
	public Boolean getEstDisponible() {
		return estDisponible;
	}
	
	public double getTarifNuitee() {
		return tarifNuitee;
	}

	// Setters
	public void setId(int numero) {
		this.id = numero;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}
	
	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
	}
	
	public void setTarifNuitee(double tarifNuitee) {
		this.tarifNuitee = tarifNuitee;
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
