package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.view.View;

public class AutoSetColorTimerTask extends SetColorTimerTask {

    public AutoSetColorTimerTask(final View wholeScreen) {
        super(wholeScreen);
    }

    @Override
    public void run() {

        switch (iColor) {
            case 0:
                iRed += colorIncrement;
                iGreen -= colorDecrement;
                iBlue -= colorDecrement;
                checkWithinThreshold(iBlue);
                break;
            case 1:
                iGreen += colorIncrement;
                iRed -= colorDecrement;
                iBlue -= colorDecrement;
                checkWithinThreshold(iBlue);
                break;
            case 2:
                iBlue += colorIncrement;
                iRed -= colorDecrement;
                iGreen -= colorDecrement;
                checkWithinThreshold(iGreen);
                break;
            case 3:
                iRed += colorIncrement;
                iGreen += colorIncrement;
                iBlue -= colorDecrement;
                checkWithinThreshold(iBlue);
                break;
            case 4:
                iGreen += colorIncrement;
                iBlue += colorIncrement;
                iRed -= colorDecrement;
                checkWithinThreshold(iRed);
                break;
            case 5:
                iRed += colorIncrement;
                iBlue += colorIncrement;
                iGreen -= colorDecrement;
                checkWithinThreshold(iGreen);
                break;
            default:
                iColor = 0;
                resetColorValues();
                break;
        }

        handler.obtainMessage(1).sendToTarget();
    }

    /**
     * Checks lower bound of color value is > 0
     *
     * @param color The color value of a single red, green, or blue in a color.
     */
    private void checkWithinThreshold(int color) {

        // Check lower color bound
        if (color < 0) {
            resetColorValues();
            iColor++;
        }
    }
}
