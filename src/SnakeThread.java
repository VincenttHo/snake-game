/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class SnakeThread implements Runnable {

    private SnakeManager snakeManager;

    public SnakeThread(SnakeManager snakeManager) {
        this.snakeManager = snakeManager;
    }

    @Override
    public void run() {
        while(!GlobalParam.isGameOver) {
            this.snakeManager.move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}