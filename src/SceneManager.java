import java.util.List;

/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class SceneManager {

    private Node[][] scene;

    /**
    * 生成场景
    * @return Node[][]
    * @author: VincentHo
    * @date 2020/12/12
    */
    public Node[][] initScene() {

        scene = new Node[GlobalParam.SCENE_WIDTH][GlobalParam.SCENE_HEIGHT];

        for(int x = 0; x < GlobalParam.SCENE_WIDTH; x++) {
            for(int y = 0; y < GlobalParam.SCENE_HEIGHT; y++) {
                if(x == 0 || x == GlobalParam.SCENE_WIDTH - 1 || y == 0 || y == GlobalParam.SCENE_HEIGHT - 1) {
                    scene[x][y] = new Node(x, y, NodeType.WALL);
                } else {
                    scene[x][y] = new Node(x, y, NodeType.EMPTY);
                }
            }
        }

        return scene;
    }

    /**
    * 绘制场景
    * @return void
    * @author: VincentHo
    * @date 2020/12/12
    */
    public void drawScene() {

        StringBuffer sb = new StringBuffer();

        for(int y = 0; y < GlobalParam.SCENE_HEIGHT; y++) {
            for(int x = 0; x < GlobalParam.SCENE_WIDTH; x++) {
                sb.append(scene[x][y].nodeType.getPrintStr());
            }
            sb.append("\n");
        }

        sb.append("得分：" + GlobalParam.score + "\n");

        System.out.println(sb.toString());

    }

    public void drawOnScene(List<Node> nodes) {

        for(Node node : nodes) {
            scene[node.x][node.y].nodeType = node.nodeType;
        }

    }

    public Node[][] getScene() {
        return scene;
    }
}