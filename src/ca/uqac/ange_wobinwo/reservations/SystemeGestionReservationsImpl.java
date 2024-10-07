package ca.uqac.ange_wobinwo.reservations;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class SystemeGestionReservationsImpl implements SystemeGestionReservations {
	private List<Reservation> reservations;
	
	public SystemeGestionReservationsImpl() {
		this.reservations = new ArrayList<Reservation>();
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "SystemeGestionReservationsImpl");
	}

	@Override
	public List<Reservation> consulterReservations() {
		Utilitaires.logToFile("INFO", "éxécution de la méthode [consulterReservations]", "SystemeGestionReservationsImpl");
		return reservations;
	}

	@Override
	public Reservation trouverReservation(int id) {
		Utilitaires.logToFile("INFO", "éxécution de la méthode [trouverReservation]", "SystemeGestionReservationsImpl");
		int i = 0;
		Reservation resultat = null;
		
		for(Reservation reservation : reservations) {
			if (reservation.getId() == id) {
				resultat = reservations.get(i);
				break;
			}
			
			++i;
		}
	
		return resultat;
	}

	@Override
	public Reservation effectuerReservation(Reservation reservation) {
		Utilitaires.logToFile("INFO", "éxécution de la méthode [effectuerReservation]", "SystemeGestionReservationsImpl");
		reservation.setDateCreationReservation(ZonedDateTime.now());
		reservation.setDateModificationReservation(ZonedDateTime.now());
		reservation.getClient().setDatePremiereReservation(LocalDateTime.now());
		reservation.setEstAnnulee(false);
		reservation.getChambre().setEstDisponible(false);
		reservations.add(reservation);
		
		return reservation;
	}

	@Override
	public void annulerReservation(int id) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [annulerReservation]", "SystemeGestionReservationsImpl");
		Reservation reservation = trouverReservation(id);
		reservation.setDateModificationReservation(ZonedDateTime.now());
		reservation.getChambre().setEstDisponible(true);
		reservation.setEstAnnulee(true);	
		System.out.println("Reservation annulee");
		System.out.println(reservation);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [annulerReservation]", "SystemeGestionReservationsImpl");
	}

	@Override
	public String toString() {
		return "SystemeGestionReservationsImpl: classe faisant office de service de gestion des réservations.";
	}

	
}
