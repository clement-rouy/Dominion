package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Copper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Action {
    public Moneylender() {
        super("Moneylender", 4);
    }

    @Override
    public void play(Player p) {

        int x =0;
        ListOfCards listeCarte = p.getCardsInHand();
        if (p.getCardsInHand().contains(p.getAllCards().getCard("Copper"))) {
            String input = p.chooseCard("Ecartez un copper pour gagner 3 Pièces", listeCarte, true);
            if (input.equals("Copper")) {
                for (Card carte : listeCarte){
                    if (carte.getName().equals("Copper")){
                        x++;
                    }
                }
                if (x == 0){
                    p.incrementMoney(0);
                }
                else {
                    p.removeFromHand("Copper");
                    p.incrementMoney(3);
                }
            }
        }


    }
}