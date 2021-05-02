package com.example.KidApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;

import static com.example.KidApp.MainActivity.bestPoint;

public class DiaologPage extends AppCompatActivity {
    int point;
    int win;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaolog_page);

        tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                {
                    int lang = tts.setLanguage(Locale.UK);
                }
            }
        });

        point=getIntent().getIntExtra("point",0);
        TextView pointTxt = (TextView) findViewById(R.id.LastPoint);
        pointTxt.setText("Point " + point);

        win=getIntent().getIntExtra("win",0);
        if(win==1)
        {
            TextView resultTxt = (TextView) findViewById(R.id.GameResult);
            resultTxt.setText("You Win");
        }
        else
        {
            TextView resultTxt = (TextView) findViewById(R.id.GameResult);
            resultTxt.setText("Game Over");
        }
        //we update the best point, if current point is greater than the best score we update it
        if(point>bestPoint)
        {
            bestPoint=point;
        }

        //We write the updated best point to the score file
        try {
            FileOutputStream fos = openFileOutput("score", Context.MODE_PRIVATE);
            fos.write(String.valueOf(bestPoint).getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void clicked(View v) throws InterruptedException {
        Intent intent = new Intent(this, Level1.class);
        intent.putExtra("point",0);
        startActivity(intent);
        finish();
    }

    public void main(View v) throws InterruptedException {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("point",0);
        startActivity(intent);
        finish();
    }

}