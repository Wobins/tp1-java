package ca.uqac.ange_wobinwo.reservations;

import java.time.*;

import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.personne.Client;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Reservation {
	private int id;
	private static int idCompteur = 0;
	private Client client;
	private Chambre chambre;
	private Hebergement hebergement;
	private int nombreNuits;
	private double montantFacture;
//	private int chambreID;
//	private String clientID;
	private ZonedDateTime dateCreation;
	private ZonedDateTime dateModification;
	private LocalDate dateArrivee;
	private LocalDate dateDepart;
	private boolean estAnnulee;
	
	public Reservation(Client _client, Chambre _chambre, Hebergement _hebergement, int _nbreNuits) {
		this.id = ++idCompteur;
		this.client = _client;
		this.chambre = _chambre;
		this.hebergement = _hebergement;
		this.setNombreNuits(_nbreNuits);
		this.setEstAnnulee(false);
	}
	
	// Getters
	public int getId() {
		return id;
	}
	
	public int getNombreNuits() {
		return nombreNuits;
	}

	public double getMontantFacture() {
		return this.chambre.getTarifNuitee() * this.nombreNuits;
	}

	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public void setNombreNuits(int nombreNuits) {
		this.nombreNuits = nombreNuits;
	}

	public ZonedDateTime getDateCreationReservation() {
		return dateCreation;
	}
	
	public ZonedDateTime getDateModificationReservation() {
		return dateModification;
	}
	
	public LocalDate getDateArrivee() {
		return dateArrivee;
	}
	
	public LocalDate getDateDepart() {
		return dateDepart;
	}
	
	public boolean isEstAnnulee() {
		return estAnnulee;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setDateCreationReservation(ZonedDateTime dateCreationReservation) {
		this.dateCreation = dateCreationReservation;
	}

	public void setDateModificationReservation(ZonedDateTime dateModificationReservation) {
		this.dateModification = dateModificationReservation;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setEstAnnulee(boolean estAnnulee) {
		this.estAnnulee = estAnnulee;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergementID(Hebergement hebergement) {
		this.hebergement = hebergement;
	}
	
	@Override
	public String toString() {
		return "\n\n\nNom de la classe:\t Reservation" +  "\nDescription:\t Cette classe permet de définir une reservation" + 
        		"\nChamps de la classe:\n\t -id (id de la chambre):\t" + this.getId() + 
        		"\n\t -dateCreation :\t " + this.getDateCreationReservation().toString() + 
        		"\n\t -dateModification :\t " + this.getDateModificationReservation().toString() + 
        		"\n\t -dateArrivee :\t " + this.getDateArrivee().toString() + 
        		"\n\t -dateDepart :\t " + this.getDateDepart().toString() + 
        		"\n\t -nombreNuits :\t " + this.getNombreNuits() + 
        		"\n\t -montantFacture :\t " + this.getMontantFacture() + 
        		"\n\t -Client :\t (Id: " + this.getClient().getId() + "Nom:" + this.getClient().getNom() + ")" +
        		"\n\t -Hebergement :\t (Id: " + this.getHebergement().getId() + "Nom:" + this.getHebergement().getNom() + ")" +
        		"\n\t -Chambre :\t (Id: " + this.getChambre().getId() + "Nom:" + this.getChambre().getTarifNuitee() + ")" +
        		"\n\t -estAnnulee :\t " + this.isEstAnnulee();
	}

}
