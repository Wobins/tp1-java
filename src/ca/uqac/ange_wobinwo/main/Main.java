package ca.uqac.ange_wobinwo.main;

import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.region.*;
import ca.uqac.ange_wobinwo.utilitaires.Utilitaires;
import ca.uqac.ange_wobinwo.hebergement.*;
import ca.uqac.ange_wobinwo.personne.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rue r1 = new Rue("Newton");
		Rue r2 = new Rue("Saint-Thomas");
		Rue r3 = new Rue("Chabannelle");
		
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
		
		TypeChambre _simple = new TypeChambre("simple");
		TypeChambre _double = new TypeChambre("double");
		TypeChambre _suite = new TypeChambre("suite");
		
		TypeHebergement hotel = new TypeHebergement("Hotel");
		TypeHebergement motel = new TypeHebergement("Motel");
		TypeHebergement cafe = new TypeHebergement("Cafe");
		TypeHebergement couette = new TypeHebergement("Couette");
		
		Service piscine = new Service("Piscine");
		Service restaurant = new Service("Restaurant");
		Service depanneur = new Service("Depanneur");
		Service cuisinette = new Service("Cuisinette");
		
		Chambre ch1 = new Chambre(_double, 25.6);
		Chambre ch2 = new Chambre(_double, 10);
		Chambre ch3 = new Chambre(_double, 45.0);
		Chambre ch4 = new Chambre(_suite, 543.99);
		Chambre ch5 = new Chambre(_suite, 100.56);
		Chambre ch6 = new Chambre(_suite, 56.7);
		Chambre ch7 = new Chambre(_suite, 34.5);
		Chambre ch8 = new Chambre(_suite, 90.43);
		Chambre ch9 = new Chambre(_simple, 12.2);
		Chambre ch10 = new Chambre(_simple, 78.56);
		Chambre ch11 = new Chambre(_simple, 56);
		
		Hebergement h1 = new Hebergement("Residences Val d'ombrette", hotel, r1, 300);
		ch11.setNumero(101);
		
		q1.ajouterRue(r1);
		q1.ajouterRue(r2);
		q2.ajouterRue(r3);
		
		q1.supprimerRue(1);
		
		v1.ajouterQuartier(q1);
		v3.ajouterQuartier(q2);
		
		v3.supprimerQuartier(8);
		Utilitaires.effacerConsole();
		
		quebec.ajouterVille(v1);
		quebec.ajouterVille(v2);
		ontario.ajouterVille(v3);
		
		canada.ajouterProvince(ontario);
		canada.ajouterProvince(quebec);
		
		h1.ajouterChambre(ch6);
		h1.ajouterChambre(ch11);
		h1.ajouterChambre(ch8);
		
		h1.ajouterService(restaurant);
		h1.ajouterService(piscine);
		
		System.out.println(h1);
		h1.supprimerChambre(ch6.getNumero());
//		h1.supprimerService(piscine.getId());
		System.out.println(h1);
//		System.out.println(ch11);
		
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
//		System.out.println(canada);
//		System.out.println(q1);

	}

}
