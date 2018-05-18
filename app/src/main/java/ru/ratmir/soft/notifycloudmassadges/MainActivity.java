package ru.ratmir.soft.notifycloudmassadges;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import ru.ratmir.soft.notifycloudmassadges.costume.FloatSeekBar;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.msg);
        FloatSeekBar seek = findViewById(R.id.cosSeeck);

        seek.setOnFloatSeekBarChangeListener(new FloatSeekBar.OnFloatSeekBarChangeListener() {
            @Override
            public void onFloatSeekProgressChanged(SeekBar seekBar, float i, boolean b) {
                txt.setText(String.format("%.1f", i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }

}
