package ca.uqac.ange_wobinwo.personne;

public class PotentielClient {
	protected String nom;
	protected String courriel;
	protected String numeroPhone;
	
	public PotentielClient(String nom, String courriel, String numeroPhone) {
		this.setNom(nom);
		this.setCourriel(courriel);
		this.setNumeroPhone(numeroPhone);
	}
	
	// Getters
	public String getNom() {
		return nom;
	}

	public String getCourriel() {
		return courriel;
	}

	public String getNumeroPhone() {
		return numeroPhone;
	}

	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public void setNumeroPhone(String numeroPhone) {
		this.numeroPhone = numeroPhone;
	}
	
	// Redefinir la methode toString()
	@Override
    public String toString() {
        return "\n\n\nNom de la classe:\t PotentielClient" +  "\nDescription:\t Cette classe permet de définir un potentiel client susceptible de reserver" + 
        		"\nChamps de la classe:\n\t -nom (nom du client):\t" + this.getNom().toUpperCase() +
        		"\n\t -courriel (courriel du client):\t" + this.getCourriel() +
        		"\n\t -numeroPhone (numero de telephone du client):\t" + this.getNumeroPhone();
    }

}
