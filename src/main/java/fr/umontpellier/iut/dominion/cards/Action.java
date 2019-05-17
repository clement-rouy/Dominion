package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;

import java.util.ArrayList;

public abstract class Action extends Card {
    private ArrayList<CardType> type = new ArrayList<>();

    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Action(String name, int cost) {
        super(name, cost);
        this.type.add(CardType.Action);
    }

    @Override
    public abstract void play(Player p);

    /**
     * Modification de la méthode getTypes
     */

    @Override
    public ArrayList<CardType> getTypes() {
        return this.type;
    }
}


