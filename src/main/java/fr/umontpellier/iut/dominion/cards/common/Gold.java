package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Treasure;

/**
 * Carte Or (Gold)
 *
 * 3 Pièces
 */
public class Gold extends Treasure {
    public Gold() {
        super("Gold", 6);
    }

    public int treasureValue() {
        return 3;
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(this.treasureValue());

    }
}
