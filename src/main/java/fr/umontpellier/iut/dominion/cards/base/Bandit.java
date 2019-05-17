package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Attack;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends Attack {
    public Bandit() {
        super("Bandit", 5);
    }


    @Override
    public void faireAction(Player p) {
        p.gainFromSupply("Gold");
    }

    @Override
    public void faireAttaque(Player p) {
        Card carte1 = p.drawCard();
        Card carte2 = p.drawCard();
        ListOfCards choix = new ListOfCards();
        ListOfCards listeCopper = new ListOfCards();
        choix.add(carte1);
        choix.add(carte2);
        if (choix.get(0).getTypes().contains(CardType.Treasure) || choix.get(1).getTypes().contains(CardType.Treasure)){
            for (Card carte : choix){
                if (carte.getName()=="Copper"){
                    listeCopper.add(carte);
                    choix.remove(carte);
                }
            }
            if (listeCopper.size() == 1){
                p.discardCard(listeCopper.get(0));
                p.removeFromHand(listeCopper.get(0));
                if (choix.get(0).getTypes().contains(CardType.Treasure)){
                    Card carteJetee = p.getGame().trashCard(choix.get(0));
                    p.removeFromHand(carteJetee);
                }
                else {
                    p.discardCard(choix.get(0));
                    p.removeFromHand(choix.get(0));
                }
            }
            else if (listeCopper.size() == 2){
                p.discardCard(carte1);
                p.discardCard(carte2);
                p.removeFromHand(carte1);
                p.removeFromHand(carte2);
            }
            else {
                String carteChoisie = p.chooseCard("choisissez une carte à écarter, le reste sera defausse",choix,false);
                choix.remove(carteChoisie);
                p.getGame().trashCard(p.getCardsInHand().getCard(carteChoisie));
                p.discardCard(choix.get(0));
                p.removeFromHand(choix.get(0));
                p.removeFromHand(carteChoisie);
            }
        }
        else{
            p.discardCard(carte1);
            p.discardCard(carte2);
            p.removeFromHand(carte1);
            p.removeFromHand(carte2);
        }
    }
}
