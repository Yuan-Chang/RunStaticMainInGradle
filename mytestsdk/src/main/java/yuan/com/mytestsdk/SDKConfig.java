package yuan.com.mytestsdk;

/**
 * Created by ychang3 on 5/31/17.
 */

public abstract class SDKConfig {
    public boolean isDog =false;
    public boolean isCat;

    @Override
    public String toString() {
        return "SDKConfig{" +
                "isDog=" + isDog +
                ", isCat=" + isCat +
                '}';
    }
}
