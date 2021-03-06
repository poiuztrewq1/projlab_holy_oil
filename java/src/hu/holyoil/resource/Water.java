package hu.holyoil.resource;

import hu.holyoil.controller.Logger;
import hu.holyoil.controller.SunController;
import hu.holyoil.neighbour.Asteroid;
import hu.holyoil.repository.ResourceBaseRepository;

import javax.swing.*;
import java.awt.*;

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
        this(ResourceBaseRepository.GetIdWithPrefix("Water"));
    }

    public Water(String name) {
        id = name;
        ResourceBaseRepository.GetInstance().Add(name, this);
    }

    /**
     * Kiírja a vizet emberileg olvasható formátumban.
     * */
    @Override
    public String toString() {
        return "Water";
    }

    /**
     * Megvalósítja az összehasonlító metódust.
     * @param abstractBaseResource az összehasonlítandó nyersanyag
     * @return igaz, ha a paraméter Vízjég volt. Egyébként hamis.
     */
    @Override
    public Boolean IsSameType(AbstractBaseResource abstractBaseResource) {
        return abstractBaseResource instanceof Water;
    }

    /**
     * Reagál a napközeliségre és elszublimál
     * @param asteroid az aszteroida amiben a nyersanyag megtalálható
     */
    @Override
    public void ReactToSunNearby(Asteroid asteroid) {
        asteroid.SetResource(null);
        Logger.Log(SunController.GetInstance(), "Water evaporated on " + asteroid.GetId());
        ReactToGettingDestroyed();
    }

    /**
     * Statikus, minden robotra jellemző ikon
     */
    protected static Image image = new ImageIcon("assets/water.gif").getImage();

    /**
     * Visszaadja az ikonját
     */
    @Override
    public Image GetImage() {
        return image;
    }
}
