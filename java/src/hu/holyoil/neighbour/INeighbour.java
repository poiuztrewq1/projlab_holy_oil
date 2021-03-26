package hu.holyoil.neighbour;

import hu.holyoil.crewmate.AbstractCrewmate;
import hu.holyoil.crewmate.AbstractSpaceship;

/**
 * Az aszteroida és a teleportkapu közös viselkedését leíró interface
 */
public interface INeighbour {
    /**
     * A Crewmatek mozgására reagáló metódus
     * @param from az az aszteroida amin a Crewmate eredetileg tartózkodik
     * @param abstractSpaceship a mozgást elvégezni készülő Crewmate
     */
    void ReactToMove(Asteroid from, AbstractSpaceship abstractSpaceship);

    /**
     * Felrobban
     */
    void Explode();
}
