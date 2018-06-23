package prototyping.benwl.org.coloredlightsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_manual);
        declareAutoButtonAction();
        declarePrevColorButtonAction();
        declareNextColorButtonAction();
    }

    private void declarePrevColorButtonAction() {

    }

    private void declareNextColorButtonAction() {
    }

    private void declareAutoButtonAction() {

        Button manualButton  = (Button) findViewById(R.id.buttonAuto);
        manualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(ManualActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
