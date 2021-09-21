
import model.Game;
import util.view.ColorCollection;
import view.consoleView.ConsoleView;
import view.swingView.frame.GameFrame;


public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        ConsoleView cv = new ConsoleView(game);
        new GameFrame(game);
    }

}
