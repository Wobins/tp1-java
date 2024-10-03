package ca.uqac.ange_wobinwo.besoin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ca.uqac.ange_wobinwo.hebergement.Service;
import ca.uqac.ange_wobinwo.hebergement.TypeChambre;
import ca.uqac.ange_wobinwo.hebergement.TypeHebergement;
import ca.uqac.ange_wobinwo.personne.PotentielClient;
import ca.uqac.ange_wobinwo.region.Adresse;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Besoin {
	private int id;
	private static int idCompteur = 0;
	private PotentielClient potentielclient;
	private TypeChambre typeChambreSouhaite;
	private TypeHebergement typeHebergementSouhaite;
	private Adresse adresse;
	private double tarifMax;
	private ArrayList<Service> services;
	private LocalDateTime dateCreation;
	private LocalDate dateArrivee;
	private LocalDate dateDepart;
	
	// Constructeur
	public Besoin(double tarif) {
		this.setId(++idCompteur);
		this.setPotentielclient(null);
		this.setTypeChambreSouhaite(null);
		this.setTypeHebergementSouhaite(null);
		this.setAdresse(null);
		this.setTarifMax(tarif);
		this.setServices(null);
		this.setDateArrivee(null);
		this.setDateDepart(null);
		this.setDateCreation(null);
	}

	// Getters
	public int getId() {
		return id;
	}
	
	public TypeChambre getTypeChambreSouhaite() {
		return typeChambreSouhaite;
	}
	
	public PotentielClient getPotentielclient() {
		return potentielclient;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeHebergement getTypeHebergementSouhaite() {
		return typeHebergementSouhaite;
	}
	
	public double getTarifMax() {
		return tarifMax;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public ArrayList<Service> getServices() {
		return services;
	}
	
	public LocalDate getDateDepart() {
		return dateDepart;
	}
	
	public LocalDate getDateArrivee() {
		return dateArrivee;
	}
	
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	
	// Setters
	public void setPotentielclient(PotentielClient potentielclient) {
		this.potentielclient = potentielclient;
	}
	
	public void setTypeChambreSouhaite(TypeChambre typeChambre) {
		this.typeChambreSouhaite = typeChambre;
	}

	public void setTypeHebergementSouhaite(TypeHebergement typeHebergement) {
		this.typeHebergementSouhaite = typeHebergement;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setTarifMax(double tarifMax) {
		this.tarifMax = tarifMax;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
	// Redefinir la methode toString
	@Override
	public String toString() {
		StringBuilder services_souhaites = new StringBuilder();
		this.getServices().forEach(s -> services_souhaites.append("\n\t\tId: ").append(s.getId()).append("\t\tService: ").append(s.getNom()));
		
		return "\n\n\nNom de la classe:\t Besoin" +  "\nDescription:\t Cette classe permet de définir un besoin en attente" + 
        		"\nChamps de la classe:" + 
				"\n\t -id:\t" + this.getId() + 
        		"\n\t -potentielClient :\t (Numero: " + this.getPotentielclient().getNumeroPhone() + "\tNom: "  + this.getPotentielclient().getNom() + "\tCourriel: " + this.getPotentielclient().getCourriel() + " etc.)" + 
        		"\n\t -typeChambreSouhaite :\t " + this.getTypeChambreSouhaite().getNom() + 
        		"\n\t -typeHebergementSouhaite :\t " + this.getTypeHebergementSouhaite().getNom() + 
        		"\n\t -dateCreation :\t " + this.getDateCreation() + 
        		"\n\t -dateDepart :\t " + this.getDateDepart() + 
        		"\n\t -dateArrivee :\t " + this.getDateArrivee() + 
        		"\n\t -tarifMax :\t " + this.getTarifMax() +
        		"\n\t -services :" + services_souhaites +
				"\n\t -Adresse :\t Ville" + this.getAdresse().getVille();
	}
}
