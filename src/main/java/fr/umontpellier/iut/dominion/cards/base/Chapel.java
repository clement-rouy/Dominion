package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

/**
 * Carte Chapelle (Chapel)
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Action {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {
        for (int i = 0; i < 3; i++) {
            String carteJetee = p.chooseCard("choisissez une carte à écarter", p.getCardsInHand(), true);
            if (!carteJetee.equals("")) {
                p.getGame().trashCard(p.getCardsInHand().getCard(carteJetee));
                p.removeFromHand(carteJetee);
            }
        }
    }
}