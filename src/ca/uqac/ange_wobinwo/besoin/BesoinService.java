package ca.uqac.ange_wobinwo.besoin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BesoinService implements IBesoinService {
	public List<Besoin> BesoinsEnAttente;
	
	public BesoinService() {
		this.BesoinsEnAttente = new ArrayList<Besoin>();
	}

	@Override
	public List<Besoin> ConsulterBesoins() {
		return BesoinsEnAttente;
	}

	@Override
	public void AjouterBesoinEnAttente(Besoin besoin_en_attente) {
		besoin_en_attente.setDateCreation(LocalDateTime.now());
		BesoinsEnAttente.add(besoin_en_attente);
		
	}

}
