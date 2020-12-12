/**
 * <p></p>
 *
 * @author VincentHo
 * @version 0.0.1
 * @date 2020/12/12
 * @since 1.8
 */
public class SceneThread implements Runnable {

    private SceneManager sceneManager;

    public SceneThread(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void run() {
        while (!GlobalParam.isGameOver) {
            this.sceneManager.drawScene();
        }
    }
}