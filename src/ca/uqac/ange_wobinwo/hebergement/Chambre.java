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
	private int numero;
	private static int idCompteur = 0;
	private boolean estDisponible;
	private TypeChambre typeChambre;
	private double tarifNuitee;

	// Constructeur
	public Chambre(TypeChambre typeChambre, double tarif) {
		this.setNumero(++idCompteur);
		this.setTypeChambre(typeChambre);
		this.setTarifNuitee(tarif);
		this.estDisponible = true;
	}

	// Getters
	public int getNumero() {
		return numero;
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
	public void setNumero(int numero) {
		this.numero = numero;
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
        		"\nChamps de la classe:\n\t -numero (numero de la chambre):\t" + this.getNumero() + 
        		"\n\t -TypeChambre (type de la chambre):\t " + this.getTypeChambre().getNom() + " (id: " +this.getTypeChambre().getId() + ")" +
        		"\n\t -tarifNuitee (tarif par nuitee de la chambre):\t " + this.getTarifNuitee();
    }

}
