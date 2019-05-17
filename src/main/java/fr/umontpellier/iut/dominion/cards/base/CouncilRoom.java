package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

/**
 * Carte Chambre du conseil (Council Room)
 * <p>
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends Action {
    public CouncilRoom() {
        super("Council Room", 5);

    }

    @Override
    public void play(Player p) {
        for (int i = 0; i < 4; i++) {
            p.drawToHand();
        }
        p.incrementBuys(1);
        for (int j = 0; j < p.getGame().getNumberOfPlayers(); j++) {
            Player player = p.getGame().getPlayer(j);
            if (player != p) {
                player.drawToHand();
            }
        }
    }
}