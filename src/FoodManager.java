import java.util.Arrays;
import java.util.Random;

/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class FoodManager {

    private Node food;

    private SceneManager sceneManager;

    public FoodManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    /**
    * 生成下一个食物
    * @return Node
    * @author: VincentHo
    * @date 2020/12/12
    */
    public Node nextFood() {

        int x = new Random().ints(1, GlobalParam.SCENE_WIDTH - 1).findFirst().getAsInt();
        int y = new Random().ints(1, GlobalParam.SCENE_HEIGHT - 1).findFirst().getAsInt();

        food = new Node(x, y, NodeType.FOOD);

        this.sceneManager.drawOnScene(Arrays.asList(food));

        return food;
    }

}