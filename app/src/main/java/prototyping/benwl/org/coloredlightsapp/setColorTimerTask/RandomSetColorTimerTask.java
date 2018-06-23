package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.view.View;

public class RandomSetColorTimerTask extends SetColorTimerTask {

    public RandomSetColorTimerTask(View wholeScreen) {
        super(wholeScreen);
    }

    @Override
    public void run() {

    }

    @Override
    public boolean checkWithinThreshold(int color) {

        // Check upper color bound
        if (color > colorThreshold) {
            resetColorValues();
            iColor++;
            return false;
        }

        // Check lower color bound
        if (color < 0) {
            resetColorValues();
            iColor++;
            return false;
        }
        return true;
    }
}
