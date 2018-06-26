package prototyping.benwl.org.coloredlightsapp.setColorTimerTask;

import android.graphics.Color;

public class ColorChooser {

    private int currentColorNumber = 0;

    public int nextColor(int direction) {

        int currentColor;
        currentColorNumber += direction;
        switch (currentColorNumber) {
            case -1:
                currentColorNumber = 6;
                currentColor = Color.rgb(255, 255, 255);
                break;
            case 0:
                currentColor = Color.rgb(255, 0, 0);
                break;
            case 1:
                currentColor = Color.rgb(0, 255, 0);
                break;
            case 2:
                currentColor = Color.rgb(0, 0, 255);
                break;
            case 3:
                currentColor = Color.rgb(255, 255, 0);
                break;
            case 4:
                currentColor = Color.rgb(255, 0, 255);
                break;
            case 5:
                currentColor = Color.rgb(0, 255, 255);
                break;
            case 6:
                currentColor = Color.rgb(255, 255, 255);
                break;
            default:
                currentColorNumber = 0;
                currentColor = Color.rgb(255, 0, 0);
                break;
        }
        return currentColor;
    }

}
