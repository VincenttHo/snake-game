import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class SnakeManager {

    private List<Node> snake;

    private SceneManager sceneManager;

    private FoodManager foodManager;

    private Vector2 currentDir;

    public SnakeManager(SceneManager sceneManager, FoodManager foodManager) {
        this.sceneManager = sceneManager;
        this.foodManager = foodManager;
        currentDir = new Vector2(1, 0);
    }

    /**
    * 生成蛇
    * @return void
    * @author: VincentHo
    * @date 2020/12/12
    */
    public List<Node> initSnake() {

        snake = new ArrayList<>();

        int middleX = GlobalParam.SCENE_WIDTH / 2;
        int middleY = GlobalParam.SCENE_HEIGHT / 2;

        for(int n = 0; n < middleX / 2; n++) {
            snake.add(new Node(middleX - n, middleY, NodeType.SNAKE));
        }

        sceneManager.drawOnScene(snake);

        return snake;
    }

    public void changeDir(Vector2 newDir) {

        if(newDir.x == 1 && newDir.x == currentDir.x
                || newDir.y == 1 && newDir.y == currentDir.y) {
            return;
        }

        currentDir = newDir;

    }

    /**
    * 移动方法
    * @return void
    * @author: VincentHo
    * @date 2020/12/12
    */
    public void move() {

        Node[][] scene = sceneManager.getScene();
        Node snakeHead = snake.get(0);
        Node nextNode = scene[snakeHead.x + currentDir.x][snakeHead.y + currentDir.y];

        Vector2 lastPos = new Vector2(nextNode.x, nextNode.y);

        for(Node snakeNode : snake) {
            Vector2 tempPos = new Vector2(snakeNode.x, snakeNode.y);
            snakeNode.x = lastPos.x;
            snakeNode.y = lastPos.y;
            lastPos = tempPos;
        }

        switch (nextNode.nodeType) {
            case FOOD: {
                // 得分，长度+1
                GlobalParam.score++;
                snake.add(new Node(lastPos.x, lastPos.y, NodeType.SNAKE));
                foodManager.nextFood();
                break;
            }
            case EMPTY:  {
                // 最后一点重置成空
                scene[lastPos.x][lastPos.y].nodeType = NodeType.EMPTY;
                break;
            }
            case WALL:
            case SNAKE: {
                // game over
                GlobalParam.isGameOver = true;
                break;
            }
            default: break;
        }

        sceneManager.drawOnScene(snake);

    }

}