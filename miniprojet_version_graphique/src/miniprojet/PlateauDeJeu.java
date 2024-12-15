/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;

/**
 *
 * @author eloi
 */
public class PlateauDeJeu {
    
    private Combinaison combinaisonSecrete;

    public PlateauDeJeu(String[] couleursPossibles) {
        combinaisonSecrete = new Combinaison();
        combinaisonSecrete.genererAleatoire(couleursPossibles, 4);
    }

    public Combinaison getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    public int verifierCombinaisonExacte(Combinaison tentative) {
        int exact = 0;

        for (int i = 0; i < tentative.getTaille(); i++) {
            if (tentative.getPion(i).equals(combinaisonSecrete.getPion(i))) {
                exact++;
            }
        }

        return exact;
    }

    public int verifierCouleursCorrectes(Combinaison tentative) {
        int correctes = 0;
        ArrayList<Pion> copieSecrete = new ArrayList<>(combinaisonSecrete.getPions());
        ArrayList<Pion> pionsTentative = new ArrayList<>(tentative.getPions());

        // Exclure les exacts pour éviter les doublons
        for (int i = 0; i < tentative.getTaille(); i++) {
            if (tentative.getPion(i).equals(combinaisonSecrete.getPion(i))) {
                copieSecrete.set(i, null); // Marquer comme vérifié
                pionsTentative.set(i, null); // Marquer pour ne pas le compter comme correct
            }
        }

        // Vérifier les couleurs correctes uniquement
        for (Pion pion : pionsTentative) {
            if (pion != null && copieSecrete.contains(pion)) {
                correctes++;
                copieSecrete.remove(pion); // Retirer pour éviter les doublons
            }
        }

        return correctes;
    }
}

