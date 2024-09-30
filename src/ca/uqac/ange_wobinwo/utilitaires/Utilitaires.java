package ca.uqac.ange_wobinwo.utilitaires;

import java.util.List;
import java.util.function.Function;

/**
 * Title:        TP1
 * Description:  TP1 pour cours 8INF957
 * Copyright:    Copyright (c) 2024
 * School:      UQAC
 * @author Ange Wobinwo
 * @version 1.0
 */

public class Utilitaires {

	// Fonction pour recuperer l'index d'un element d'un List a partir de son id
	public static <T> int retrouverIndexElement(List<T> list, int id, Function<T, Integer> getIdFunction) {
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            if (getIdFunction.apply(element) == id) {
                return i;
            }
        }
        return -1;
    }

}
