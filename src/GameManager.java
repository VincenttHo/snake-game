import java.util.List;

/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class GameManager {

    public static void main(String[] args) {

        // 初始化
        SceneManager sceneManager = new SceneManager();
        Node[][] scene = sceneManager.initScene();

        FoodManager foodManager = new FoodManager(sceneManager);
        Node food = foodManager.nextFood();

        SnakeManager snakeManager = new SnakeManager(sceneManager, foodManager);
        List<Node> snake = snakeManager.initSnake();


        // 开启线程
        new Thread(new SceneThread(sceneManager)).start();
        new Thread(new SnakeThread(snakeManager)).start();
        new Thread(new InputThread(snakeManager)).start();

    }

}