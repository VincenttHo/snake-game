/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public enum NodeType {

    FOOD("$"),

    EMPTY(" "),

    SNAKE("*"),

    WALL("@");

    private String printStr;

    NodeType(String printStr) {
        this.printStr = printStr;
    }

    public String getPrintStr() {
        return printStr;
    }
}