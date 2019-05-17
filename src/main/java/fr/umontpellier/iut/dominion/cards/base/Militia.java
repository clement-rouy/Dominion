package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Attack;

/**
 * Carte Milice (Militia)
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Attack {
    public Militia() {
        super("Militia", 4);
    }

    @Override
    public void faireAction(Player p) {
        p.incrementMoney(2);
    }

    @Override
    public void faireAttaque(Player p) {
        while(p.getCardsInHand().size() > 3){
            String carteChoisie = p.chooseCard("choisir une carte a defausser",p.getCardsInHand(),false);
            p.discardCard(p.getCardsInHand().getCard(carteChoisie));
            p.removeFromHand(carteChoisie);
        }
    }
}