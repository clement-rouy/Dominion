package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Action;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 */
public class Artisan extends Action {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p) {
        ListOfCards listCard = new ListOfCards();
        listCard.addAll(p.getGame().availableSupplyCards());
        for(int i=0;i<listCard.size();i++){
            if (listCard.get(i).getCost()>5){
                listCard.remove(listCard.get(i).getName());
            }
        }
        String nomCarte = p.chooseCard("Choisissez une carte coutant au maximum 5 Pièces",listCard,false);
        Card carte = p.getGame().removeFromSupply(nomCarte);
        p.addToHand(carte);
        String carteMain = p.chooseCard("choisissez une carte de votre main à mettre sur votre deck",p.getCardsInHand(),false);
        p.addToDraw(p.getAllCards().getCard(carteMain));
        p.removeFromHand(carteMain);
    }
}