/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes.Screens;

import javax.swing.JFrame;

/**
 *
 * @author Abui
 */
public class GameFrame {

    public GameFrame(boolean isMultiplayer) {
        JFrame window = new JFrame();

        GameScreen gs = new GameScreen(isMultiplayer);
        window.add(gs);
        window.pack();
        window.setVisible(true);
        gs.startGame();
    }
    
}
