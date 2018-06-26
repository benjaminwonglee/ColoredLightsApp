package prototyping.benwl.org.coloredlightsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

import prototyping.benwl.org.coloredlightsapp.setColorTimerTask.AutoSetColorTimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rescheduleTimer();
        declareModeChangeButtonAction();
    }

    @Override
    protected void onResume() {
        super.onResume();
        timer = rescheduleTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        timer.purge();
    }

    public Timer rescheduleTimer() {

        final View wholeScreen = findViewById(R.id.wholeScreenViewAuto);
        AutoSetColorTimerTask timerTask = new AutoSetColorTimerTask(wholeScreen);
        timer = new Timer();
        timer.schedule(timerTask, 0, 200);
        return timer;
    }

    private void declareModeChangeButtonAction() {

        Button manualButton = findViewById(R.id.buttonManual);
        manualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                timer.cancel();
                timer.purge();
                startActivity(new Intent(MainActivity.this, AutoRandomActivity.class));
            }
        });
    }

}
