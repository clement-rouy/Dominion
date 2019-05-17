package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Rénovation (Remodel)
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Action {
    public Remodel() {
        super("Remodel", 4);
    }

    @Override
    public void play(Player p) {
        String carteChoisie = p.chooseCard("Ecartez une carte de votre main",p.getCardsInHand(),false);
        Card carte = p.getCardsInHand().getCard(carteChoisie);
        p.discardCard(carte);
        p.removeFromHand(carte);
        int prixCarte = carte.getCost()+2;
        ListOfCards choix = new ListOfCards();
        for (int i=0; i<p.getGame().getSupplyStacks().size();i++) {
            choix.addAll(p.getGame().getSupplyStacks().get(i));
        }
        String input =  p.chooseCard("Choisissez une carte coutant jusqu'a 2 pièces de plus que la carte écarté précédement",choix,false);
        while (p.getGame().getFromSupply(input).getCost()>prixCarte) {
            input =  p.chooseCard("Choisissez une carte coutant jusqu'a 2 pièces de plus que la carte écarté précédement",choix,false);
        }
        p.gainFromSupply(input);
    }
}