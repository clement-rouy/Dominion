package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Action {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {

        p.drawToHand();
        p.incrementActions(1);
        ListOfCards list = new ListOfCards();

        list = p.firstCardDraw();
int c = 0;
        String input = p.chooseCard("Écartez les/la cartes de votre choix", list, true );
                while ((!input.equals("")) &&(c<=list.size()-1) ) {
                    p.getGame().trashCard(p.getAllCards().getCard(input));
                    p.removeFromDraw(p.getAllCards().getCard(input));
                    list.remove(input);
                    input = p.chooseCard("Écartez les/la cartes de votre choix", list, true );
                    c++;
                }
                c=0;
        input = p.chooseCard("Écartez les/la cartes de votre choix", list, true );
        while ((!input.equals("")) &&(c<=list.size()-1) ) {
            p.discardCard(p.getAllCards().getCard(input));
            p.removeFromDraw(p.getAllCards().getCard(input));
            list.remove(input);
            if(list.size()<0) {
                input = p.chooseCard("Défaussez les/la cartes de votre choix", list, true );
            }
            c++;
        }

        if (list.size()==2) {
            input = p.chooseCard("Écartez les/la cartes de votre choix", list, false );
            Card c1 = p.getAllCards().getCard(input);
            p.removeFromDraw(c1);
            p.addToDraw(c1);
            list.remove(input);
            Card c2 = list.get(0);
            p.removeFromDraw(c2);
            p.addToDraw(c2);

        }

        }


    }



