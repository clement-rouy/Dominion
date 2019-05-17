package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Victory;

/**
 * Carte Duché (Duchy)
 *
 * 3 VP
 */
public class Duchy extends Victory {
    public Duchy() {
        super("Duchy", 5);
    }

    public int victoryValue(Player p) {
        return 3;
    }
}