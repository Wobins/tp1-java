package ca.uqac.ange_wobinwo.besoin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ca.uqac.ange_wobinwo.hebergement.Service;
import ca.uqac.ange_wobinwo.hebergement.TypeChambre;
import ca.uqac.ange_wobinwo.hebergement.TypeHebergement;
import ca.uqac.ange_wobinwo.personne.PotentielClient;
import ca.uqac.ange_wobinwo.region.Adresse;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Besoin {
	private int id;
	private static int idCompteur = 0;
	private PotentielClient potentielclient;
	private TypeChambre typeChambreSouhaite;
	private TypeHebergement typeHebergementSouhaite;
	private Adresse adresse;
	private double tarifMax;
	private ArrayList<Service> services;
	private LocalDateTime dateCreation;
	private LocalDate dateArrivee;
	private LocalDate dateDepart;
	
	// Constructeur
	public Besoin(PotentielClient potentielClient, double tarif, TypeChambre typeChambre, TypeHebergement typeHebergement, LocalDate dateArrivee, LocalDate dateDepart) {
		this.id = ++idCompteur;
		this.potentielclient = potentielClient;
		this.typeChambreSouhaite = typeChambre;
		this.typeHebergementSouhaite = typeHebergement;
		this.adresse = null;
		this.tarifMax = tarif;
		this.services = new ArrayList<Service>();
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.dateCreation = null;
		Utilitaires.logToFile("INFO", "Création d'un nouvel objet", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	// Getters
	public int getId() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [id]", "Besoin:id#".concat(Integer.toString(this.id)));
		return id;
	}
	
	public TypeChambre getTypeChambreSouhaite() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [typeChambreSouhaite]", "Besoin:id#".concat(Integer.toString(this.id)));
		return typeChambreSouhaite;
	}
	
	public PotentielClient getPotentielclient() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [potentielClient]", "Besoin:id#".concat(Integer.toString(this.id)));
		return potentielclient;
	}
	
	public TypeHebergement getTypeHebergementSouhaite() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [typeHebergementSouhaite]", "Besoin:id#".concat(Integer.toString(this.id)));
		return typeHebergementSouhaite;
	}
	
	public double getTarifMax() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [tarifMax]", "Besoin:id#".concat(Integer.toString(this.id)));
		return tarifMax;
	}
	
	public Adresse getAdresse() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [adresse]", "Besoin:id#".concat(Integer.toString(this.id)));
		return adresse;
	}
	
	public ArrayList<Service> getServices() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [services]", "Besoin:id#".concat(Integer.toString(this.id)));
		return services;
	}
	
	public LocalDate getDateDepart() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateDepart]", "Besoin:id#".concat(Integer.toString(this.id)));
		return dateDepart;
	}
	
	public LocalDate getDateArrivee() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateArrivee]", "Besoin:id#".concat(Integer.toString(this.id)));
		return dateArrivee;
	}
	
	public LocalDateTime getDateCreation() {
		Utilitaires.logToFile("INFO", "Récuperation de l'attribut [dateCreation]", "Besoin:id#".concat(Integer.toString(this.id)));
		return dateCreation;
	}
	
	// Setters
	public void setPotentielclient(PotentielClient potentielclient) {
		this.potentielclient = potentielclient;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [potentielClient] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	public void setId(int id) {
		this.id = id;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [id] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	public void setTypeChambreSouhaite(TypeChambre typeChambre) {
		this.typeChambreSouhaite = typeChambre;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [typeChambreSouhaite] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setTypeHebergementSouhaite(TypeHebergement typeHebergement) {
		this.typeHebergementSouhaite = typeHebergement;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [typeHebergementSouhaite] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [adresse] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setTarifMax(double tarifMax) {
		this.tarifMax = tarifMax;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [tarifMax] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [services] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateCreation] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateDepart] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
		Utilitaires.logToFile("WARNING", "Valeur de l'attribut [dateArrivee] modifiée", "Besoin:id#".concat(Integer.toString(this.id)));
	}
	
	// Ajouter un service a un besoin
	public void ajouterService(Service service) {
		Utilitaires.logToFile("INFO", "Début d'éxécution de la méthode [ajouterService]", "Besoin:id#".concat(Integer.toString(this.id)));
		this.services.add(service);
		Utilitaires.logToFile("SUCCESS", "Fin d'éxécution de la méthode [ajouterService]", "Besoin:id#".concat(Integer.toString(this.id)));
	}

	
	// Redefinir la methode toString
	@Override
	public String toString() {
		StringBuilder services_souhaites = new StringBuilder();
		this.getServices().forEach(s -> services_souhaites.append("\n\t\tId: ").append(s.getId()).append("\t\tService: ").append(s.getNom()));
		
		return "\n\n\nNom de la classe:\t Besoin" +  "\nDescription:\t Cette classe permet de définir un besoin en attente" + 
        		"\nChamps de la classe:" + 
				"\n\t -id:\t" + this.getId() + 
        		"\n\t -potentielClient :\t (Numero: " + this.getPotentielclient().getNumeroPhone() + "\tNom: "  + this.getPotentielclient().getNom() + "\tCourriel: " + this.getPotentielclient().getCourriel() + " etc.)" + 
        		"\n\t -typeChambreSouhaite :\t " + this.getTypeChambreSouhaite().getNom() + 
        		"\n\t -typeHebergementSouhaite :\t " + this.getTypeHebergementSouhaite().getNom() + 
        		"\n\t -dateCreation :\t " + this.getDateCreation() + 
        		"\n\t -dateDepart :\t " + this.getDateDepart() + 
        		"\n\t -dateArrivee :\t " + this.getDateArrivee() + 
        		"\n\t -tarifMax :\t " + this.getTarifMax() +
        		"\n\t -services :" + services_souhaites +
				"\n\t -Adresse :\t (Ville: " + this.getAdresse().getVille() +
				"\tProvince: " + this.getAdresse().getProvince() +
				"\tPays: " + this.getAdresse().getPays() + ")";
	}
}
