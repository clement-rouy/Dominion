package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

/**
 * Carte Jardins (Gardens)
 *
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends Action {
    public Gardens() {
        super("Gardens", 4);
    }

    @Override
    public void play(Player p) {
       int nCarte = p.getAllCards().size();

    }
}