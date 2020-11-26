package com.sundaday.jeu;

import java.awt.*;
import java.time.Clock;

public class Chrono implements Runnable {

    private final int PAUSE = 3; //Temps d'attente entre 2 tours de boucle

    @Override
    public void run() {

        while (true){ //Boucle infini qui va repeindre la scene

            Main.scene.repaint();

            try {
                Thread.sleep(PAUSE); // la boucle s'arrète toutes les 3 millisecondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
