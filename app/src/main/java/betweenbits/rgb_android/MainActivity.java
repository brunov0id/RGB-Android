package betweenbits.rgb_android;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private RelativeLayout viewMain;
    private TextView textRed;
    private TextView textGreen;
    private TextView textBlue;

    private SeekBar seekRed;
    private SeekBar seekGreen;
    private SeekBar seekBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        changeValueRed();
        changeValueGreen();
        changeValueBlue();

        initializeValues();
    }

    private void initializeViews() {
        viewMain  = (RelativeLayout) findViewById(R.id.viewMain);
        textRed   = (TextView) findViewById(R.id.textRed);
        textGreen = (TextView) findViewById(R.id.textGreen);
        textBlue  = (TextView) findViewById(R.id.textBlue);

        seekRed   = (SeekBar) findViewById(R.id.seekRed);
        seekGreen = (SeekBar) findViewById(R.id.seekGreen);
        seekBlue  = (SeekBar) findViewById(R.id.seekBlue);
    }

    private void initializeValues() {
        viewMain.setBackgroundColor(Color.rgb(seekRed.getProgress(), seekGreen.getProgress(), seekBlue.getProgress()));

        textRed.setText("" + seekRed.getProgress());
        textGreen.setText("" + seekGreen.getProgress());
        textBlue.setText("" + seekBlue.getProgress());

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    public void changeValueRed() {
        seekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textRed.setText("" + progress);
                viewMain.setBackgroundColor(Color.rgb(progress, seekGreen.getProgress(), seekBlue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void changeValueGreen() {
        seekGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textGreen.setText("" + progress);
                viewMain.setBackgroundColor(Color.rgb(seekRed.getProgress(), progress, seekBlue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void changeValueBlue() {
        seekBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textBlue.setText("" + progress);
                viewMain.setBackgroundColor(Color.rgb(seekRed.getProgress(), seekGreen.getProgress(), progress));
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
