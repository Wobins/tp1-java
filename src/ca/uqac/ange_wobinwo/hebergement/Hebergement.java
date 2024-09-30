package ca.uqac.ange_wobinwo.hebergement;

import java.util.ArrayList;

import ca.uqac.ange_wobinwo.region.Rue;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

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
	private ArrayList<Service> services;
	private ArrayList<Chambre> chambres;
	private TypeHebergement typeHebergement;
	private Rue rue;
	private int numeroRue;

	// Constructeur
	public Hebergement(String nom, ArrayList<Service> services, TypeHebergement typeHebergement, Rue rue, int numeroRue) {
		this.setId(++idCompteur);
		this.setNom(nom);
		this.setServices(services);
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
	
	public ArrayList<Service> getService() {
		return services;
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
	
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
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

	public void setChambres(ArrayList<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	// Ajouter une chambre a un hebergement
	public void ajouterChambre(Chambre chambre) {
		chambres.add(chambre);
	}

	// Ajouter un service a un hebergement
	public void ajouterVille(Service service) {
		services.add(service);
	}
	
	// Supprimer une chambre d'un hebergement
	public void supprimerChambre(int numeroChambre) {
		int resultat = Utilitaires.supprimerElementListe(chambres, numeroChambre, Chambre::getNumero);
		
		if (resultat != -1) {
		   System.out.println(String.format("La chambre avec pour numero %s a ete retiree de l'hebergement %s avec succes", 
				   				numeroChambre, this.getNom()));
		} else {
		    System.out.println(String.format("La chambre avec pour id %s n'a pas ete trouve dans la province %s.",
		    					numeroChambre, this.getNom()));
		}
	}
	
	

}
