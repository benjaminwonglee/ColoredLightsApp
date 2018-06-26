package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.util.TimerTask;

public abstract class SetColorTimerTask extends TimerTask {

    // The view and handler to handle view updates
    private final View wholeScreen;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            wholeScreen.setBackgroundColor(Color.rgb(iRed, iGreen, iBlue));
            wholeScreen.invalidate();
        }
    };

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

    SetColorTimerTask(final View wholeScreen) {
        this.wholeScreen = wholeScreen;
    }

    @Override
    public abstract void run();

    void resetColorValues() {

        iRed = initialColor;
        iGreen = initialColor;
        iBlue = initialColor;
    }
}
