package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.view.View;

public class RandomSetColorTimerTask extends SetColorTimerTask {

    private int tick = 0;

    public RandomSetColorTimerTask(final View wholeScreen) {
        super(wholeScreen);
    }

    @Override
    public void run() {

        tick++;
        if (tick == 1) {
            int[] colors = new int[3];
            for (int i = 0; i < colors.length; i++) {
                colors[i] = (int) (Math.random() * 150);
            }
            iRed = colors[0];
            iGreen = colors[1];
            iBlue = colors[2];
        } else if (tick > 30) {
            tick = 0;
        } else {
            if (iRed < colorThreshold && iGreen < colorThreshold && iBlue < colorThreshold) {
                int incrementValue = 3;
                iRed += incrementValue;
                iGreen += incrementValue;
                iBlue += incrementValue;
            }
        }

        handler.obtainMessage(1).sendToTarget();
    }
}
