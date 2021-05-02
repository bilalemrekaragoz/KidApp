package com.example.KidApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.KidApp.MainActivity.bestPoint;
import static com.example.KidApp.SystemClass.animal_collector;
import static com.example.KidApp.SystemClass.animal_selector;

public class Level1 extends AppCompatActivity {

    ArrayList<Animals> collectedAnimals = new ArrayList<>();
    Animals selectedAnimal;
    int point;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        point=getIntent().getIntExtra("point",0);

        tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                {
                    int lang = tts.setLanguage(Locale.UK);
                    tts.speak("Find the .... "+selectedAnimal.name ,TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        collectedAnimals = animal_collector(2);

        ImageView img0 = (ImageView) findViewById(R.id.L1I0);
        ImageView img1 = (ImageView) findViewById(R.id.L1I1);

        img0.setImageResource(collectedAnimals.get(0).image);
        img0.setTag(collectedAnimals.get(0).name);
        img1.setImageResource(collectedAnimals.get(1).image);
        img1.setTag(collectedAnimals.get(1).name);


        selectedAnimal = animal_selector(collectedAnimals);
        TextView text = (TextView) findViewById(R.id.L1Name);
        text.setText(selectedAnimal.name);

        TextView pointTxt = (TextView) findViewById(R.id.L1Point);
        pointTxt.setText("Point " + point);


        TextView best = (TextView) findViewById(R.id.L1best);
        best.setText("Best Score: "+String.valueOf(bestPoint));

       timer.start();
    }

    public void exit(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("ResourceType")
    public void clicked(View v) throws InterruptedException {
        if(selectedAnimal.name.equals(v.getTag().toString()))
        {
            timer.cancel();
            tts.speak("Did It  .... ", TextToSpeech.QUEUE_FLUSH,null);
            point++;
            if(point==3)
            {
                Intent intent = new Intent(this, Level2.class);
                intent.putExtra("point",point);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent intent = new Intent(this, Level1.class);
                intent.putExtra("point",point);
                startActivity(intent);
                finish();
            }
        }
        else
        {
            gameOver();
        }

    }

    public void gameOver()
    {
        tts.speak("game over .... ", TextToSpeech.QUEUE_FLUSH,null);
        Intent intent = new Intent(this, DiaologPage.class);
        intent.putExtra("point",point);
        startActivity(intent);
        finish();
    }

     CountDownTimer timer = new CountDownTimer(26000, 1000) {

         public void onTick(long millisUntilFinished) {
             TextView timerTxt = (TextView) findViewById(R.id.L1Timer);
             timerTxt.setText(millisUntilFinished / 1000 + " seconds");
         }

         public void onFinish() {
             gameOver();
         }
     }.start();
}