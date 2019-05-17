package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Action {
    public Mine() {
        super("Mine", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards choix = new ListOfCards();
        for (Card carte : p.getCardsInHand()){
            if (carte.getTypes().contains(CardType.Treasure)){
                choix.add(carte);
            }
        }
        String carteChoisie = p.chooseCard("choisissez une carte à écarter de votre main",choix,false);
        Card carteJetee = p.getGame().trashCard(p.getCardsInHand().getCard(carteChoisie));
        p.removeFromHand(carteJetee);
        ListOfCards choix2 = new ListOfCards();
        for (Card carte : p.getGame().availableSupplyCards()){
            if((carte.getTypes().contains(CardType.Treasure)) && (carte.getCost() <= (carteJetee.getCost()+3))){
                choix2.add(carte);
            }
        }
        carteChoisie = p.chooseCard("choisissez une carte tresor a obtenir",choix2,false);
        p.gainFromSupplyToHand(carteChoisie);
    }
}