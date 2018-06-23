package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.util.TimerTask;

public abstract class SetColorTimerTask extends TimerTask {

    // The view to update
    private final View wholeScreen;

    // Color limits
    private final int initialColor = 255;
    protected int colorIncrement = 0;
    protected int colorDecrement = 10;
    protected int colorThreshold = 255;

    // Color fields
    protected int iRed = initialColor;
    protected int iGreen = initialColor;
    protected int iBlue = initialColor;

    // Color choice setting integer
    protected int iColor = 0;

    public SetColorTimerTask(View wholeScreen) {

        this.wholeScreen = wholeScreen;
    }

    @Override
    public abstract void run();

    /**
     * True if within the threshold
     *
     * @param color The color RGB integer level to check
     * @return True if the color is within the threshold and false otherwise
     */
    public abstract boolean checkWithinThreshold(int color);

    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            wholeScreen.setBackgroundColor(Color.rgb(iRed, iGreen, iBlue));
            wholeScreen.invalidate();
        }
    };

    public void resetColorValues() {

        iRed = initialColor;
        iGreen = initialColor;
        iBlue = initialColor;
    }
}
