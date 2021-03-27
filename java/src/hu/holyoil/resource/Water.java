package hu.holyoil.resource;

import hu.holyoil.Main;
import hu.holyoil.crewmate.IStorageCapable;
import hu.holyoil.neighbour.Asteroid;
import hu.holyoil.skeleton.Logger;
/**
 * Vízjég.
 * Aszteroida magjában megtalálható nyersanyag egy fajtája.
 * Ősosztálya az AbstractBaseResource
 */
public class Water extends AbstractBaseResource {
    /**
     * Paraméter nélküli konstruktor.
     */
    public Water() {
        id = Main.GetId();
    }

    /**
     * Kiírja a vizet emberileg olvasható formátumban.
     * */
    @Override
    public String toString() {
        return "WATER " + id;
    }

    /**
     * Megvalósítja az összehasonlító metódust.
     * @param abstractBaseResource az összehasonlítandó nyersanyag
     * @return igaz, ha a paraméter Vízjég volt. Egyébként hamis.
     */
    @Override
    public Boolean IsSameType(AbstractBaseResource abstractBaseResource) {
        //Logger.Log(this,"Being compared to " + Logger.GetName(abstractBaseResource));
        //Logger.Return();
        return abstractBaseResource instanceof Water;
    }

    /**
     * Reagál a napközeliségre és elszublimál
     * @param asteroid az aszteroida amiben a nyersanyag megtalálható
     */
    @Override
    public void ReactToSunNearby(Asteroid asteroid) {
        Logger.Log(this,"Reacting to Sun nearby");
        asteroid.SetResource(null);
        Logger.Return();
    }
}
