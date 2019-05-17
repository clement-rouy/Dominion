package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Action {
    public Poacher() {
        super("Poacher", 4);
    }

    @Override
    public void play(Player p){
        p.incrementActions(1);
        p.drawToHand();
        p.incrementMoney(1);
        int nbrPileVide = p.getGame().getSupplyStacks().size() - p.getGame().availableSupplyCards().size();
        while (nbrPileVide > 0){
            String carte = p.chooseCard("choisissez une carte à défausser",p.getCardsInHand(),false);
            p.discardCard(p.getCardsInHand().getCard(carte));
            p.removeFromHand(carte);
            nbrPileVide --;
        }
    }

}
