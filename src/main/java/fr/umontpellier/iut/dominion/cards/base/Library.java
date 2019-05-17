package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;

import java.util.ArrayList;

/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends Action {
    public Library() {
        super("Library", 5);
    }

    @Override
    public void play(Player p) {
        String input;
        ArrayList<String> choix = new ArrayList<>();
        ListOfCards l1 = new ListOfCards();
        ListOfCards l2 = new ListOfCards();
        choix.add("y");
        choix.add("n");
        while (p.numberInHand()<7) {
            p.drawToHand();
            if (p.lastInHand().getTypes().contains(CardType.Action)) {
            l1.add(p.lastInHand());
                input = p.chooseOption("Ecarter cette carte ?", choix, false );
                if (input.equals("y")) {
                    p.discardCard(p.lastInHand());
                    p.removeFromHand(p.lastInHand());
                }
            }
        }

    }
}