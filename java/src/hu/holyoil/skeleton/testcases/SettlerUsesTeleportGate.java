package hu.holyoil.skeleton.testcases;

import hu.holyoil.crewmate.Settler;
import hu.holyoil.neighbour.Asteroid;
import hu.holyoil.neighbour.TeleportGate;
import hu.holyoil.skeleton.Logger;
import hu.holyoil.skeleton.TestCase;

/**
 * Teszteli amikor a telepes sikeresen használ egy teleport kaput.
 * Dokumentumban: 13. oldalon látható a SZEKVENCIA diagram,
 *                          29. oldalon a KOMMUNIKÁCIÓS diagram
 */
public class SettlerUsesTeleportGate extends TestCase {

    private TeleportGate gate;
    private Settler s;

    @Override
    public String Name() {
        return "Settler moves through teleport";
    }

    @Override
    protected void load() {
        Asteroid onAsteroid = new Asteroid("onAsteroid");
        Asteroid targetAsteroid = new Asteroid("targetAsteroid");
        TeleportGate pair = new TeleportGate("pair");
        s = new Settler(onAsteroid, "s");
        gate = new TeleportGate("gate");

        gate.SetHomeAsteroid(onAsteroid);
        gate.SetPair(pair);
        pair.SetHomeAsteroid(targetAsteroid);
        pair.SetPair(gate);
        targetAsteroid.SetTeleporter(pair);
        onAsteroid.SetTeleporter(gate);


    }

    @Override
    protected void start() {
        s.Move(gate);
    }
}
