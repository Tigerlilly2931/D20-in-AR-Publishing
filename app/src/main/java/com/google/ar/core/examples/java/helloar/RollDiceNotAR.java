package com.google.ar.core.examples.java.helloar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class RollDiceNotAR extends AppCompatActivity {

    private ImageView imageViewDice;
    private Button putinAr;
    private Random rng = new Random();
    private TextView crits;

    private int randomNum;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    GifImageView gifImageView;
    int timer = 6000;
    String dicepng;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice_not_ar);

        intent = new Intent(this, HelloArActivity.class);

        crits = findViewById(R.id.critical);
        mediaPlayer = MediaPlayer.create(this, R.raw.dicerolling);
        gifImageView = findViewById(R.id.gifViewer);
        imageViewDice = findViewById(R.id.DicePic);
        putinAr = findViewById(R.id.buttonToAr);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mediaPlayer = MediaPlayer.create(RollDiceNotAR.this, R.raw.dicerolling);
                mediaPlayer.start();
                rollDice();
            }
        });

        putinAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAr();
            }
        });

        mediaPlayer = MediaPlayer.create(RollDiceNotAR.this, R.raw.dicerolling);
        mediaPlayer.start();
        rollDice();

    }

    private void rollDice(){
        randomNum = rng.nextInt(20)+1;
        crits.setVisibility(TextView.INVISIBLE);
        imageViewDice.setVisibility(ImageView.INVISIBLE);
        gifImageView.setVisibility(GifImageView.VISIBLE);

        switch (randomNum){
            case 1:
                gifImageView.setImageResource(R.drawable.dice0001);
                mediaPlayer = MediaPlayer.create(this, R.raw.manlaughing);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces1);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                        crits.setVisibility(TextView.VISIBLE);
                        mediaPlayer.start();
                        crits.setText(R.string.crit_miss);
                        crits.setTextColor(getColor(R.color.red));
                    }
                }, timer);
                break;
            case 2:
                gifImageView.setImageResource(R.drawable.dice0002);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces2);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer + 100);
                break;
            case 3:
                //imageViewDice.setImageResource(R.drawable.dicefaces3);
                gifImageView.setImageResource(R.drawable.dice0003);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces3);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 4:
                //imageViewDice.setImageResource(R.drawable.dicefaces4);
                gifImageView.setImageResource(R.drawable.dice0004);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces4);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 5:
                //imageViewDice.setImageResource(R.drawable.dicefaces5);
                gifImageView.setImageResource(R.drawable.dice0005);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces5);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer+100);
                break;
            case 6:
                //imageViewDice.setImageResource(R.drawable.dicefaces6);
                gifImageView.setImageResource(R.drawable.dice0006);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces6);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 7:
                //imageViewDice.setImageResource(R.drawable.dicefaces7);
                gifImageView.setImageResource(R.drawable.dice0007);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces7);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 8:
                //imageViewDice.setImageResource(R.drawable.dicefaces8);
                gifImageView.setImageResource(R.drawable.dice0008);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces8);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 9:
                //imageViewDice.setImageResource(R.drawable.dicefaces9);
                gifImageView.setImageResource(R.drawable.dice0009);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces9);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 10:
                //imageViewDice.setImageResource(R.drawable.dicefaces10);
                gifImageView.setImageResource(R.drawable.dice00010);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces10);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 11:
                //imageViewDice.setImageResource(R.drawable.dicefaces11);
                gifImageView.setImageResource(R.drawable.dice00011);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces11);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 12:
                //imageViewDice.setImageResource(R.drawable.dicefaces12);
                gifImageView.setImageResource(R.drawable.dice00012);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces12);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 13:
                //imageViewDice.setImageResource(R.drawable.dicefaces13);
                gifImageView.setImageResource(R.drawable.dice00013);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces13);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 14:
                //imageViewDice.setImageResource(R.drawable.dicefaces14);
                gifImageView.setImageResource(R.drawable.dice00014);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces14);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 15:
                //imageViewDice.setImageResource(R.drawable.dicefaces15);
                gifImageView.setImageResource(R.drawable.dice00015);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces15);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 16:
                //imageViewDice.setImageResource(R.drawable.dicefaces16);
                gifImageView.setImageResource(R.drawable.dice00016);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces16);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 17:
                //imageViewDice.setImageResource(R.drawable.dicefaces17);
                gifImageView.setImageResource(R.drawable.dice00017);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces17);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 18:
                //imageViewDice.setImageResource(R.drawable.dicefaces18);
                gifImageView.setImageResource(R.drawable.dice00018);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces18);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 19:
                //imageViewDice.setImageResource(R.drawable.dicefaces19);
                gifImageView.setImageResource(R.drawable.dice00019);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces19);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                    }
                }, timer);
                break;
            case 20:
                gifImageView.setImageResource(R.drawable.dice00020);
                mediaPlayer = MediaPlayer.create(this,R.raw.success);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gifImageView.setVisibility(GifImageView.INVISIBLE);
                        imageViewDice.setImageResource(R.drawable.dicefaces20);
                        imageViewDice.setVisibility(ImageView.VISIBLE);
                        crits.setVisibility(TextView.VISIBLE);
                        mediaPlayer.start();
                        crits.setText(R.string.crit_hit);
                        crits.setTextColor(getColor(R.color.green));
                    }
                }, timer);
                break;
        }

    }

    public void toAr(){
        intent.putExtra("rngNum", randomNum);
        startActivity(intent);
    }

}