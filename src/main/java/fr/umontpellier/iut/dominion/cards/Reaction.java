package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.CardType;

public abstract class Reaction extends Action {

    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Reaction(String name, int cost) {
        super(name, cost);
        this.getTypes().add(CardType.Reaction);
    }
}
