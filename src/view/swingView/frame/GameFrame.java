package view.swingView.frame;

import model.Game;
import view.swingView.panel.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Game game;
    private GamePanel gamePanel;

    public GameFrame(Game game) {
        super("2048");
        this.game = game;
        this.gamePanel = new GamePanel(game);

        setContentPane(gamePanel);

        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

}
