package ca.uqac.ange_wobinwo.besoin;

import java.time.LocalDateTime;
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

public class BesoinService implements IBesoinService {
	private List<Besoin> BesoinsEnAttente;
	
	public BesoinService() {
		this.BesoinsEnAttente = new ArrayList<Besoin>();
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "BesoinService");
	}

	@Override
	public List<Besoin> ConsulterBesoins() {
		Utilitaires.logToFile("INFO", "éxécution de la méthode [ConsulterBesoins]", "BesoinService");
		return BesoinsEnAttente;
	}

	@Override
	public void AjouterBesoinEnAttente(Besoin besoin_en_attente) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [AjouterBesoinEnAttente]", "BesoinSerive");
		besoin_en_attente.setDateCreation(LocalDateTime.now());
		BesoinsEnAttente.add(besoin_en_attente);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [AjouterBesoinEnAttente]", "BesoinService");
	}
	
	@Override
	public String toString() {
		return "BesoinService: classe faisant office de service de gestion des besoins en attente";
	}

}
