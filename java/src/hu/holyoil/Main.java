package hu.holyoil;

import hu.holyoil.commandhandler.loadcommand.LoadCommandHandler;
import hu.holyoil.controller.*;
import hu.holyoil.skeleton.Logger;
import hu.holyoil.skeleton.TestFramework;

/**
 * A program futására írt osztály, amelyben a main metódus lakik.
 */
public class Main {

    /**
     * Segéd-tagváltozó, amelynek segítségével be tudjuk állítani, tesztelő üzemmódban induljon a program.
     */
    public static final Boolean isTestMode = false;
    private static int uniqueId;
    public static Boolean isRandomEnabled;

    public static int GetId() {

        uniqueId++;
        return uniqueId;

    }

    /**
     * A program központi indító függvénye.
     * @param args program indításakor megadott argumentumok
     */
    public static void main(String[] args) {

        uniqueId = -1;
        isRandomEnabled = true;

        if (isTestMode) {
            TestFramework.getInstance().AddTestcases();
            TestFramework.getInstance().RunTestcases();
        }

        // Making sure every controller already existing
        Logger.SetEnabled(false);
        SunController.GetInstance();
        AIController.GetInstance();
        GameController.GetInstance();
        TurnController.GetInstance();
        Logger.SetEnabled(true);

        InputOutputController.GetInstance().ParseCommand(System.in);
    }

}
