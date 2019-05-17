package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation des cartes du jeu Dominion
 */
public abstract class Card {
    /**
     * Le nom de la carte
     */
    private String name;

    /**
     * Le coût de la carte à l'achat
     */
    private int cost;

    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Getters et setters
     */
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    /**
     * Renvoie une liste des types de la carte (éléments de {@code CardType})
     * <p>
     * Le type d'une carte dépend de la sous-classe de {@code Card} à laquelle
     * la carte appartient. Ici, la méthode se contente donc de renvoyer un
     * {@code ArrayList} vide, auquel les sous-classes ajouteront les types.
     */
    public List<CardType> getTypes() {
        return new ArrayList<>();
    }

    /**
     * Renvoie une représentation de la carte sous forme de chaîne de caractères
     * (ici la fonction renvoie le nom de la carte)
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Exécute l'effet de la carte, jouée par le joueur {@code p}
     *
     * @param p joueur qui exécute l'effet de la carte
     *          <p>
     *          L'action de cette méthode dépend de la classe de la carte.
     */
    public void play(Player p) {

    }

    /**
     * Renvoie la valeur de la carte en points de victoire (c'est cette méthode
     * qui est appelée sur toutes les cartes du deck d'un joueur pour
     * déterminer le score du joueur en fin de partie)
     *
     * @param p joueur qui possède la carte (la valeur d'une carte peut dépendre du joueur qui la possède,
     *          c'est le cas des cartes Gardens)
     *          <p>
     *          Toutes les cartes qui ne sont pas de type Victoire ont une valeur de 0
     *          (la méthode devra donc être redéfinie pour les cartes ayant une valeur non nulle).
     */
    public int getVictoryValue(Player p) {

        int t = 0;
        if (this.name.equals("Curse")) {
            t = +-1;
        }
        if (this.name.equals("Estate")) {
            t = +1;
        }
        if (this.name.equals("Duchy")) {
            t = +3;
        }
        if (this.name.equals("Province")) {
            t = +6;
        }
        if (this.name.equals("Gardens")) {
            int c = p.getAllCards().size();
            float f = c / 10;
            String r;
            r = conversion(f);
            c = Integer.parseInt(r);

            t = +c;

        }

        return t;
    }

    public String conversion(float f) {

        String a = "" + f + "";

        a = a.substring(0, 1);

        return a;

    }
}