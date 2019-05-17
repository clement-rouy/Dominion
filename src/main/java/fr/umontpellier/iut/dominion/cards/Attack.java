package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;

import java.util.ArrayList;

public abstract class Attack extends Action {
    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Attack(String name, int cost) {
        super(name, cost);
        this.getTypes().add(CardType.Reaction);
    }

    public abstract void faireAction(Player p);
    public abstract void faireAttaque(Player p);

    @Override
    public void play(Player p) {
        faireAction(p);
        for (Player joueur : p.getOtherPlayers()){
            boolean reaction = false;
            Card carteReaction;
            for (Card carte : joueur.getCardsInHand()){
                if (carte.getTypes().contains(CardType.Reaction)){
                    reaction = true;
                    carteReaction = carte;
                    break;
                }
            }
            if (reaction){
                ArrayList<String> choix = new ArrayList<>();
                choix.add("y");
                choix.add("n");
                if(joueur.chooseOption("Réagire à l'attaque?(y or n)", choix, false) == "n") {
                    faireAttaque(joueur);
                }
            }
            else {
                faireAttaque(joueur);
            }
        }
    }
}
