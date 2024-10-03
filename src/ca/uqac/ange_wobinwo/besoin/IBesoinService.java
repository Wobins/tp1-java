package ca.uqac.ange_wobinwo.besoin;

import java.util.List;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public interface IBesoinService {
	public void AjouterBesoinEnAttente(Besoin besoin_en_attente);
	
	public List<Besoin> ConsulterBesoins();

}
