package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Attack;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Attack {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }
    /**
     *redéfinition de runAction
     */
    @Override
    public void faireAction(Player p) {
        p.gainFromSupply("Silver");
        p.addToDraw(p.getDiscard().getCard("Silver"));
    }
    /**
     *redéfinition de runAttack
     */
    @Override
    public void faireAttaque(Player p) {
        ListOfCards choix = new ListOfCards();
        for(Card c : p.getCardsInHand()) {
            if(c.getTypes().contains(CardType.Victory)){
                choix.add(c);
            }
        }
        if(choix.size() == 1){
            p.addToDraw(choix.get(0));
            p.removeFromHand(choix.get(0));
        }
        else{
            if(choix.size() > 1){
                String carte = p.chooseCard("Entrez le nom de la carte que vous souhaitez mettre sur le haut de votre deck", choix, false);
                p.addToDraw(p.getCardsInHand().getCard(carte));
                p.removeFromHand(carte);
            }
        }
    }

}