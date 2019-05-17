package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Treasure;

/**
 * Carte Cuivre (Copper)
 *
 * 1 Pièce
 */
public class Copper extends Treasure {
    public Copper() {
        super("Copper", 0);
    }

    public int treasureValue() {
        return 1;
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(this.treasureValue());
    }
}
