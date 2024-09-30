package ca.uqac.ange_wobinwo.main;

import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.region.*;
import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.personne.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rue r1 = new Rue("Newton");
		Rue r2 = new Rue("Saint-Thomas");
		Rue r3 = new Rue("Chabannelle");
		Service s1 = new Service("Piscine");
		Service s2 = new Service("depanneur");
		TypeHebergement t1 = new TypeHebergement("Motel");
		TypeHebergement t2 = new TypeHebergement("Hotel");
		TypeChambre tc1 = new TypeChambre("simple");
		TypeChambre tc2 = new TypeChambre("double");
		TypeChambre tc3 = new TypeChambre("suites");
		Client c1 = new Client("Joel", "joel@mail.com", "+1 418-718-7280");
		Quartier q1 = new Quartier("Des oiseaux");
		Quartier q2 = new Quartier("Fraubourg");
		Ville v1 = new Ville("Chicoutimi");
		Ville v2 = new Ville("Montreal");
		Ville v3 = new Ville("Ottawa");
		Province quebec = new Province("quebec");
		Province ontario = new Province("ontario");
		Pays canada = new Pays("Canada");
		
		q1.ajouterRue(r1);
		q1.ajouterRue(r2);
		q2.ajouterRue(r3);
//		System.out.println(q1.supprimerRue(1));
		v1.ajouterQuartier(q1);
		v1.ajouterQuartier(q2);
//		v1.supprimerQuartier(2);
		quebec.ajouterVille(v1);
		quebec.ajouterVille(v2);
		ontario.ajouterVille(v3);
		canada.ajouterProvince(ontario);
		canada.ajouterProvince(quebec);
		
//		System.out.println(r1);
//		r2.setNom("Morel");
//		System.out.println(r2);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(t2);
//		tc3.setNom("suite");
//		System.out.println(tc3);
//		System.out.println(c1);
//		System.out.println(v1);
//		System.out.println(quebec);
		System.out.println(canada);
//		System.out.println(q1);

	}

}
