package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Treasure;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Treasure {
    public Silver() {
        super("Silver", 3);
    }

    public int treasureValue() {
        return 2;
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(this.treasureValue());

        if (p.getBonusSilver()>0) {
            p.incrementMoney(p.getBonusSilver());
            p.setBonusSilver(0);
        }
    }
}
