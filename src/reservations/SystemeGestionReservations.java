package reservations;

import java.util.List;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public interface SystemeGestionReservations {
	public List<Reservation> consulterReservations();
	
//    public List<Reservation> consulterReservationsAnnulees(bool statutAnnulation);
	
    public Reservation trouverReservation(int id);
    
    public Reservation effectuerReservation(Reservation reservation);
    
    public void annulerReservation(int id);

}
