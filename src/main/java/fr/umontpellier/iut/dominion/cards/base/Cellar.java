package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

import java.util.ArrayList;

/**
 * Carte Cave (Cellar)
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Action {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        ListOfCards carteEnMain = p.getCardsInHand();
        ArrayList<String> listeCarteEnlevee = new ArrayList<>();
        for (int i = 0; i < carteEnMain.size(); i++) {
            String carte = p.chooseCard("Choisissez une carte à défausser", carteEnMain, true);
            if (carte.equals("")) {
                break;
            }
            p.removeFromHand(carte);
            p.discardCard(carteEnMain.getCard(carte));
            listeCarteEnlevee.add(carte);
            carteEnMain = p.getCardsInHand();
        }
        for (int i=0 ; i<listeCarteEnlevee.size(); i++) {
            p.drawToHand();
        }

    }
}