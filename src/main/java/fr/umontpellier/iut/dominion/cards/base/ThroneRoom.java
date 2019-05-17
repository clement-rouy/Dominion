package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Action {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(2);
        ListOfCards listeCarteAChoisir = new ListOfCards();
        for (Card carte : p.getCardsInHand()){
            if (carte.getTypes().contains(CardType.Action)){
                listeCarteAChoisir.add(carte);
            }
        }
        if (listeCarteAChoisir.size()>0) {
            String carteAJouer = p.chooseCard("choisissez une carte action à jouer 2 fois",listeCarteAChoisir,false);
            p.playCard(carteAJouer);
            p.playCard(carteAJouer);
            p.addToHand(p.getAllCards().getCard(carteAJouer));
        }

    }
}