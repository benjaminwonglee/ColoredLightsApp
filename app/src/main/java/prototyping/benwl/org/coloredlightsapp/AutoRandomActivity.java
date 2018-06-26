package prototyping.benwl.org.coloredlightsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

import prototyping.benwl.org.coloredlightsapp.setColorTimerTask.RandomSetColorTimerTask;

public class AutoRandomActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        timer = rescheduleTimer();
        declareManualButtonAction();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public Timer rescheduleTimer() {

        final View wholeScreen = findViewById(R.id.wholeScreenViewAuto);
        RandomSetColorTimerTask timerTask = new RandomSetColorTimerTask(wholeScreen);
        timer = new Timer();
        timer.schedule(timerTask, 0, 200);
        return timer;
    }

    private void declareManualButtonAction() {

        Button manualButton = findViewById(R.id.buttonManual);
        manualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                timer.cancel();
                timer.purge();
                startActivity(new Intent(AutoRandomActivity.this, ManualActivity.class));
            }
        });
    }

}
