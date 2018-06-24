package prototyping.benwl.org.coloredlightsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import prototyping.benwl.org.coloredlightsapp.setColorTimerTask.ColorChooser;

public class ManualActivity extends AppCompatActivity {

    ColorChooser colorChooser = new ColorChooser();
    View wholeScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manual);
        wholeScreen = findViewById(R.id.wholeScreenViewManual);
        wholeScreen.setBackgroundColor(colorChooser.nextColor(0));
        declareAutoButtonAction();
        declarePrevColorButtonAction();
        declareNextColorButtonAction();
    }

    private void declarePrevColorButtonAction() {

        Button previous = findViewById(R.id.buttonPrevColor);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wholeScreen.setBackgroundColor(findPrevColor());
                wholeScreen.invalidate();
            }
        });
    }

    private void declareNextColorButtonAction() {

        Button next = findViewById(R.id.buttonNextColor);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wholeScreen.setBackgroundColor(findNextColor());
                wholeScreen.invalidate();
            }
        });
    }


    private int findPrevColor() {
        return colorChooser.nextColor(-1);
    }

    private int findNextColor() {
        return colorChooser.nextColor(1);
    }

    private void declareAutoButtonAction() {

        Button manualButton  = findViewById(R.id.buttonAuto);
        manualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(ManualActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
