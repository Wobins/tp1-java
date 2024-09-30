package ca.uqac.ange_wobinwo.hebergement;

import ca.uqac.ange_wobinwo.region.Rue;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Hebergement {
	private int id;
	private static int idCompteur = 0;
	private String nom;
	private Service service;
	private TypeHebergement typeHebergement;
	private Rue rue;
	private int numeroRue;

	// Constructeur
	public Hebergement(String nom, Service service, TypeHebergement typeHebergement, Rue rue, int numeroRue) {
		this.setId(++idCompteur);
		this.setNom(nom);
		this.setService(service);
		this.setTypeHebergement(typeHebergement);
		this.setRue(rue);
		this.setNumeroRue(numeroRue);
	}

	// Getters
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Service getService() {
		return service;
	}
	
	public TypeHebergement getTypeHebergement() {
		return typeHebergement;
	}
	
	public Rue getRue() {
		return rue;
	}
	
	public int getNumeroRue() {
		return numeroRue;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void setTypeHebergement(TypeHebergement typeHebergement) {
		this.typeHebergement = typeHebergement;
	}

	public void setRue(Rue rue) {
		this.rue = rue;
	}

	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}
	
	

}
