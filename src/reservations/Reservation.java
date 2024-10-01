package reservations;

import java.time.*;

import ca.uqac.ange_wobinwo.hebergement.Chambre;
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
	private int chambreID;
	private double montantFacture;
	private String clientID;
	private Chambre chambre;
	private Client client;
	private ZonedDateTime dateCreationReservation;
	private ZonedDateTime dateModificationReservation;
	private ZonedDateTime dateArrivee;
	private ZonedDateTime dateDepart;
	private boolean estAnnulee;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public ZonedDateTime getDateCreationReservation() {
		return dateCreationReservation;
	}
	
	public ZonedDateTime getDateModificationReservation() {
		return dateModificationReservation;
	}
	
	public ZonedDateTime getDateArrivee() {
		return dateArrivee;
	}
	
	public ZonedDateTime getDateDepart() {
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
		this.dateCreationReservation = dateCreationReservation;
	}

	public void setDateModificationReservation(ZonedDateTime dateModificationReservation) {
		this.dateModificationReservation = dateModificationReservation;
	}

	public void setDateArrivee(ZonedDateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void setDateDepart(ZonedDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setEstAnnulee(boolean estAnnulee) {
		this.estAnnulee = estAnnulee;
	}

}
