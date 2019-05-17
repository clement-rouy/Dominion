package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Malediction;

/**
 * Carte Malédiction (Curse)
 *
 * -1 VP
 */
public class Curse extends Malediction {
    public Curse() {
        super("Curse", 0);
    }

    public int victoryValue(Player p) {
        return -1;
    }
}