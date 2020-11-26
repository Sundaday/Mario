package com.sundaday.jeu;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgfond1;
    private Image imgfond2;

    private ImageIcon icoChateau1;
    private Image imgChateau1;
    private ImageIcon icoDepart;
    private Image imgDepart;

    private ImageIcon icoMario;
    private Image imgMario;

    private int xFond1;
    private int xFond2;
    private int dx;


    //Constructeur//
    public Scene() {
        super();

        this.xFond1 = -50;
        this.dx = 0;
        this.xFond2 = 750;

        icoFond = new ImageIcon(getClass().getResource("/image/fondEcran.png"));
        imgfond1 = this.icoFond.getImage();
        imgfond2 = this.icoFond.getImage();
        icoMario = new ImageIcon(getClass().getResource("/image/marioArretDroite.png"));
        imgMario = this.icoMario.getImage();

        icoChateau1 = new ImageIcon(getClass().getResource("/image/chateau1.png"));
        imgChateau1 = this.icoChateau1.getImage();
        icoDepart = new ImageIcon(getClass().getResource("/image/depart.png"));
        imgDepart = this.icoDepart.getImage();


        this.addKeyListener(new Clavier());
        this.setFocusable(true);
        this.requestFocusInWindow();

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    //Get/Set

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    //Methodes//
    public void deplacementFond() {
        this.xFond1 = this.xFond1 - this.dx;
        this.xFond2 = this.xFond2 - this.dx;
        if (this.xFond1 == -800) {
            this.xFond1 = 800;
        } else if (this.xFond2 == -800) {
            this.xFond2 = 800;
        } else if (this.xFond1 == 800) {
            this.xFond1 = -800;
        } else if (this.xFond2 == 800) {
            this.xFond2 = -800;
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        this.deplacementFond();

        g2.drawImage(this.imgfond1, this.xFond1, 0, null); // Dessin de l'image de fond
        g2.drawImage(this.imgfond2, this.xFond2, 0, null); // Dessin de l'image de fond
        g2.drawImage(this.imgMario, 300, 245, null); // Dessin de mario
        g2.drawImage(this.imgChateau1, 10, 95, null);
        g2.drawImage(this.imgDepart, 220, 234, null);

    }


}