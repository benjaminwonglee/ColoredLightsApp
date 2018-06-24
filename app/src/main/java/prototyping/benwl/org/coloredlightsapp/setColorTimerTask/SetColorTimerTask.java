package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.view.View;

import java.util.TimerTask;

public abstract class SetColorTimerTask extends TimerTask {

    // The view to update
    final View wholeScreen;

    // Color limits
    private final int initialColor = 255;
    int colorIncrement = 0;
    int colorDecrement = 10;
    int colorThreshold = 255;

    // Color fields
    int iRed = initialColor;
    int iGreen = initialColor;
    int iBlue = initialColor;

    // Color choice setting integer
    int iColor = 0;

    SetColorTimerTask(View wholeScreen) {

        this.wholeScreen = wholeScreen;
    }

    @Override
    public abstract void run();

    /**
     * True if within the threshold
     *
     * @param color The color RGB integer level to check
     */
    public abstract void checkWithinThreshold(int color);

    void resetColorValues() {

        iRed = initialColor;
        iGreen = initialColor;
        iBlue = initialColor;
    }
}
