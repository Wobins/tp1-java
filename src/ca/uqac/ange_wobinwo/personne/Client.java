package ca.uqac.ange_wobinwo.personne;

import java.time.LocalDateTime;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Client extends PotentielClient {
	private int id;
	private static int idCompteur = 0;
	private LocalDateTime datePremiereReservation;

	public Client(String nom, String courriel, String numeroPhone) {
		super(nom, courriel, numeroPhone);
		this.id = ++idCompteur;
		this.datePremiereReservation = null;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Client:id#".concat(Integer.toString(this.id)));
	}
	
	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Client:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public LocalDateTime getDatePremiereReservation() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [datePremiereReservation]", "Client:id#".concat(Integer.toString(this.id)));
		return datePremiereReservation;
	}

	//Setters
	public void setDatePremiereReservation(LocalDateTime _datePremiereReservation) {
		this.datePremiereReservation = _datePremiereReservation;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [datePremiereReservation] modifiée", "Client:id#".concat(Integer.toString(this.id)));
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t Client" +  "\nDescription:\t Cette classe permet de définir un client" + 
        		"\nChamps de la classe:\n\t -id (identifiant du client):\t" + this.getId() + 
        		"\n\t -nom (nom du client):\t" + this.getNom().toUpperCase() +
        		"\n\t -courriel (courriel du client):\t" + this.getCourriel() +
        		"\n\t -numeroPhone (numero de telephone du client):\t" + this.getNumeroPhone() +
        		"\n\t -datePremiereReservation (date de premiere reservation):\t" + this.getDatePremiereReservation();
    }


}
