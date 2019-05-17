package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;

/**
 * Carte Vassal
 *
 * +2 Pièces.
 * Défaussez la première carte de votre deck. Si c'est une carte Action, vous pouvez la jouer.
 */
public class Vassal extends Action {
    public Vassal() {
        super("Vassal", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        ArrayList<String> listeChoix = new ArrayList<>();
        listeChoix.add("y");
        listeChoix.add("n");
        if (p.getDraw().get(0).getTypes().contains(CardType.Action)){
            Card carteTiree = p.drawToHand();
            String choix = p.choose("choisissez de jouer cette carte ou non",listeChoix,false,true);
            if (choix == "y"){
                p.playCard(carteTiree.getName());
            }
            else {
                p.addToDraw(carteTiree);
                p.removeFromHand(carteTiree);
            }
        }
        else {
            p.discardCard(p.getDraw().get(0));
        }


    }

}
