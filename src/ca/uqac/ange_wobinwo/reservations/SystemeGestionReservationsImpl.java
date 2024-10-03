package ca.uqac.ange_wobinwo.reservations;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class SystemeGestionReservationsImpl implements SystemeGestionReservations {
	public List<Reservation> reservations;
	
	public SystemeGestionReservationsImpl() {
		this.reservations = new ArrayList<Reservation>();
	}

	@Override
	public List<Reservation> consulterReservations() {
		return reservations;
	}

	@Override
	public Reservation trouverReservation(int id) {
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
		Reservation reservation = trouverReservation(id);
		reservation.setDateModificationReservation(ZonedDateTime.now());
		reservation.getChambre().setEstDisponible(false);
		reservation.setEstAnnulee(true);	
		System.out.println("Reservation annulee");
		System.out.println(reservation);
	}

	@Override
	public String toString() {
		return "SystemeGestionReservationsImpl: classe des reservations";
	}

	
}
