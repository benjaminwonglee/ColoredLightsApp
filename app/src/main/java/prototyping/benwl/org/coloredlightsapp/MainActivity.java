package prototyping.benwl.org.coloredlightsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

import prototyping.benwl.org.coloredlightsapp.setColorTimerTask.AutoSetColorTimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Timer timer = rescheduleTimer();
        declareManualButtonAction(timer);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //rescheduleTimer();
    }

    public Timer rescheduleTimer() {

        Timer timer = new Timer();
        View wholeScreen = findViewById(R.id.wholeScreenViewAuto);
        AutoSetColorTimerTask timerTask = new AutoSetColorTimerTask(wholeScreen);
        timer.schedule(timerTask, 0, 200);
        return timer;
    }

    private void declareManualButtonAction(final Timer timer) {

        Button manualButton = (Button) findViewById(R.id.buttonManual);
        manualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManualActivity.class));
                finish();
            }
        });
    }

}
