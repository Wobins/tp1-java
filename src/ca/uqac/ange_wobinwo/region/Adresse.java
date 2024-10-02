package ca.uqac.ange_wobinwo.region;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */


public class Adresse {
	private int numeroRue;
	private String rue;
	private String ville;
	private String province;
	private String pays;
	
	public Adresse(int _numeroRue, String _rue, String _ville, String _province, String _pays) {
		this.setNumeroRue(_numeroRue);
		this.setRue(_rue);
		this.setVille(_ville);
		this.setProvince(_province);
		this.setPays(_pays);
	}

	// Getters
	public int getNumeroRue() {
		return numeroRue;
	}
	
	public String getRue() {
		return rue;
	}
	
	public String getVille() {
		return ville;
	}

	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getPays() {
		return pays;
	}

	// Setters
	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}
