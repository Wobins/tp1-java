package reservations;

import java.time.ZonedDateTime;
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
	private List<Reservation> reservations;

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
		reservation.setEstAnnulee(false);
		
		return reservation;
	}

	@Override
	public void annulerReservation(int id) {
		Reservation reservation = trouverReservation(id);
		reservation.setEstAnnulee(true);		
	}


}
