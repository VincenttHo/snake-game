import java.util.Scanner;

/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class InputThread implements Runnable {

    private SnakeManager snakeManager;

    public InputThread(SnakeManager snakeManager) {
        this.snakeManager = snakeManager;
    }

    @Override
    public void run() {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();

            switch (key) {
                case "w" : this.snakeManager.changeDir(new Vector2(0, -1)); break;
                case "s" : this.snakeManager.changeDir(new Vector2(0, 1)); break;
                case "a" : this.snakeManager.changeDir(new Vector2(-1, 0)); break;
                case "d" : this.snakeManager.changeDir(new Vector2(1, 0)); break;
            }

        }

    }
}