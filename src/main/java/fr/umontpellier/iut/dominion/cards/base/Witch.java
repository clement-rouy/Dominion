package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Attack;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends Attack {
    public Witch() {
        super("Witch", 5);
    }

    @Override
    public void faireAction(Player p) {
        p.drawToHand();
        p.drawToHand();
    }

    @Override
    public void faireAttaque(Player p) {
        p.gainFromSupply("Curse");
    }
}