package ca.uqac.ange_wobinwo.reservations;

import java.time.*;

import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.personne.Client;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

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
		this.montantFacture = _nbreNuits * _chambre.getTarifNuitee();
		this.nombreNuits = _nbreNuits;
		this.estAnnulee = false;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Reservation:id#".concat(Integer.toString(this.id)));
	}
	
	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Reservation:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public int getNombreNuits() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [nombreNuits]", "Reservation:id#".concat(Integer.toString(this.id)));
		return nombreNuits;
	}

	public double getMontantFacture() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [montantFacture]", "Reservation:id#".concat(Integer.toString(this.id)));
		return montantFacture;
	}
	
	public ZonedDateTime getDateModificationReservation() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateModificationReservation]", "Reservation:id#".concat(Integer.toString(this.id)));
		return dateModification;
	}
	
	public LocalDate getDateArrivee() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateArrivee]", "Reservation:id#".concat(Integer.toString(this.id)));
		return dateArrivee;
	}
	
	public ZonedDateTime getDateCreationReservation() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateCreationReservation]", "Reservation:id#".concat(Integer.toString(this.id)));
		return dateCreation;
	}
	
	public LocalDate getDateDepart() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateDepart]", "Reservation:id#".concat(Integer.toString(this.id)));
		return dateDepart;
	}
	
	public boolean isEstAnnulee() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [estAnnulee]", "Reservation:id#".concat(Integer.toString(this.id)));
		return estAnnulee;
	}
	
	public Client getClient() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [client]", "Reservation:id#".concat(Integer.toString(this.id)));
		return client;
	}
	
	public Hebergement getHebergement() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [hebergement]", "Reservation:id#".concat(Integer.toString(this.id)));
		return hebergement;
	}
	
	public Chambre getChambre() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [chambre]", "Reservation:id#".concat(Integer.toString(this.id)));
		return chambre;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [id] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [montantFacture] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	public void setNombreNuits(int nombreNuits) {
		this.nombreNuits = nombreNuits;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [nombreNuits] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateCreationReservation(ZonedDateTime dateCreationReservation) {
		this.dateCreation = dateCreationReservation;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateCreationReservation] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateModificationReservation(ZonedDateTime dateModificationReservation) {
		this.dateModification = dateModificationReservation;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateModificationReservation] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateArrivee] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateDepart] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setEstAnnulee(boolean estAnnulee) {
		this.estAnnulee = estAnnulee;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [estAnnulee] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [chambre] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setClient(Client client) {
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [client] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
		this.client = client;
	}

	public void setHebergementID(Hebergement hebergement) {
		this.hebergement = hebergement;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [hebergement] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
	public String toString() {
		return "\n\n\nNom de la classe:\t Reservation" +  "\nDescription:\t Cette classe permet de définir une reservation" + 
        		"\nChamps de la classe:\n\t -id (id de la reservation):\t" + this.getId() + 
        		"\n\t -dateCreation :\t " + this.getDateCreationReservation().toString() + 
        		"\n\t -dateModification :\t " + this.getDateModificationReservation().toString() + 
        		"\n\t -dateArrivee :\t " + this.getDateArrivee().toString() + 
        		"\n\t -dateDepart :\t " + this.getDateDepart().toString() + 
        		"\n\t -nombreNuits :\t " + this.getNombreNuits() + 
        		"\n\t -montantFacture :\t " + this.getMontantFacture() + 
        		"\n\t -Client :\t (Id: " + this.getClient().getId() + "\tNom: " + this.getClient().getNom() + ")" +
        		"\n\t -Hebergement :\t (Id: " + this.getHebergement().getId() + "\tNom: " + this.getHebergement().getNom() + ")" +
        		"\n\t -Chambre :\t (Id: " + this.getChambre().getId() + "\tType: " + this.chambre.getTypeChambre().getNom() + "\tTarif/Nuit: " + this.getChambre().getTarifNuitee() + "$)" +
        		"\n\t -estAnnulee :\t " + this.isEstAnnulee();
	}

}
