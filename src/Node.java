/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class Node {

    public int x;

    public int y;

    public NodeType nodeType;

    public Node(int x, int y, NodeType nodeType) {
        this.x = x;
        this.y = y;
        this.nodeType = nodeType;
    }
}