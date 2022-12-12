
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.ar.core.examples.java.common.samplerender.Mesh;
import com.google.ar.core.examples.java.helloar.HelloArActivity;
import com.google.ar.core.examples.java.helloar.R;

import java.util.Random;

//import pl.droidsonroids.gif.GifImageView;

public class CriticalRoll extends AppCompatActivity implements SensorEventListener{
    private TextView xTextView, yTextView, zTextview;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccSenAvailable, notFirstTime = false;
    private float currentX, currentY, currentZ, lastX, lastY, lastZ, xDiff, yDiff, zDiff, shakeThresh = 5f;
    private Vibrator vibrator;
    private ImageView imageViewDice;
    private Random rng = new Random();
    private TextView crits;
    //private SharedPreferences mPrefs;
    private int randomNum;
    MediaPlayer mediaPlayer;
    final Handler handler = new Handler();
    //pl.droidsonroids.gif.GifImageView gifImageView;
    int timer = 6000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //crits = findViewById(R.id.critical);
        //mediaPlayer = MediaPlayer.create(this, R.raw.dicerolling);
        //gifImageView = findViewById(R.id.gifViewer);
        //xTextView = findViewById(R.id.xTextView);
        //yTextView = findViewById(R.id.yTextView);
        //zTextview = findViewById(R.id.zTextView);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccSenAvailable = true;
        } else{
            xTextView.setText("Accelerometer sensor is not available.");
            isAccSenAvailable = false;
        }
        //imageViewDice = findViewById(R.id.DicePic);

        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dicerolling);
                mediaPlayer.start();
                rollDice();
            }
        });
    }

    private String rollDice(){
        randomNum = rng.nextInt(20) + 1;
        String texturename = null;
        crits.setVisibility(TextView.INVISIBLE);
        imageViewDice.setVisibility(ImageView.INVISIBLE);
        //gifImageView.setVisibility(GifImageView.VISIBLE);
        //mediaPlayer = MediaPlayer.create(this,R.raw.dicerolling);
        //mediaPlayer.start();
        switch (randomNum){
            case 1:
                texturename = getString(R.string.oneup);
                //return texturename;
                break;
            case 2:
                texturename = getString(R.string.twoup);
                //return texturename;
                break;
            case 3:
                texturename = getString(R.string.threeup);
                //return texturename;
                break;
            case 4:
                texturename = getString(R.string.fourup);
                //return texturename;
                break;
            case 5:
                texturename = getString(R.string.fiveup);
                //return texturename;
                break;
            case 6:
                texturename = getString(R.string.sixup);
                //return texturename;
                break;
            case 7:
                texturename = getString(R.string.sevenup);
                //return texturename;
                break;
            case 8:
                texturename = getString(R.string.eightup);
                //return texturename;
                break;
            case 9:
                texturename = getString(R.string.nineup);
               // return texturename;
                break;
            case 10:
                texturename = getString(R.string.tenup);
               // return texturename;
                break;
            case 11:
                texturename = getString(R.string.elevenup);
               // return texturename;
                break;
            case 12:
                texturename = getString(R.string.twelveup);
                //return texturename;
                break;
            case 13:
                texturename = getString(R.string.thirteenup);
               // return texturename;
                break;
            case 14:
                texturename = getString(R.string.fourteenup);
               // return texturename;
                break;
            case 15:
                texturename = getString(R.string.fifteenup);
               // return texturename;
                break;
            case 16:
                texturename = getString(R.string.sixteenup);
               // return texturename;
                break;
            case 17:
                texturename = getString(R.string.seventeenup);
               // return texturename;
                break;
            case 18:
                texturename = getString(R.string.eighteenup);
               // return texturename;
                break;
            case 19:
                texturename = getString(R.string.nineteenup);
               // return texturename;
                break;
            case 20:
                texturename = getString(R.string.twentyup);
               // return texturename;
                break;
        }

        if(texturename.equals(null)){
            //cause you've failed!
            texturename = getString(R.string.oneup);
        }
        return texturename;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        //xTextView.setText((sensorEvent.values[0] + "m/s2"));
        //yTextView.setText((sensorEvent.values[1] + "m/s2"));
        //zTextview.setText((sensorEvent.values[2] + "m/s2"));

        currentX = sensorEvent.values[0];
        currentY = sensorEvent.values[1];
        currentZ = sensorEvent.values[2];

        if(notFirstTime){
            xDiff = Math.abs(lastX - currentX);
            yDiff = Math.abs(lastY - currentY);
            zDiff = Math.abs(lastZ = currentZ);

            if((xDiff > shakeThresh && yDiff > shakeThresh) || (xDiff > shakeThresh && zDiff > shakeThresh) || (zDiff > shakeThresh && yDiff > shakeThresh)){
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                //mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dicerolling2);
                mediaPlayer.start();
                rollDice();
            }
        }

        lastX = currentX;
        lastY = currentY;
        lastZ = currentZ;
        notFirstTime = true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        rollDice();
        if(isAccSenAvailable){
            sensorManager.registerListener(this,accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAccSenAvailable){
            sensorManager.unregisterListener(this);
        }
    }
}