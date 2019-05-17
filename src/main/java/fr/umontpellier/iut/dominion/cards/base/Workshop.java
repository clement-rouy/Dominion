package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Action {
    public Workshop() {
        super("Workshop", 3);
    }

    @Override
    public void play(Player p) {
        ListOfCards listeCartes = new ListOfCards();
        ListOfCards listeCartesTest = p.getGame().availableSupplyCards();
        for (Card carte : listeCartesTest){
            if (carte.getCost()<= 4){
                listeCartes.add(carte);
            }
        }
        String carteAchetee = p.chooseCard("choisissez une carte coutant au maximum 4 pièces",listeCartes,false);
        p.gainFromSupply(carteAchetee);
    }
}